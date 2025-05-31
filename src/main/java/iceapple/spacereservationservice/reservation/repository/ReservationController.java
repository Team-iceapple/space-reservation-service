package iceapple.spacereservationservice.reservation.repository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/reservations-info")
    public ResponseEntity<Map<String, Object>> getUserReservations(
            @RequestBody final Map<String, String> request) {

        Long studentNumber = Long.valueOf(request.get("student_number"));
        Long password = Long.valueOf(request.get("password"));

        List<Map<String, Object>> result = reservationService.findReservationsByStudent(studentNumber, password);
        return ResponseEntity.ok(Map.of("reservations", result));
    }

    @PostMapping("/reservations")
    public ResponseEntity<?> reserveRoom(@RequestBody final Reservation request) {
        try {
            Map<String, Object> response = reservationService.createReservation(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @DeleteMapping("/reservations")
    public ResponseEntity<?> cancelReservations(@RequestBody final Map<String, List<String>> request) {
        try {
            List<String> ids = request.get("reservation_id");
            reservationService.cancelReservations(ids);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}