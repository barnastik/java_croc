package barnastik.homework6.task11;

import java.util.*;
import java.util.function.Predicate;

//поменяла kitchenerDish на kitchenerAndDishes, не придумала ничего креативней(
//добавлена функция canKitchenerDish
//добавлена функция update
//добавлена toString
public class Kitchen {
    private static HashMap<Kitchener, Set<Dish>> kitchenerAndDishes;

    public Kitchen(Collection<Kitchener> Kitcheners) {
        setKitchenerAndDishes(Kitcheners);
    }

    public HashMap<Kitchener, Set<Dish>> getKitchenerAndDishes() {
        return new HashMap<>(kitchenerAndDishes);
    }

    public void setKitchenerAndDishes(Collection<Kitchener> Kitcheners) {
        if (Kitcheners.isEmpty()) {
            throw new IllegalArgumentException("No kitcheners");
        }
        HashMap<Kitchener, Set<Dish>> newKitchenerAndDishes = new HashMap<>();
        for (Kitchener Kitchener : Kitcheners) {
            if (Kitchener != null) {
                newKitchenerAndDishes.put(Kitchener, Kitchener.getDishes());
            }
        }
        this.kitchenerAndDishes = newKitchenerAndDishes;
    }

    

    public ArrayList<Dish> getAllMenu(Collection<Kitchener> Kitcheners, Collection<String> ingredients) {
        Objects.requireNonNull(Kitcheners);
        HashSet<Dish> menu = new HashSet<>();
        for (Kitchener Kitchener : Kitcheners) {
            Set<Dish> dishes = kitchenerAndDishes.get(Kitchener);
            for (Dish dish : dishes) {
                if (kitchenerAndDishes(dish, ingredients)) {
                    menu.add(dish);
                }
            }
        }
        return new ArrayList<>(menu);
    }

    private boolean kitchenerAndDishes(Dish dish, Collection<String> Ingredients) {
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

    private static boolean canKitchenerDish(Dish dish, Collection<String> absentIngredients) {
        if (absentIngredients != null && !absentIngredients.isEmpty()) {
            for (String ingredient : dish.getIngredients()) {
                for (String absentIngredient : absentIngredients) {
                    if (ingredient.equalsIgnoreCase(absentIngredient)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static HashSet<Dish> update(HashSet<Dish> menu, Predicate<Dish> predicate) {
        if (predicate != null) {
            HashSet<Dish> newMenu = new HashSet<>(menu.size());
            for (Dish d : menu) {
                if (predicate.test(d)) {
                    newMenu.add(d);
                }
            }
            return newMenu;
        }
        return menu;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Kitchener cook : kitchenerAndDishes.keySet()) {
            out.append(cook.toString())
                    .append('\n');
        }
        return out.toString();
    }


}
