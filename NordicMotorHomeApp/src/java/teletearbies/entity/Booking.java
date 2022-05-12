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

    @Column(nullable = false, unique = false, length = 255, name = "pickup_point")
    private String pickUpPoint;

    @Column(nullable = false, unique = false, length = 255, name = "dropoff_point")
    private String dropOffPoint;

    @Column(nullable = false, unique = false, length = 255, name = "extra_kilometer")
    private double extraKilometer;

    private boolean isServiced;

    private boolean isFuelHalf;


    @ManyToOne
    private Motorhome motorhome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "season_id")
    private Season seasonId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cancellation_id")
    private Cancellation cancellationId;

    @OneToMany(mappedBy = "booking")
    private List<BookedExtras> bookedExtras;

    public Booking(Motorhome motorhome, String pickUpPoint, String dropOffPoint, boolean isServiced, boolean isFuelHalf) {
        this.motorhome = motorhome;
        this.pickUpPoint = pickUpPoint;
        this.dropOffPoint = dropOffPoint;
        this.extraKilometer = extraKilometer;
        this.isServiced = isServiced;
        this.isFuelHalf = isFuelHalf;
    }

    public Booking(){}

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

    public double getExtraKilometer() {
        return extraKilometer;
    }

    public void setExtraKilometer(double extraKilometer) {
        this.extraKilometer = extraKilometer;
    }

    public boolean isServiced() {
        return isServiced;
    }

    public void setServiced(boolean serviced) {
        isServiced = serviced;
    }

    public boolean isFuelHalf() {
        return isFuelHalf;
    }

    public void setFuelHalf(boolean fuelHalf) {
        isFuelHalf = fuelHalf;
    }

    public Motorhome getMotorhomeId() {
        return motorhome;
    }

    public void setMotorhomeId(Motorhome motorhomeId) {
        this.motorhome = motorhomeId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
}
