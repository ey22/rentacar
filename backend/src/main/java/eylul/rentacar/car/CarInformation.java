package eylul.rentacar.car;
import jakarta.persistence.*;
//Represent detailed information about cars
@Entity
@Table(name="car_information") //Name of table in database
public class CarInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Unique identifier for the car
    private Long id;
    //Other information
    private String name;
    private String brand;
    @Column(name = "transmission_type") //Column name in the table
    private String transmissionType;
    @Column(name = "fuel_type")
    private String fuelType;
    private double price;
    @Column(name = "image_url")
    private String imageUrl;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
