package teletearbies.entity;

public class Customer {
    private int id;
    private String fullName;
    private String phoneNumber;
    private String cardNumber;
    private String address;

    public Customer(String fullName, String phoneNumber, String cardNumber, String address) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
        this.address = address;
    }

    public Customer(){}

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
