package hotel.management.system.model;

public class Driver {

    private int driverId;
    private String name;
    private Integer age;        // nullable
    private String carModel;
    private String carCompany;
    private String location;
    private String gender;      // Male / Female / Other
    private String availability; // Available / Unavailable

    public Driver( String name, Integer age, String carModel,
                  String carCompany, String location, String gender,
                  String availability) {
       
        this.name = name;
        this.age = age;
        this.carModel = carModel;
        this.carCompany = carCompany;
        this.location = location;
        this.gender = gender;
        this.availability = availability;
    }

    // ✅ Getters & Setters
    public int getDriverId() {
        return driverId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
