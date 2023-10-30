package barnastik.homework3.task5;

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

    public void setPower(int power) {
        this.power = power;
    }
    public int getPower() {
        return power;
    }

    public void setBatteryRuntime(int batteryRuntime) {
        this.batteryRuntime = batteryRuntime;
    }
    public int getBatteryRuntime() {
        return batteryRuntime;
    }

    public void setHasDryer(boolean hasDryer) {
        this.hasDryer = hasDryer;
    }
    public boolean getHasDryer() {
        return hasDryer;
    }
}