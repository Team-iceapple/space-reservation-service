package iceapple.spacereservationservice.space;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/space")
public class SpaceController {

    private final SpaceService spaceService;

    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllSpaces() {
        List<Space> spaces = spaceService.getAllSpaces();
        return ResponseEntity.ok(Map.of("space", spaces)); // 200 OK
    }

    @GetMapping("/{spaceId}")
    public ResponseEntity<Map<String, Object>> getSpaceDetail(
            @PathVariable("spaceId") final Long spaceId,
            @RequestParam(required = false) final String date
    ) {
        Map<String, Object> spaceDetail = spaceService.getSpaceDetail(spaceId, date);
        return ResponseEntity.ok(Map.of("space", spaceDetail)); // 200 OK
    }
}