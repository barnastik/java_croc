package barnastik.homework6.task11;

import java.util.*;

//зачатки демонстрации работы
public class Main {
    public static void main(String[] args) {

        Dish dish1 = new Dish("Жареная картошка", Arrays.asList("картошка", "масло"), Category.MAIN, 60, 80);
        Dish dish2 = new Dish("Вареная картошка", Arrays.asList("картошка", "вода"), Category.MAIN, 55, 80);
        Dish dish3 = new Dish("Паренная картошка", Arrays.asList("картошка", "вода"), Category.MAIN, 80, 75);

        Kitchener Kitchener1 = new Kitchener("First", new HashSet<>(List.of(dish1)));
        Kitchener Kitchener2 = new Kitchener("Second", new HashSet<>(List.of(dish2)));
        Kitchener Kitchener3 = new Kitchener("Third", new HashSet<>(List.of(dish3)));
        Kitchener Kitchener4 = new Kitchener("Fourth", new HashSet<>(List.of(dish1, dish2)));
        Kitchener Kitchener5 = new Kitchener("Fifth", new HashSet<>(List.of(dish1, dish3)));
        Kitchener Kitchener6 = new Kitchener("Sixth", new HashSet<>(List.of(dish2, dish3)));
        Kitchen kitchen = new Kitchen(Arrays.asList(Kitchener1,Kitchener2,Kitchener4));
        System.out.println(kitchen);

        Kitchen kitchen2 = new Kitchen(Arrays.asList(Kitchener4,Kitchener3,Kitchener6));
        System.out.println(kitchen2);

    }
}
