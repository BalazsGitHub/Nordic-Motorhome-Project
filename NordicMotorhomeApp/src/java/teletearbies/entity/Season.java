package teletearbies.entity;

import teletearbies.service.BookingService;

import javax.persistence.*;
import java.util.List;

//It is a JPA (Java Persistence API class), meaning: It is a Java thing that allows you to manipulate data between a Java object and a database.
//@Entity annotation specifies that the class (Motorhome) is an entity and is mapped to a table.
@Entity
//@Table annotation is optional, we use it to customize the name of our tables that should be mapped to this entity.
@Table(name = "season")

public class Season {

    @Id
    //By marking the @Id field with @GeneratedValue we are now enabling id generation. Which means that the (database) will generate an Id value for us and handle the auto incrementing.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = false, length = 255, name = "name")
    private String name;

    @Column(nullable = false, unique = false, length = 10, name = "type")
    private double seasonPriceMultiplier;

    @OneToMany(mappedBy = "season")
    //@OneToMany means that one row in a table is mapped to many rows in another table.
    //the mappedBy attribute to indicate the entity that owns the relationship
    private List<Booking> bookingList;

    public Season() {
    }

    public Season(String name, double seasonPriceMultiplier) {
        this.name = name;
        this.seasonPriceMultiplier = seasonPriceMultiplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSeasonPriceMultiplier() {
        return seasonPriceMultiplier;
    }

    public void setSeasonPriceMultiplier(double seasonPriceMultiplier) {
        this.seasonPriceMultiplier = seasonPriceMultiplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
