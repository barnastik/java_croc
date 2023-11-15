package barnastik.homework6.task11;

import java.util.*;

public class Dish implements Comparable<Dish> {

    private String title;
    private Collection<String> ingredients;
    private Category category;
    private int ratingKing;
    private int ratingCourtiers;

    public Dish(String title, Collection<String> ingredients, Category category, int ratingKing, int ratingCourtiers) {
        this.title = title;
        this.ingredients = ingredients;
        this.category = category;
        this.ratingKing = ratingKing;
        this.ratingCourtiers = ratingCourtiers;
    }



    @Override
    public boolean equals(Object object) {
        if (getClass() != object.getClass() || object == null) return false;
        if (this == object) return true;
        return false;
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

    public void settitle(String title) {
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

    public void setratingKing(int rating) {
        if (rating >= 0 && rating <= 100) {
            this.ratingKing = rating;
        } else {
            throw new IllegalArgumentException("Rating should be in [0,100]");
        }
    }

    public void setratingCourtiers(int rating) {
        if (rating >= 0 && rating <= 100) {
            this.ratingCourtiers = rating;
        } else {
            throw new IllegalArgumentException("Rating should be in [0,100]");
        }
    }


    public String gettitle() {
        return title;
    }

    public Set<String> getIngredients() {
        return new HashSet<>(ingredients);
    }

    public Category getCategory() {
        return category;
    }

    public int getratingKing() {
        return ratingKing;
    }

    public int getratingCourtiers() {
        return ratingCourtiers;
    }


    @Override
    public String toString() {
        return title + ingredients + ' ' + category + " dish, rating King: " + ratingKing +
                ", rating Courtiers: " + ratingCourtiers;
    }
}