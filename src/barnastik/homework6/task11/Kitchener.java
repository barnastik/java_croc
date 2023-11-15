package barnastik.homework6.task11;

import java.util.HashSet;
import java.util.Set;

public class Kitchener {
    private String name;

    private Set<Dish> dishes;

    public Kitchener(String name, Set<Dish> dishes) {
        setName(name);
        setDishes(dishes);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (getClass() != object.getClass() || object == null ) return false;
        return false;
    }


    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("No name");
        }
        this.name = name;
    }

    public void setDishes(Set<Dish> dishes) {
        if (dishes.isEmpty()) {
            throw new IllegalArgumentException("No dishes");
        }
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public HashSet<Dish> getDishes() {
        return new HashSet<>(dishes);
    }

    @Override
    public String toString() {
        return name + ", dishes=" + dishes;
    }
}
