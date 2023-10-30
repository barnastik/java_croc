package barnastik.homework3.task5;

public class ImportStove extends Stove {
    private String country;
    private boolean hasGuarantee;

    public ImportStove(String name, double price, String description, String dimensions, int power, String country, boolean hasGuarantee) {
        super(name, price, description, dimensions, power);
        this.country = country;
        this.hasGuarantee = hasGuarantee;
    }

    @Override
    public void displayCharacteristics() {
        super.displayCharacteristics();
        System.out.println("Manufacturer country: " + country);
        System.out.println("Has Guarantee: " + (hasGuarantee ? "Yes" : "No"));
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getcountry() {

        return country;
    }

    public void setHasGuarantee(boolean hasGuarantee) {

        this.hasGuarantee = hasGuarantee;
    }

    public boolean getHasGuarantee() {

        return hasGuarantee;
    }
}
