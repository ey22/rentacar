package eylul.rentacar.reservations;

public class ReservationDetailsDto {

    private Long reservationId;
    private String carName;
    private String carBrand;
    private String extraName;
    private String location;
    private String pickUpDate;
    private String returnDate;
    private Float totalPrice;


    public ReservationDetailsDto() {}


    public ReservationDetailsDto(Long reservationId, String carName, String carBrand, String extraName,String location, String pickUpDate, String returnDate, Float totalPrice) {
        this.reservationId = reservationId;
        this.carName = carName;
        this.carBrand = carBrand;
        this.extraName = extraName;
        this.location = location;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.totalPrice = totalPrice;
    }

    // Getter ve Setter metotları
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getExtraName() {
        return extraName;
    }

    public void setExtraName(String extraName) {
        this.extraName = extraName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ReservationDetailsDto{" +
                "reservationId=" + reservationId +
                ", carName='" + carName + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", extraName='" + extraName + '\'' +
                ", location='" + location  + '\'' +
                ", pickUpDate='" + pickUpDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
