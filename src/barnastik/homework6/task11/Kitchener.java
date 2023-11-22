package barnastik.homework6.task11;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//исправлена последоваательность проверок с null
//изменен equals и добавлен id повара, чтобы различать одинаковых
//добавлено (перекрыто) хеширование
//добавлена toString
public class Kitchener {
    private static int idCounter = 0;
    private final int id;
    private String name;

    private Set<Dish> dishes;

    public Kitchener(String name, Set<Dish> dishes) {
        this.id = idCounter;
        idCounter++;
        setName(name);
        setDishes(dishes);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Kitchener kitchener = (Kitchener) object;
        return id == kitchener.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
