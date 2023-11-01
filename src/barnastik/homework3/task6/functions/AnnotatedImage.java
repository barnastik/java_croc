package barnastik.homework3.task6.functions;

import barnastik.homework3.task6.figure.Circle;
import barnastik.homework3.task6.figure.Figure;
import barnastik.homework3.task6.figure.Rectangle;

public class AnnotatedImage {

    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    public Annotation findByPoint(int x, int y) {
        for (Annotation annotation : annotations) {
            Figure figure = annotation.getFigure();
            if (figure instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) figure;
                if (x >= rectangle.getX1() && x <= rectangle.getX2() &&
                        y >= rectangle.getY1() && y <= rectangle.getY2()) {
                    return annotation;
                }
            } else if (figure instanceof Circle) {
                Circle circle = (Circle) figure;
                int dx = x - circle.getX();
                int dy = y - circle.getY();
                if (dx * dx + dy * dy <= circle.getRadius() * circle.getRadius()) {
                    return annotation;
                }
            }
        }
        return null;
    }

    public Annotation findByLabel(String label) {
        for (Annotation annotation : annotations) {
            if (annotation.getLabel().contains(label)) {
                return annotation;
            }
        }
        return null;
    }

    public void moveFigure(Annotation annotation, int dx, int dy) {
        if (annotation != null) {
            annotation.getFigure().move(dx, dy);
        }
    }
}

