package barnastik.homework6.task11;

import java.util.*;

public class Kitchen {
    private HashMap<Kitchener, Set<Dish>> KitchenerDishes;

    public Kitchen(Collection<Kitchener> Kitcheners) {
        setKitchenerDishes(Kitcheners);
    }

    public HashMap<Kitchener, Set<Dish>> getKitchenerDishes() {
        return new HashMap<>(KitchenerDishes);
    }

    public void setKitchenerDishes(Collection<Kitchener> Kitcheners) {
        if (Kitcheners.isEmpty()) {
            throw new IllegalArgumentException("No kitcheners");
        }
        HashMap<Kitchener, Set<Dish>> newKitchenerDish = new HashMap<>();
        for (Kitchener Kitchener : Kitcheners) {
            if (Kitchener != null) {
                newKitchenerDish.put(Kitchener, Kitchener.getDishes());
            }
        }
        this.KitchenerDishes = newKitchenerDish;
    }

    

    public ArrayList<Dish> getAllMenu(Collection<Kitchener> Kitcheners, Collection<String> ingredients) {
        Objects.requireNonNull(Kitcheners);
        HashSet<Dish> menu = new HashSet<>();
        for (Kitchener Kitchener : Kitcheners) {
            Set<Dish> dishes = KitchenerDishes.get(Kitchener);
            for (Dish dish : dishes) {
                if (kitchenerDish(dish, ingredients)) {
                    menu.add(dish);
                }
            }
        }
        return new ArrayList<>(menu);
    }

    private boolean kitchenerDish(Dish dish, Collection<String> Ingredients) {
        if (!Ingredients.isEmpty()) {
            Set<String> ingredients = dish.getIngredients();
            for (String ingredient : ingredients) {
                for (String Ingredient : Ingredients) {
                    if (ingredient.equals(Ingredient)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
