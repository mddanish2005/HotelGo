package hotel.management.system.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Customer {

    private String id;
    private String idNumber;
    private String name;
    private String gender;
    private String country;
    private String roomNo;
    private LocalDateTime checkInTime;
    private BigDecimal deposit;

    // No-arg constructor
    public Customer() {
    }

    // constructor
    public Customer(String id, String idNumber, String name,
                    String gender, String country, String roomNo,
                    LocalDateTime checkInTime, BigDecimal deposit) {
        this.id = id;
        this.idNumber = idNumber;
        this.name = name;
        this.gender = gender;
        this.country = country;
        this.roomNo = roomNo;
        this.checkInTime = checkInTime;
        this.deposit = deposit;
    }

    // getter & setter
    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }
    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }
}
