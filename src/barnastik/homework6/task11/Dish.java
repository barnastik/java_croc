package barnastik.homework6.task11;

import java.util.*;

//исправлены названия (очень извиняюсь за них!)
//исправлен конструктор
//исправлена последоваательность проверок с null
//исправлен equals
//добавлено (перекрыто) хеширование

public class Dish implements Comparable<Dish> {

    private String title;
    private Collection<String> ingredients;
    private Category category;
    private int ratingKing;
    private int ratingCourtiers;

    public Dish(String title, Collection<String> ingredients, Category category, int ratingKing, int ratingCourtiers) {
        setTitle(title);
        setIngredients(ingredients);
        this.category = category;
        setRatingKing(ratingKing);
        setRatingCourtiers(ratingCourtiers);
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Dish dish = (Dish) object;
        return Objects.equals(title, dish.title) &&
                Objects.equals(ingredients, dish.ingredients)
                && category == dish.category;
    }


    @Override
    public int hashCode() {
        return Objects.hash(title, ingredients, category);
    }

    @Override
    public int compareTo(Dish o) {
        if (ratingKing == o.ratingKing) {
            if (ratingCourtiers == o.ratingCourtiers) {
                return 0;
            }
            return ratingCourtiers > o.ratingCourtiers ? 1 : -1;
        }
        return ratingKing > o.ratingKing ? 1 : -1;
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Sorry, the title can't be empty");
        }
        this.title = title;
    }

    public void setIngredients(Collection<String> ingredients) {
        if (ingredients.isEmpty()) {
            throw new IllegalArgumentException("No ingredients");
        }
        this.ingredients = ingredients;
    }

    public void setRatingKing(int rating) {
        if (rating >= 0 && rating <= 100) {
            this.ratingKing = rating;
        } else {
            throw new IllegalArgumentException("Rating should be in [0,100]");
        }
    }

    public void setRatingCourtiers(int rating) {
        if (rating >= 0 && rating <= 100) {
            this.ratingCourtiers = rating;
        } else {
            throw new IllegalArgumentException("Rating should be in [0,100]");
        }
    }


    public String getTitle() {
        return title;
    }

    public Set<String> getIngredients() {
        return new HashSet<>(ingredients);
    }

    public Category getCategory() {
        return category;
    }

    public int getRatingKing() {
        return ratingKing;
    }

    public int getRatingCourtiers() {
        return ratingCourtiers;
    }


    @Override
    public String toString() {
        return title + ingredients + ' ' + category + " dish, rating King: " + ratingKing +
                ", rating Courtiers: " + ratingCourtiers;
    }
}