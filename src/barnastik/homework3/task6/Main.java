package barnastik.homework3.task6;

public class Main {
    public static void main(String[] args) {
        Annotation[] annotations = {
                new Annotation("Tree", new Circle(100, 100, 10)),
                new Annotation("Car", new Rectangle(100, 100, 150, 200))
        };

        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}

