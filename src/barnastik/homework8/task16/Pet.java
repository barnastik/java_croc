package barnastik.homework8.task16;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pet {

    private int CardNumber;

    private String petName;

    private int age;

    private List<Client> owners;


    public Pet(int CardNumber, String name, int age) {
        this.CardNumber = CardNumber;
        this.petName = name;
        this.age = age;
        this.owners = new ArrayList<>();
    }

    public int getCardNumber() {
        return CardNumber;
    }

    public String getPetName() {
        return petName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return CardNumber == pet.getCardNumber() && age == pet.getAge() && Objects.equals(petName, pet.getPetName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(CardNumber);
    }

    public void setCardNumber(int medCardNumber) {
        this.CardNumber = medCardNumber;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Client> getOwner() {
        return owners;
    }

    public void setOwner(List<Client> owners) {
        this.owners = owners;
    }

}

