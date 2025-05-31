package iceapple.spacereservationservice.reservation.repository;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final Map<String, Reservation> reservationMap = new ConcurrentHashMap<>();

    public Map<String, Object> createReservation(Reservation request) {
        // 충돌 검사
        for (Reservation existing : reservationMap.values()) {
            if (existing.getSpaceId().equals(request.getSpaceId())
                    && existing.getDate().equals(request.getDate())
                    && existing.getTimes().stream().anyMatch(request.getTimes()::contains)) {
                throw new IllegalStateException("이미 예약된 시간입니다.");
            }
        }

        String id = UUID.randomUUID().toString();
        reservationMap.put(id, request);

        return Map.of("reservationId", id);
    }

    public List<Map<String, Object>> findReservationsByStudent(Long studentNumber, Long password) {
        return reservationMap.entrySet().stream()
                .filter(entry -> {
                    Reservation resv = entry.getValue();
                    return resv.getStudentNumber().equals(studentNumber) &&
                            resv.getPassword().equals(password);
                })
                .map(entry -> {
                    Reservation resv = entry.getValue();
                    return Map.of(
                            "id", entry.getKey(),
                            "times", resv.getTimes(),
                            "date", resv.getDate(),
                            "space", Map.of(
                                    "id", resv.getSpaceId(),
                                    "name", "회의실" // 추후 DB 연동시 이름 매핑 가능
                            )
                    );
                })
                .collect(Collectors.toList());
    }

    public void cancelReservations(List<String> ids) {
        for (String id : ids) {
            if (!reservationMap.containsKey(id)) {
                throw new NoSuchElementException("존재하지 않는 reservation-id");
            }
            reservationMap.remove(id);
        }
    }
}
