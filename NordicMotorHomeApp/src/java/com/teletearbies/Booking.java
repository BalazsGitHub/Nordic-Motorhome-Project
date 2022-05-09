package com.teletearbies;

public class Booking {
    private Season season;
    private Motorhome motorhome;
    private Employee employee;
    private Cancellation cancellation;
    private Customer customer;
    private String pickUpPoint;
    private String dropOffPoint;


    public Booking(Season season, Motorhome motorhome, Employee employee, Cancellation cancellation, Customer customer, String pickUpPoint, String dropOffPoint) {
        this.season = season;
        this.motorhome = motorhome;
        this.employee = employee;
        this.cancellation = cancellation;
        this.customer = customer;
        this.pickUpPoint = pickUpPoint;
        this.dropOffPoint = dropOffPoint;
    }

    public Booking(){}

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Motorhome getMotorhome() {
        return motorhome;
    }

    public void setMotorhome(Motorhome motorhome) {
        this.motorhome = motorhome;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Cancellation getCancellation() {
        return cancellation;
    }

    public void setCancellation(Cancellation cancellation) {
        this.cancellation = cancellation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(String pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public String getDropOffPoint() {
        return dropOffPoint;
    }

    public void setDropOffPoint(String dropOffPoint) {
        this.dropOffPoint = dropOffPoint;
    }
}
