package barnastik.homework3.task5;

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

    public void setFreezerTemperature(int freezerTemperature) {

        this.freezerTemperature = freezerTemperature;
    }
    public int getFreezerTemperature() {

        return freezerTemperature;
    }
}
