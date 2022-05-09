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

    @Column(nullable = false,unique = false, length = 255, name = "fuel_type")
    private String fuelType;

    @Column(nullable = false, unique = false, length = 10, name = "speedomenter")
    private double speedometer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private Brand brandId;

   @ManyToOne
   private Booking booking;


    public Motorhome(String name, String fuelType, double speedometer, Brand brandId) {
        this.name = name;
        this.fuelType = fuelType;
        this.speedometer = speedometer;
        this.brandId = brandId;
    }

    public Motorhome() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }
}