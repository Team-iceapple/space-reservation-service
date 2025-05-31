package iceapple.spacereservationservice.space;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SpaceService {

    // 가상의 회의실 목록
    private static final List<Space> spaceList = List.of(
            new Space(1L, "N5504", "LED TV 미러링, 칠판, 4인 테이블 해당 회의실은 선착순 배정입니다"),
            new Space(2L, "N5511", "LED TV 미러링, 칠판, 7인 테이블")
    );

    // 예약 개수 임시 데이터 (9시 ~ 18시까지 총 10개 타임슬롯)
    private static final Map<Long, int[]> reservationMap = Map.of(
            1L, new int[]{1, 2, 1, 0, 4, 0, 0, 3, 3, 2},
            2L, new int[]{0, 1, 0, 1, 0, 1, 1, 1, 1, 1}
    );

    public List<Space> getAllSpaces() {
        return spaceList;
    }

    public Map<String, Object> getSpaceDetail(Long spaceId, String date) {
        String spaceName = spaceList.stream()
                .filter(s -> s.getId().equals(spaceId))
                .findFirst()
                .map(Space::getName)
                .orElse("Unknown");

        int[] count = reservationMap.getOrDefault(spaceId, new int[10]);

        return Map.of(
                "name", spaceName,
                "count", count
        );
    }
}