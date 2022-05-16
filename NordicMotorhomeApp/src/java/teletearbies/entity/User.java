package teletearbies.entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = false, length = 255, name = "user_name")
    private String userName;

    @Column(nullable = false, unique = false, length = 255, name = "password")
    private String password;
    @Column(nullable = false, unique = false, length = 255, name = "full_name")
    private String fullName;

    @Column(nullable = false, unique = false, length = 255, name = "title")
    private String title;

    @Column(nullable = false, unique = false, length = 255, name = "phone_number")
    private String phoneNumber;

    public User(String fullName, String title, String phoneNumber, String userName, String password) {
        this.fullName = fullName;
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
