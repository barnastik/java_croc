package barnastik.homework3.task6;

import barnastik.homework3.task6.figure.Circle;
import barnastik.homework3.task6.figure.Rectangle;
import barnastik.homework3.task6.functions.AnnotatedImage;
import barnastik.homework3.task6.functions.Annotation;

public class Main {
    public static void main(String[] args) {

        //создаем и собираем в массив
        Annotation annotation1 = new Annotation("Car", new Rectangle(100, 100, 150, 200));
        Annotation annotation2 = new Annotation("Tree", new Circle(100, 100, 10));
        Annotation[] annotations = {annotation1,annotation2};
        //выводим
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        AnnotatedImage annotatedImage = new AnnotatedImage("image.jpg", annotation1, annotation2);

        //сдвигаем Rectangle
        annotatedImage.moveFigure(annotation1, 1,1);
        System.out.println("New: " + annotation1);
        //сдвигаем Circle
        annotatedImage.moveFigure(annotation2,2,2);
        System.out.println("New: " + annotation2);
        //foundAnnotation
        Annotation foundAnnotation = annotatedImage.findByPoint(102, 102);
        System.out.println("foundAnnotation: " + foundAnnotation);
        //findByLabel
        Annotation findByLabel = annotatedImage.findByLabel("T");
        System.out.println("findByLabel: " + findByLabel);
    }
}

