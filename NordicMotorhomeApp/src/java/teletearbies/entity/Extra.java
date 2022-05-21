package teletearbies.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "extras")
public class Extra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = false, length = 255, name = "name")
    private String name;

    @Column(nullable = false, unique = false, length = 10, name = "price")
    private double price;

/*    @OneToMany
    private List<BookedExtras> bookedExtras;*/

    @ManyToMany(mappedBy = "extras")
    private Set<Booking> bookings = new HashSet<>();

    public Extra() {
    }

    public Extra(String name, double price) {
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}
