package barnastik.homework6.task10;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.*;
import java.util.function.Predicate;
public class Main {
    public static void main(String[] args) {
        BlackListFilter filter = new BlackListFilterImpl();

        //тестирование для ArrayList<String>
        ArrayList<String> commentsStringArray = new ArrayList<>();
        commentsStringArray.add("Ok comment");
        commentsStringArray.add("Bad comment");
        commentsStringArray.add("Very bad comment");
        Predicate<String> stringFilter = (comment) -> {
            final Set<String> blackList = new HashSet<>(List.of("bad"));
            String newComment = comment.toLowerCase();
            for(String word : blackList) {
                if(newComment.contains(word)) {
                    return true;
                }
            }
            return false;
        };
        Collection<String> filteredStringComments = filter.filterComments(commentsStringArray, stringFilter);
        System.out.println(filteredStringComments);


        //тестирование для ArrayDeque<String>
        ArrayDeque<String> stringArrayDequeComments = new ArrayDeque<>();
        stringArrayDequeComments.add("Normal comment");
        stringArrayDequeComments.add("Sad comment");
        stringArrayDequeComments.add("Very sad comment");
        Predicate<String> stringFilterDeque = (comment) -> {
            final Set<String> blackList = new HashSet<>(List.of("sad"));
            String newComment = comment.toLowerCase();
            for(String word : blackList) {
                if(newComment.contains(word)) {
                    return true;
                }
            }
            return false;
        };
        Collection<String> filteredStringCommentsDeque = filter.filterComments(stringArrayDequeComments, stringFilterDeque);
        System.out.println(filteredStringCommentsDeque);


        //тестирование ArrayList<Comment>
        ArrayList<Comment> arrayListFilter = new ArrayList<>(List.of(new Comment("Very good comment"),
                new Comment("Bad comment"), 
                new Comment("Very bad comment")));
        Predicate<Comment> stringFilterArrayList = (comment) -> {
            Set<String> blackList = new HashSet<>(List.of(new Comment("very bad").text, 
                    new Comment("bad").text));
            String newComment = comment.text.toLowerCase();
            for(String word : blackList) {
                if(newComment.contains(word)) {
                    return true;
                }
            }
            return false;
        };
        Collection<Comment> filteredClassCommentsArray = filter.filterComments(arrayListFilter, stringFilterArrayList);
        System.out.println(filteredClassCommentsArray);


        //тестирование HashSet<Comment>
        HashSet<Comment> hashComment = new HashSet<>(List.of(new Comment("Good comment"),
                new Comment("Bad comment"), 
                new Comment("Very-very bad comment")));
        Predicate<Comment> stringFilterHash = (comment) -> {
            Set<String> blackList = new HashSet<>(List.of(new Comment("very-very bad").text, 
                    new Comment("bad").text));
            String newComment = comment.text.toLowerCase();
            for(String word : blackList) {
                if(newComment.contains(word)) {
                    return true;
                }
            }
            return false;
        };
        Collection<Comment> filteredClassCommentsSet = filter.filterComments(hashComment, stringFilterHash);
        System.out.println(filteredClassCommentsSet);

    }

}
