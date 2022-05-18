package teletearbies.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    //indicates that the ID should be generated automatically
    //identity means that will be unique
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = false, length = 255, name = "start_date")
    private String startDate;

    @Column(nullable = false,unique = false, length = 255, name = "end_date")
    private String endDate;


    @Column(nullable = false, unique = false, length = 255, name = "pickup_point")
    private String pickUpPoint;

    @Column(nullable = false, unique = false, length = 255, name = "dropoff_point")
    private String dropOffPoint;

    @Column(nullable = false,unique = false, length = 255, name = "customer_full_name")
    private String fullName;

    @Column(nullable = false,unique = false, length = 255, name = "customer_phone_number")
    private String phoneNumber;

    @Column(nullable = false,unique = false, length = 255, name = "customer_address")
    private String address;

    @Column(nullable = false,unique = false, length = 255, name = "customer_driver_number")
    private String driversNumber;

    @Column(nullable = false,unique = false, length = 255, name = "customer_card_number")
    private String cardNumber;


    //@Column(nullable = false, unique = false, length = 255, name = "extra_kilometer")
    //private double extraKilometer;

    //private boolean isServiced;

    //private boolean isFuelHalf;

    @ManyToOne
    private Motorhome motorhome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "season_id")
    private Season seasonId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cancellation_id")
    private Cancellation cancellationId;

    @OneToMany(mappedBy = "booking")
    private List<BookedExtras> bookedExtras;

    public Booking(){}

    public Booking(String startDate, String endDate, String pickUpPoint, String dropOffPoint, String fullName, String phoneNumber, String address, String driversNumber, String cardNumber) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickUpPoint = pickUpPoint;
        this.dropOffPoint = dropOffPoint;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.driversNumber = driversNumber;
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public void setDriversNumber(String driverNumber) {
        this.driversNumber = driverNumber;
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

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Season getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Season seasonId) {
        this.seasonId = seasonId;
    }

    public Cancellation getCancellationId() {
        return cancellationId;
    }

    public void setCancellationId(Cancellation cancellationId) {
        this.cancellationId = cancellationId;
    }

    public List<BookedExtras> getBookedExtras() {
        return bookedExtras;
    }

    public void setBookedExtras(List<BookedExtras> bookedExtras) {
        this.bookedExtras = bookedExtras;
    }
}
