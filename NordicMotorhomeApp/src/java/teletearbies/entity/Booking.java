package teletearbies.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

//It is a JPA (Java Persistence API class), meaning: It is a Java thing that allows you to manipulate data between a Java object and a database.
//@Entity annotation specifies that the class (Booking) is an entity and is mapped to a table.
@Entity
//@Table annotation is optional, we use it to customize the name of our tables that should be mapped to this entity.
@Table(name = "booking")

public class Booking {

    @Id
    //By marking the @Id field with @GeneratedValue we are now enabling id generation. Which means that the (database) will generate an Id value for us and handle the auto incrementing.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //We use the column annotation to create a customized column in our tables
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
    //@DateTimeFormat Declares that the parameter should be formatted as a date or time.
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(nullable = true, name = "end_date")
    //@DateTimeFormat Declares that the parameter should be formatted as a date or time.
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Column(nullable = false, unique = false, length = 255, name = "number_of_days")
    private int numberOfDays;

    @Column(nullable = false, unique = false, length = 255, name = "final_price")
    private double finalPrice;

    @ManyToOne
    //@ManyToOne is another JPA annotation that creates relationships between entity classes
    //many-to-one mapping means that many rows in a table is mapped to one row in another table.

    @JoinColumn(name = "motorhome_id")
    //The @JoinColumn annotation allows you to specify the Foreign Key column name
    private Motorhome motorhome;

    @ManyToMany
    //@ManyToMany is another JPA annotation that specify the mapping of a many-to-many table relationship.
    //many-to-many mapping means that many rows in a table are mapped/can relate to many other rows in another table.

    //We provide the name of the join table (booked_extras) as well as the foreign keys with the @JoinColumn annotations.
    // The joinColumn attribute joinColumns, where we are defining the columns that are to be joined, so joinColumn refers to the booking table
    // and the inverseJoinColumns will refer to the Extras table.
    @JoinTable(name = "booked_extras",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "extras_id"))
    //A HashSet is used because it guarantees that two values which are equal to each other (which are equality checked by looking at their GetHashCode and Equals methods) only appear once in the collection
    //it is part of the ICollection
    private Set<Extra> extras = new HashSet<>();

    @ManyToOne
    //@ManyToOne is another JPA annotation that creates relationships between entity classes
    //many-to-one mapping means that many rows in a table is mapped to one row in another table.
    @JoinColumn(name = "cancellation_id")
    private Cancellation cancellation;

    @ManyToOne
    //@ManyToOne is another JPA annotation that creates relationships between entity classes
    //many-to-one mapping means that many rows in a table is mapped to one row in another table.
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    //@ManyToOne is another JPA annotation that creates relationships between entity classes
    //many-to-one mapping means that many rows in a table is mapped to one row in another table.
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
        this.extraKilometer = 0;
        this.distanceFromNMR = 0;
        this.numberOfDays = calculateDay();
        this.finalPrice = calculatePrice();
    }

    public int calculateDay() {
        if (startDate == null) {
            return 0;
        }

        //Calculates days between two local dates
        return (int) ChronoUnit.DAYS.between(startDate, endDate);
    }

    public double calculatePrice() {
        //Get price by multiplying the daily price of the motorhome's brand with the number of days.
        double price = motorhome.getBrand().getDailyBrandPrice() * numberOfDays;

        //Adding the cost of each extra chosen for the booking.
        for (Extra extra : extras
        ) {
            price += extra.getPrice();
        }

        //Adding extra kilometer to the price (1 km = 1 €)
        price += extraKilometer;

        //If fuel of returned motorhome is below half, add 70 € to price.
        if(fuelBelowHalf){
            price += 70;
        }

        //Pick up point distance from rental is added to price (1 km = 0.7 €)
        price += distanceFromNMR * 0.7;

        //Depending on the current season, price is multiplied by season's price multiplier.
        price *= season.getSeasonPriceMultiplier();

        //Depending on cancellation status, price is multiplied by cancellation percentage / 100.
        price *= (cancellation.getPercentage() / 100);

        //Price is rounded to 2 decimal places.
        double roundedPrice = Math.round(price*100.0)/100.0;

        return roundedPrice;
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
