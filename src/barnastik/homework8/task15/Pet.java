package barnastik.homework8.task15;

import java.util.Objects;

public class Pet {

    private final int CardNumber;

    private final String petName;

    private final int age;
    

    public Pet(int CardNumber, String name, int age) {
        this.CardNumber = CardNumber;
        this.petName = name;
        this.age = age;
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
        return CardNumber == pet.CardNumber && age == pet.age && Objects.equals(petName, pet.petName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CardNumber);
    }
    
}