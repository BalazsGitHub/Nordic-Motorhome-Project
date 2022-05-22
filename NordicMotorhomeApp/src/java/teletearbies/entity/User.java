package teletearbies.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
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

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
