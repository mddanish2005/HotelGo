/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system.model;

/**
 *
 * @author danish
 */

public class Room {
    
    String roomNo;
    String avail;
    String cleanStatus;
    Float price;
    String bedType;
    
    public Room(String roomNo,
    String avail,
    String cleanStatus,
    Float price,
    String bedType)
    {
       
        this.roomNo = roomNo;
        this.avail = avail;
        this.cleanStatus = cleanStatus;
        this.price = price;
        this.bedType = bedType;
    
    }
    
      public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    // Getter & Setter for avail
    public String getAvail() {
        return avail;
    }

    public void setAvail(String avail) {
        this.avail = avail;
    }

    // Getter & Setter for cleanStatus
    public String getCleanStatus() {
        return cleanStatus;
    }

    public void setCleanStatus(String cleanStatus) {
        this.cleanStatus = cleanStatus;
    }

    // Getter & Setter for price
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    // Getter & Setter for bedType
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }
    
    
    
}
