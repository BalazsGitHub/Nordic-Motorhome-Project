package teletearbies.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cancellation")
public class Cancellation {
    private int id;
    private String type;
    private double percentage;

    public Cancellation(){}

    public Cancellation(String type, double percentage) {
        this.type = type;
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
