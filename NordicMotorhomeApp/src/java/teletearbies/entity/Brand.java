package teletearbies.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = false, length = 255, name = "name")
    private String name;

    @Column(nullable = false, unique = false, length = 255, name = "model")
    private String model;

    @Column(nullable = false, unique = false, length = 255, name = "daily_brand_price")
    private double dailyBrandPrice;

    @Column(nullable = false, unique = false, length = 10, name = "capacity")
    private int capacity;

    //the 'type' of a one-to-many relationship needs to be put into a list
    @OneToMany(mappedBy = "brand")
    private List<Motorhome> motorhomes;

    public Brand( String name, String model, double dailyBrandPrice, int capacity) {
        this.name = name;
        this.model = model;
        this.dailyBrandPrice = dailyBrandPrice;
        this.capacity = capacity;
    }

    public Brand() {
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getDailyBrandPrice() {
        return dailyBrandPrice;
    }

    public void setDailyBrandPrice(double dailyBrandPrice) {
        this.dailyBrandPrice = dailyBrandPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}