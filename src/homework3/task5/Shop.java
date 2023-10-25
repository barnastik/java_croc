package homework3.task5;

abstract class Appliance {
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

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class Fridge extends Appliance {
    private int freezerTemperature;

    public Fridge(String name, double price, String description, String dimensions, int freezerTemperature) {
        super(name, price, description, dimensions);
        this.freezerTemperature = freezerTemperature;
    }

    @Override
    public void displayCharacteristics() {
        super.displayCharacteristics();
        System.out.println("Freezer Temperature: " + freezerTemperature + "°C");
    }
}

class Stove extends Appliance {
    private int power;

    public Stove(String name, double price, String description, String dimensions, int power) {
        super(name, price, description, dimensions);
        this.power = power;
    }

    @Override
    public void displayCharacteristics() {
        super.displayCharacteristics();
        System.out.println("Power: " + power + " W");
    }
}

class WashingMachine extends Appliance {
    private int power;
    private int batteryRuntime;
    private boolean hasDryer;

    public WashingMachine(String name, double price, String description, String dimensions, int power, int batteryRuntime, boolean hasDryer) {
        super(name, price, description, dimensions);
        this.power = power;
        this.batteryRuntime = batteryRuntime;
        this.hasDryer = hasDryer;
    }

    @Override
    public void displayCharacteristics() {
        super.displayCharacteristics();
        System.out.println("Power: " + power + " W");
        System.out.println("Battery Runtime: " + batteryRuntime + " minutes");
        System.out.println("Has Dryer: " + (hasDryer ? "Yes" : "No"));
    }
}

class RobotVacuum extends Appliance {
    private int batteryRuntime;

    public RobotVacuum(String name, double price, String description, String dimensions, int batteryRuntime) {
        super(name, price, description, dimensions);
        this.batteryRuntime = batteryRuntime;
    }

    @Override
    public void displayCharacteristics() {
        super.displayCharacteristics();
        System.out.println("Battery Runtime: " + batteryRuntime + " minutes");
    }
}



public class Shop {
    public static void main(String[] args) {
        Appliance[] appliances = new Appliance[4];

        appliances[0] = new Fridge("Mini Fridge", 200.0, "Compact fridge with freezer", "50x50x80 cm", 100);
        appliances[1] = new Stove("Gas Stove", 350.0, "Gas-powered stove with four burners", "60x60x85 cm", 500);
        appliances[2] = new WashingMachine("Washing Machine", 500.0, "Washer with a dryer", "70x70x100 cm", 800, 120, true);
        appliances[3] = new RobotVacuum("Robot Vacuum Cleaner", 300.0, "Automatic vacuum cleaner", "30x30x10 cm", 90);

        for (Appliance appliance : appliances) {
            appliance.displayCharacteristics();
            System.out.println();
        }
    }
}

