package teletearbies.entity;

import javax.persistence.*;
import java.util.List;

//It is a JPA (Java Persistence API class), meaning: It is a Java thing that allows you to manipulate data between a Java object and a database.
//@Entity annotation specifies that the class (Cancellation) is an entity and is mapped to a table.
@Entity
//@Table annotation is optional, we use it to customize the name of our tables that should be mapped to this entity.
@Table(name = "cancellation")

public class Cancellation {

    @Id
    //By marking the @Id field with @GeneratedValue we are now enabling id generation. Which means that the (database) will generate an Id value for us and handle the auto incrementing.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = false, length = 255, name = "type")
    private String type;

    @Column(nullable = false, unique = false, length = 10, name = "percentage")
    private double percentage;

    @OneToMany(mappedBy = "cancellation")
    private List<Booking> bookingList;

    public Cancellation() {
    }

    public Cancellation(String type, double percentage) {
        this.type = type;
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public List<Booking> getBookingListId() {
        return bookingList;
    }

    public void setBookingListId(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }
}
