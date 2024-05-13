
package wagesmanagementsystem;

public class Garment {
    private String brand;
    private String color;
    private String type;
    private String quality;
    private long cost;

    public Garment(String brand, String color, String type, String quality, long cost) {
        this.brand = brand;
        this.color = color;
        this.type = type;
        this.quality = quality;
        this.cost = cost;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public String getQuality() {
        return quality;
    }

    public long getCost() {
        return cost;
    }
    
    
}
