package barnastik.homework5.task9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlackListFilterImpl implements BlackListFilter {

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> newComments = new ArrayList<>();
        for (String comment : comments) {
            newComments.add(newComment(comment, blackList));
        }
        comments.clear();
        comments.addAll(newComments);
    }
    private String newComment(String comment, Set<String> blackList) {

        String[] words = comment.split("[\\s.,?!]+");

        for (String word : words) {
            String newWord = word.toLowerCase();
            for (String blackWord : blackList) {
                if (newWord.equals(blackWord)) {
                    int len = word.length();
                    String fixWord = "*".repeat(len);
                    int i = comment.indexOf(word);
                    StringBuilder newComment = new StringBuilder(comment);
                    newComment.replace(i, i + len, fixWord);
                    comment = newComment.toString();
                }
            }
        }

        return comment;
    }
}
