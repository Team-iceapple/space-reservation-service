package iceapple.spacereservationservice.reservation.dto;

import java.util.List;
import java.util.Map;

public class ReservationResponse {

    private String id;
    private List<Integer> times;
    private String date;
    private Map<String, String> space;

    public ReservationResponse(final String id, final List<Integer> times, final String date, final Map<String, String> space) {
        this.id = id;
        this.times = times;
        this.date = date;
        this.space = space;
    }

    public String getId() {
        return id;
    }

    public List<Integer> getTimes() {
        return times;
    }

    public String getDate() {
        return date;
    }

    public Map<String, String> getSpace() {
        return space;
    }
}