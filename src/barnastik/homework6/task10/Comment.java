package barnastik.homework6.task10;

//класс для тестирования
public class Comment{
    String text;

    public Comment(String text) {
        this.text = text;
    }

    //чтобы было
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "CommentRecord [text=" + text + "]";
    }
}

