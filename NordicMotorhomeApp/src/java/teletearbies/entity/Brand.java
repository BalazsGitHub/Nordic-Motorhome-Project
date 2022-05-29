package teletearbies.entity;

import javax.persistence.*;
import java.util.List;

//It is a JPA (Java Persistence API class), meaning: It is a Java thing that allows you to manipulate data between a Java object and a database.
//@Entity annotation specifies that the class (Booking) is an entity and is mapped to a table.
@Entity
//@Table annotation is optional, we use it to customize the name of our tables that should be mapped to this entity.
@Table(name = "brand")

public class Brand {

    @Id
    //By marking the @Id field with @GeneratedValue we are now enabling id generation. Which means that the (database) will generate an Id value for us and handle the auto incrementing.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //We use the column annotation to create a customized column in our tables
    @Column(nullable = false, unique = false, length = 255, name = "name")
    private String name;

    @Column(nullable = false, unique = false, length = 255, name = "model")
    private String model;

    @Column(nullable = false, unique = false, length = 255, name = "daily_brand_price")
    private double dailyBrandPrice;

    @Column(nullable = false, unique = false, length = 10, name = "capacity")
    private int capacity;

    //@OneToMany means that one row in a table is mapped to many rows in another table.
    //the mappedBy attribute to indicate the entity that owns the relationship
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