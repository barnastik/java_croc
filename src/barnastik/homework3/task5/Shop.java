package barnastik.homework3.task5;

public class Shop {
    public static void main(String[] args) {
        Appliance[] appliances = new Appliance[8];

        appliances[0] = new Fridge("Mini Fridge", 200.0, "Compact fridge with freezer", "50x50x80 cm", 100);
        appliances[1] = new Stove("Gas Stove", 350.0, "Gas-powered stove with four burners", "60x60x85 cm", 500);
        appliances[2] = new WashingMachine("Washing Machine", 500.0, "Washer with a dryer", "70x70x100 cm", 800, 120, true);
        appliances[3] = new RobotVacuum("Robot Vacuum Cleaner", 300.0, "Automatic vacuum cleaner", "30x30x10 cm", 90);
        appliances[4] = new ImportWashingMachine("Import Washing Machine", 1000.0, "Washer with a dryer", "70x70x100 cm", 800, 120, true, "France", true);
        appliances[5] = new ImportFridge("Import Mini Fridge", 400.0, "Compact fridge with freezer", "50x50x80 cm", 200, "Italy", false);
        appliances[6] = new ImportStove("Import Gas Stove", 700.0, "Gas-powered stove with four burners", "60x60x85 cm", 800, "China", false);
        appliances[7] = new ImportRobotVacuum("Import Robot Vacuum Cleaner", 600.0, "Automatic vacuum cleaner", "30x30x10 cm", 120, "India", true);

        for (Appliance appliance : appliances) {
            appliance.displayCharacteristics();
            System.out.println();
        }
    }
}

