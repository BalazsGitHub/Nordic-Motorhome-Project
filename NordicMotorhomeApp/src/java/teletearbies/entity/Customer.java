package teletearbies.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = false, length = 255, name = "full_name")
    private String fullName;

    @Column(nullable = false, unique = false, length = 255, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false, unique = false, length = 255, name = "cardNumber")
    private String cardNumber;

    @Column(nullable = false, unique = false, length = 255, name = "address")
    private String address;

    @OneToOne(mappedBy = "customerId")
    private Booking booking;


    public Customer(String fullName, String phoneNumber, String cardNumber, String address) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
        this.address = address;
    }

    public Customer() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
