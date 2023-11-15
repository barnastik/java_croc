package barnastik.homework6.task12;

import static barnastik.homework6.task12.TernOper.ternaryOperator;

public class Main {
    public static void main(String[] args) {

        String result1 = ternaryOperator("hello", s -> s.startsWith("h"), s -> s.toUpperCase(), s -> s.toLowerCase());
        System.out.println(result1); // Вывод: HELLO

        Integer result2 = ternaryOperator(10, i -> i > 5, i -> i * 2, i -> i * i);
        System.out.println(result2); // Вывод: 20

        Double result3 = ternaryOperator(15.0, d -> d < 10, d -> Math.sqrt(d), d -> Math.pow(d, 2));
        System.out.println(result3); // Вывод: 225.0
    }
}
