package hotel.management.system.model;

import java.math.BigDecimal;

public class Room {

    private String roomNo; //Primary Key
    private String availability;
    private String cleanStatus;
    private BigDecimal price;
    private String bedType;

  
    public Room(String roomNo, String availability, String cleanStatus,
                BigDecimal price, String bedType) {
        this.roomNo = roomNo;
        this.availability = availability;
        this.cleanStatus = cleanStatus;
        this.price = price;
        this.bedType = bedType;
    }

    // Getters & Setters
    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getCleanStatus() {
        return cleanStatus;
    }

    public void setCleanStatus(String cleanStatus) {
        this.cleanStatus = cleanStatus;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }
}
