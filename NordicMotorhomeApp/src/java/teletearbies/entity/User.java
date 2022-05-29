package teletearbies.entity;

import javax.persistence.*;
import java.util.List;
//It is a JPA (Java Persistence API class), meaning: It is a Java thing that allows you to manipulate data between a Java object and a database.
//@Entity annotation specifies that the class (Booking) is an entity and is mapped to a table.
@Entity
//@Table annotation is optional, we use it to customize the name of our tables that should be mapped to this entity.
@Table(name = "user")

public class User {

    @Id
    //By marking the @Id field with @GeneratedValue we are now enabling id generation. Which means that the (database) will generate an Id value for us and handle the auto incrementing.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = false, length = 255, name = "user_name")
    private String username;

    @Column(nullable = false, unique = false, length = 255, name = "password")
    private String password;

    @Column(nullable = false, unique = false, length = 255, name = "full_name")
    private String fullName;

    @Column(nullable = false, unique = false, length = 255, name = "title")
    private String title;

    @Column(nullable = false, unique = false, length = 255, name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    //@OneToMany means that one row in a table is mapped to many rows in another table.
    //the mappedBy attribute to indicate the entity that owns the relationship
    private List<Booking> bookingList;

    public User(String fullName, String title, String phoneNumber, String username, String password) {
        this.fullName = fullName;
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", title='" + title + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bookingList=" + bookingList +
                '}';
    }
}
