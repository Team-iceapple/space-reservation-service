package iceapple.spacereservationservice.reservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import iceapple.spacereservationservice.reservation.repository.Reservation;

import java.util.List;

public class ReservationRequest {

    @JsonProperty("student_number")
    private Long studentNumber;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("password")
    private Long password;

    @JsonProperty("space_id")
    private String spaceId;

    private String date;
    private List<Integer> times;

    // 기본 생성자
    public ReservationRequest() {}

    // Getters & Setters
    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Integer> getTimes() {
        return times;
    }

    public void setTimes(List<Integer> times) {
        this.times = times;
    }

    // DTO → Entity 변환 메서드
    public Reservation toEntity() {
        return new Reservation(studentNumber, phoneNumber, password, spaceId, date, times);
    }
}