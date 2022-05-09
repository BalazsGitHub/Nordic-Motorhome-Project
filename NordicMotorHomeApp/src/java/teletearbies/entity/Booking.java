package teletearbies.entity;

public class Booking {
    private int id;
    private String pickUpPoint;
    private String dropOffPoint;
    private double extraKilometer;
    private boolean isServiced;
    private boolean isFuelHalf;
    private int motorhomeId;
    private int customerId;
    private int employeeId;
    private int seasonId;
    private int cancellationId;

    public Booking(String pickUpPoint, String dropOffPoint, double extraKilometer, boolean isServiced, boolean isFuelHalf, int motorhomeId, int customerId, int employeeId, int seasonId, int cancellationId) {
        this.pickUpPoint = pickUpPoint;
        this.dropOffPoint = dropOffPoint;
        this.extraKilometer = extraKilometer;
        this.isServiced = isServiced;
        this.isFuelHalf = isFuelHalf;
        this.motorhomeId = motorhomeId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.seasonId = seasonId;
        this.cancellationId = cancellationId;
    }

    public Booking(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getExtraKilometer() {
        return extraKilometer;
    }

    public void setExtraKilometer(double extraKilometer) {
        this.extraKilometer = extraKilometer;
    }

    public boolean isServiced() {
        return isServiced;
    }

    public void setServiced(boolean serviced) {
        isServiced = serviced;
    }

    public boolean isFuelHalf() {
        return isFuelHalf;
    }

    public void setFuelHalf(boolean fuelHalf) {
        isFuelHalf = fuelHalf;
    }

    public int getMotorhomeId() {
        return motorhomeId;
    }

    public void setMotorhomeId(int motorhomeId) {
        this.motorhomeId = motorhomeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getCancellationId() {
        return cancellationId;
    }

    public void setCancellationId(int cancellationId) {
        this.cancellationId = cancellationId;
    }
}
