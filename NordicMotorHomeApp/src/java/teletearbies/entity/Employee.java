package teletearbies.entity;

public class Employee {
    private int id;
    private String fullName;
    private String title;
    private String phoneNumber;

    public Employee(String fullName, String title, String phoneNumber){
        this.fullName=fullName;
        this.title=title;
        this.phoneNumber=phoneNumber;
    }

    public Employee(){}

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
