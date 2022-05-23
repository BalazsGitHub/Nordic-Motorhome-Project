package teletearbies.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "motorhome")
public class Motorhome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = false, length = 255, name = "name")
    private String name;

    @Column(nullable = false, unique = false, length = 255, name = "fuel_type")
    private String fuelType;

    @Column(nullable = false, unique = false, length = 10, name = "speedomenter")
    private double speedometer;

    @Column(nullable = false, unique = false, name = "being_repaired")
    private boolean isBeingRepaired = false;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "motorhome")
    private List<Booking> bookingList;

    public Motorhome(String name, String fuelType, double speedometer, Brand brand) {
        this.name = name;
        this.fuelType = fuelType;
        this.speedometer = speedometer;
        this.brand = brand;
    }

    public Motorhome() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getSpeedometer() {
        return speedometer;
    }

    public void setSpeedometer(double speedometer) {
        this.speedometer = speedometer;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public Brand getBrandId() {
        return brand;
    }

    public void setBrandId(Brand brand) {
        this.brand = brand;
    }

    public boolean isBeingRepaired() {
        return isBeingRepaired;
    }

    public void setBeingRepaired(boolean beingRepaired) {
        isBeingRepaired = beingRepaired;
    }
}