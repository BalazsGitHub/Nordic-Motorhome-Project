package teletearbies.entity;

public class Season {
    private int id;
    private String name;
    private double seasonPriceMultiplier;

    public Season(){}

    public Season(String name, double seasonPriceMultiplier){
        this.name=name;
        this.seasonPriceMultiplier = seasonPriceMultiplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSeasonPriceMultiplier() {
        return seasonPriceMultiplier;
    }

    public void setSeasonPriceMultiplier(double seasonPriceMultiplier) {
        this.seasonPriceMultiplier = seasonPriceMultiplier;
    }
}
