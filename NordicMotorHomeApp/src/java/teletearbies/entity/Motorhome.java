package teletearbies.entity;

public class Motorhome {
    private int id;
    private String name;
    private String fuelType;
    private double speedometer;
    private int brandId;


    public Motorhome(String name, String fuelType, double speedometer, int brandId) {
        this.name = name;
        this.fuelType = fuelType;
        this.speedometer = speedometer;
        this.brandId = brandId;
    }

    public Motorhome() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getSpeedometer() {
        return speedometer;
    }

    public void setSpeedometer(double speedometer) {
        this.speedometer = speedometer;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}