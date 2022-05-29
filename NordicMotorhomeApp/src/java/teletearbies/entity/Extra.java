package teletearbies.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
//It is a JPA (Java Persistence API class), meaning: It is a Java thing that allows you to manipulate data between a Java object and a database.
//@Entity annotation specifies that the class (Extra) is an entity and is mapped to a table.
@Entity
//@Table annotation is optional, we use it to customize the name of our tables that should be mapped to this entity.
@Table(name = "extras")
public class Extra {

    @Id
    //By marking the @Id field with @GeneratedValue we are now enabling id generation. Which means that the (database) will generate an Id value for us and handle the auto incrementing.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = false, length = 255, name = "name")
    private String name;

    @Column(nullable = false, unique = false, length = 10, name = "price")
    private double price;
     //@ManyToMany is another JPA annotation that specify the mapping of a many-to-many table relationship.
    //many-to-many mapping means that many rows in a table are mapped/can relate to many other rows in another table.
    //the mappedBy attribute to indicate the entity that owns the relationship
    @ManyToMany(mappedBy = "extras")
    //A HashSet is used because it guarantees that two values which are equal to each other (which are equality checked by looking at their GetHashCode and Equals methods) only appear once in the collection
    //it is part of the ICollection
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
