package teletearbies.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    //indicates that the ID should be generated automatically
    //identity means that will be unique
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = false, length = 255, name = "pickup_point")
    private String pickUpPoint;

    @Column(nullable = false, unique = false, length = 255, name = "dropoff_point")
    private String dropOffPoint;

    @Column(nullable = false, unique = false, length = 255, name = "customer_full_name")
    private String fullName;

    @Column(nullable = false, unique = false, length = 255, name = "customer_phone_number")
    private String phoneNumber;

    @Column(nullable = false, unique = false, length = 255, name = "customer_address")
    private String address;

    @Column(nullable = false, unique = false, length = 255, name = "customer_driver_number")
    private String driversNumber;

    @Column(nullable = false, unique = false, length = 255, name = "customer_card_number")
    private String cardNumber;

    @Column(nullable = false, unique = false, length = 255, name = "extra_kilometer")
    private double extraKilometer;

    @Column(nullable = false, unique = false, name = "fuel_below_half")
    private boolean fuelBelowHalf;

    @Column(nullable = false, unique = false, name = "distance_from_nmr")
    private double distanceFromNMR;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;

    @Column(nullable = false, unique = false, length = 255, name = "number_of_days")
    private int numberOfDays;

    @Column(nullable = false, unique = false, length = 255, name = "final_price")
    private double finalPrice;

    @ManyToOne
    @JoinColumn(name = "motorhome_id")
    private Motorhome motorhome;

    @ManyToMany
    @JoinTable(name = "booked_extras",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "extras_id"))
    private Set<Extra> extras = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "cancellation_id")
    private Cancellation cancellation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;


    public Booking() {
    }

    public Booking(String pickUpPoint, String dropOffPoint, String fullName, String phoneNumber, String address, String driversNumber, String cardNumber, Motorhome motorhome, Set<Extra> extras, Cancellation cancellation, User user, Season season) {
        this.pickUpPoint = pickUpPoint;
        this.dropOffPoint = dropOffPoint;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.driversNumber = driversNumber;
        this.cardNumber = cardNumber;
        this.motorhome = motorhome;
        this.extras = extras;
        this.cancellation = cancellation;
        this.user = user;
        this.season = season;
        this.numberOfDays = calculateDay();
        this.finalPrice = calculatePrice();
        this.extraKilometer = 0;
        this.distanceFromNMR = 0;
    }


    public double calculatePrice() {
        double price = motorhome.getBrand().getDailyBrandPrice() * calculateDay();

        for (Extra extra : extras
        ) {
            price += extra.getPrice();
        }

        price += extraKilometer;
        if(fuelBelowHalf){
            price += 70;
        }
        price += distanceFromNMR * 0.7;
        price *= season.getSeasonPriceMultiplier();
        price *= (cancellation.getPercentage() / 100);

        return price;
    }

    public int calculateDay() {
        Period period = Period.between(startDate, endDate);

        int daysBetween = period.getDays();

        return daysBetween;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(String pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public String getDropOffPoint() {
        return dropOffPoint;
    }

    public void setDropOffPoint(String dropOffPoint) {
        this.dropOffPoint = dropOffPoint;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDriversNumber() {
        return driversNumber;
    }

    public void setDriversNumber(String driversNumber) {
        this.driversNumber = driversNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Motorhome getMotorhome() {
        return motorhome;
    }

    public void setMotorhome(Motorhome motorhome) {
        this.motorhome = motorhome;
    }

    public Motorhome getMotorhomeId() {
        return motorhome;
    }

    public void setMotorhomeId(Motorhome motorhome) {
        this.motorhome = motorhome;
    }

    public Set<Extra> getExtras() {
        return extras;
    }

    public void setExtras(Set<Extra> extras) {
        this.extras = extras;
    }

    public Cancellation getCancellation() {
        return cancellation;
    }

    public void setCancellation(Cancellation cancellation) {
        this.cancellation = cancellation;
    }

    public Cancellation getCancellationId() {
        return cancellation;
    }

    public void setCancellationId(Cancellation cancellation) {
        this.cancellation = cancellation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public Season getSeasonId() {
        return season;
    }

    public void setSeasonId(Season season) {
        this.season = season;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getExtraKilometer() {
        return extraKilometer;
    }

    public void setExtraKilometer(double extraKilometer) {
        this.extraKilometer = extraKilometer;
    }

    public boolean isFuelBelowHalf() {
        return fuelBelowHalf;
    }

    public void setFuelBelowHalf(boolean fuelHalf) {
        this.fuelBelowHalf = fuelHalf;
    }

    public double getDistanceFromNMR() {
        return distanceFromNMR;
    }

    public void setDistanceFromNMR(double distanceFromNMR) {
        this.distanceFromNMR = distanceFromNMR;
    }
}
