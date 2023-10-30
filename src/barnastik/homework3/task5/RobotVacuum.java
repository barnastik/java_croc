package barnastik.homework3.task5;

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
    public int getBatteryRuntime() {

        return batteryRuntime;
    }

    public void setBatteryRuntime(int batteryRuntime) {

        this.batteryRuntime = batteryRuntime;
    }

}

