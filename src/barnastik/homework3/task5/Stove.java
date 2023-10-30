package barnastik.homework3.task5;

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

    public void setPower(int power) {
        this.power = power;
    }
    public int getPower() {
        return power;
    }
}