package barnastik.homework6.task12;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static barnastik.homework6.task12.TernOper.ternaryOperator;

public class Main {
    public static void main(String[] args) {

        //строка
        String result1 = ternaryOperator(
                "hello",
                s -> s.startsWith("h"),
                String::toUpperCase,
                String::toLowerCase);
        System.out.println(result1);
        //еще строка
        String example = "абракадабра";
        Boolean result2 = ternaryOperator(
                example,
                s -> s.contains("кадабра"),
                s -> true,
                s -> false);
        System.out.println(result2);
        //Integer с лямбдой
        Integer result3 = ternaryOperator(
                20,
                i -> i > 5,
                i -> i * 2,
                i -> i * i);
        System.out.println(result3);
        //Double c ссылкой на метод
        Double result4 = ternaryOperator(
                15.0,
                d -> d < 10,
                Math::sqrt,
                d -> Math.pow(d, 2));
        System.out.println(result4);
        //время
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.minusDays(10);
        String result5 = ternaryOperator(
                futureDate,
                date -> date.isBefore(currentDate),
                date -> "Past",
                date -> "Future");
        System.out.println(result5);
        //просто int
        int num = -50;
        int result6 = ternaryOperator(
                num,
                x -> x < 0,
                x -> x * 2,
                x -> x / 2);
        System.out.println(result6);
        //HashSet<>(List.of()) и много функций
        Function<HashSet<Integer>, Integer> sumOfOdd = list -> list.stream()
                .filter(number -> number % 2 == 1)
                .mapToInt(Integer::intValue)
                .sum();

        Function<HashSet<Integer>, Integer> sumOfEven = (list) -> {
            int sum = 0;
            for (Integer number : list) {
                if (number % 2 == 0) {
                    sum += number;
                }
            }
            return sum;
        };

        Predicate<HashSet<Integer>> evenMore = (list) -> {
            long evenCount = list.stream()
                    .filter(number -> number % 2 == 0)
                    .count();

            long oddCount = list.size() - evenCount;

            return evenCount >= oddCount;
        };

        Integer result7 = ternaryOperator(
                new HashSet<>(List.of(10, 9, 8, 7, 6)),
                evenMore,
                sumOfEven,
                sumOfOdd);
        System.out.println(result7);
    }
}

