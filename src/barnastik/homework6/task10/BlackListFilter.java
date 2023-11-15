package barnastik.homework6.task10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
public interface BlackListFilter {
    default <T> List<T> filterComments(Iterable<T> comments, Predicate<T> black){

        ArrayList<T> newComments = new ArrayList<>();
        Objects.requireNonNull(black);
        Objects.requireNonNull(comments);

        for (T comment : comments) {
            if (!black.test(comment)) {
                newComments.add(comment);
            }
        }

        return newComments;
    }
}
