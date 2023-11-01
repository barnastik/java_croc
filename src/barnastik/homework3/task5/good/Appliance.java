package barnastik.homework3.task5.good;

public abstract class Appliance {
    private String name;
    private double price;
    private String description;
    private String dimensions;

    public Appliance(String name, double price, String description, String dimensions) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.dimensions = dimensions;
    }

    public void displayCharacteristics() {
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Description: " + description);
        System.out.println("Dimensions: " + dimensions);
    }

    public void setName(String Name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPrice: $" + price + "\nDescription: " + description + "\nDimensions: " + dimensions;
    }

}