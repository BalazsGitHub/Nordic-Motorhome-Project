package teletearbies.entity;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    private List<BookedExtras> bookedExtras;

    public Extra() {
    }

    public Extra(String name, double price) {
        this.name = name;
        this.price = price;
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


}
