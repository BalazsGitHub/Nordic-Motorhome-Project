package teletearbies.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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

    @Column(nullable = true, name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(nullable = true, name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    @Column(name = "consent_to_terms")
    private boolean consentToTerms;


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
        double price = motorhome.getBrand().getDailyBrandPrice() * numberOfDays;

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
      /*  // creating the date 1 with sample input date.
        Date date1 = new Date(2022, 11, 1);

        // creating the date 2 with sample input date.
        Date date2 = new Date(2022, 11, 30);

        // getting milliseconds for both dates
        long date1InMs = date1.getTime();
        long date2InMs = date2.getTime();

        // getting the diff between two dates.
        long timeDiff = 0;

        if(date1InMs > date2InMs) {
            timeDiff = date1InMs - date2InMs;
        } else {
            timeDiff = date2InMs - date1InMs;
        }

        // converting diff into days
        int daysDiff = (int) (timeDiff / (1000 * 60 * 60* 24));

        return daysDiff;*/

        //just want it to return any value, so I choose -1 to not be misleading
        if (startDate == null){
            return 0;
        }

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

    public boolean isConsentToTerms() {
        return consentToTerms;
    }

    public void setConsentToTerms(boolean consentToTerms) {
        this.consentToTerms = consentToTerms;
    }
}
