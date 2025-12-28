package hotel.management.system.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Customer {

    private int customerId;
    private String idType;
    private String idNumber;
    private String name;
    private String gender;
    private String country;
    private String roomNo;
    private LocalDateTime checkInTime;
    private BigDecimal deposit;

   
    // constructor
    public Customer(String idType, String idNumber, String name,
                    String gender, String country, String roomNo,
                     BigDecimal deposit) {
        
        this.idType = idType;
        this.idNumber = idNumber;
        this.name = name;
        this.gender = gender;
        this.country = country;
        this.roomNo = roomNo;
        this.deposit = deposit;
    }
    
        public Customer(int customerId ,String idType, String idNumber, String name,
                    String gender, String country, String roomNo, LocalDateTime checkInTime,
                     BigDecimal deposit) {
            
        this.customerId = customerId;
        this.idType = idType;
        this.idNumber = idNumber;
        this.name = name;
        this.gender = gender;
        this.country = country;
        this.roomNo = roomNo;
        this.checkInTime = checkInTime;
        this.deposit = deposit;
    }
    
    
    
    public int getCustomerId() {
    return customerId;
}

public String getIdType() {
    return idType;
}

public void setIdType(String idType) {
    this.idType = idType;
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

public LocalDateTime getCheckInTime() {
    return checkInTime;
}


public BigDecimal getDeposit() {
    return deposit;
}

public void setDeposit(BigDecimal deposit) {
    this.deposit = deposit;
}


   
}
