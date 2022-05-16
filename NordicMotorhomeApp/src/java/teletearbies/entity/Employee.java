package teletearbies.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = false, length = 255, name = "full_name")
    private String fullName;

    @Column(nullable = false, unique = false, length = 255, name = "title")
    private String title;

    @Column(nullable = false, unique = false, length = 255, name = "phone_number")
    private String phoneNumber;

    public Employee(String fullName, String title, String phoneNumber) {
        this.fullName = fullName;
        this.title = title;
        this.phoneNumber = phoneNumber;
    }

    public Employee() {
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
}
