package barnastik.homework5.task9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlackListFilterImpl implements BlackListFilter {

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        for (int i = 0; i < comments.size(); i++) {
            String comment = comments.get(i);
            for (String word : blackList) {
                comment = comment.replaceAll("\\b" + word + "\\b", "*".repeat(word.length()));
            }
            comments.set(i, comment);
        }
    }

    public static void main(String[] args) {
        List<String> comments = new ArrayList<>();
        comments.add("This is a good comment");
        comments.add("Spam spam spam");
        comments.add("I love this service");

        Set<String> blackList = new HashSet<>();
        blackList.add("spam");
        blackList.add("Spam");

        BlackListFilter filter = new BlackListFilterImpl();
        filter.filterComments(comments, blackList);

        for (String comment : comments) {
            System.out.println(comment);
        }
    }
}

