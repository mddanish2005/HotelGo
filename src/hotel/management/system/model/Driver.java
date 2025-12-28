
package hotel.management.system.model;



public class Driver {

    private String name;
    private int age;
    private String carModel;
    private String carCompany;
    private String location;
    private String gender;
    private String availability;

    // No-arg constructor (useful later)
    public Driver() {
    }

    // Parameterized constructor
    public Driver(String name, int age, String carModel,
                  String carCompany, String location,
                  String gender, String availability) {
        this.name = name;
        this.age = age;
        this.carModel = carModel;
        this.carCompany = carCompany;
        this.location = location;
        this.gender = gender;
        this.availability = availability;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

