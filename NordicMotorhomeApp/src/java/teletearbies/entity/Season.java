package teletearbies.entity;

import teletearbies.service.BookingService;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = false, length = 255, name = "name")
    private String name;

    @Column(nullable = false, unique = false, length = 10, name = "type")
    private double seasonPriceMultiplier;

    @OneToMany(mappedBy = "season")
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
