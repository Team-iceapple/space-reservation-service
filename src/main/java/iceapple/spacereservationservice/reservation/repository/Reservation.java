package iceapple.spacereservationservice.reservation.repository;

import java.util.List;

public class Reservation {
    private Long studentNumber;
    private String phoneNumber;
    private Long password;
    private String spaceId;
    private String date;
    private List<Integer> times; // [9, 10, 11]

    public Reservation() {}

    @Override
    public String toString() {
        return "Reservation{" +
                "studentNumber=" + studentNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password=" + password +
                ", spaceId='" + spaceId + '\'' +
                ", date='" + date + '\'' +
                ", times=" + times +
                '}';
    }

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

    public Reservation(final Long studentNumber, final String phoneNumber, final Long password, final String spaceId, final String date, final List<Integer> times) {
        this.studentNumber = studentNumber;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.spaceId = spaceId;
        this.date = date;
        this.times = times;
    }
}
