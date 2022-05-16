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


    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @OneToMany(mappedBy = "motorhome")
    private List<Booking> booking;


    public Motorhome(String name, String fuelType, double speedometer) {
        this.name = name;
        this.fuelType = fuelType;
        this.speedometer = speedometer;
    }

    public Motorhome() {
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

    public Brand getBrandId() {
        return brand;
    }

    public void setBrandId(Brand brandId) {
        this.brand = brandId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public Integer getId() {
        return id;
    }
}