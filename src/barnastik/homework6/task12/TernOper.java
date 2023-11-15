package barnastik.homework6.task12;

import java.util.function.Function;
import java.util.function.Predicate;

public class TernOper {
    public static <T, R> R ternaryOperator(T value, Predicate<T> predicate, Function<T, R> function1, Function<T, R> function2) {
        return predicate.test(value) ? function1.apply(value) : function2.apply(value);
    }
}

