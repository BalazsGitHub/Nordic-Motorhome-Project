package teletearbies.entity;

import javax.persistence.*;
import java.util.List;

//It is a JPA (Java Persistence API class), meaning: It is a Java thing that allows you to manipulate data between a Java object and a database.
//@Entity annotation specifies that the class (Motorhome) is an entity and is mapped to a table.
@Entity
//@Table annotation is optional, we use it to customize the name of our tables that should be mapped to this entity.
@Table(name = "motorhome")

public class Motorhome {

    @Id
    //By marking the @Id field with @GeneratedValue we are now enabling id generation. Which means that the (database) will generate an Id value for us and handle the auto incrementing.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = false, length = 255, name = "name")
    private String name;

    @Column(unique = false, length = 255, name = "fuel_type")
    private String fuelType;

    @Column(nullable = false, unique = false, length = 10, name = "speedomenter")
    private double speedometer;

    @Column(nullable = false, unique = false, name = "being_repaired")
    private boolean repaired = true;

    @ManyToOne
    //@ManyToOne is another JPA annotation that creates relationships between entity classes
    //many-to-one mapping means that many rows in a table is mapped to one row in another table.
    @JoinColumn(name = "brand_id")
    //The @JoinColumn annotation allows you to specify the Foreign Key column name
    private Brand brand;

    @OneToMany(mappedBy = "motorhome")
    //@OneToMany means that one row in a table is mapped to many rows in another table.
    //the mappedBy attribute to indicate the entity that owns the relationship
    private List<Booking> bookingList;

    public Motorhome() {
    }

    public Motorhome(String name, String fuelType, double speedometer, Brand brand, boolean repaired) {
        this.name = name;
        this.fuelType = fuelType;
        this.speedometer = speedometer;
        this.brand = brand;
        this.repaired = repaired;
    }

    public void setRepairedTrue() {
            repaired = true;
    }

    public void setRepairedFalse() {
            repaired = false;
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

    public boolean isRepaired() {
        return repaired;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }
}