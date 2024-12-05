package eylul.rentacar.reservations;
import eylul.rentacar.Car.CarInformation;
import eylul.rentacar.protectionplans.PlansInformation;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="reservation_information")

public class ReservationInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private int carId;

    @ManyToOne
    @JoinColumn(name = "carId", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private CarInformation car;

    @ManyToOne
    @JoinColumn(name = "protectionId", referencedColumnName = "id", insertable = false, updatable = false)
    private PlansInformation plansInformation; // Many-to-One ilişki

    private Integer protectionId;

    private String location;

    @Column(nullable = false)
    private Date pickUpDate;

    @Column(nullable = false)
    private Date returnDate;

    private float totalPrice;

    public ReservationInformation(){}

    public ReservationInformation(Long reservationId, int userId, int carId, int protectionId, String location, Date pickUpDate, Date returnDate, float totalPrice){
        this.reservationId=reservationId;
        this.userId=userId;
        this.carId=carId;
        this.protectionId=protectionId;
        this.location=location;
        this.pickUpDate=pickUpDate;
        this.returnDate=returnDate;
        this.totalPrice=totalPrice;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public CarInformation getCar() {
        return car;
    }
    public void setCar(CarInformation car) {
        this.car = car;
    }
    public PlansInformation getPlansInformation() {
        return plansInformation;
    }

    public void setProtectionPlan(PlansInformation plansInformation) {
        this.plansInformation = plansInformation;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Integer getProtectionId() {
        return protectionId;
    }

    public void setProtectionId(Integer protectionId) {
        this.protectionId = protectionId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
