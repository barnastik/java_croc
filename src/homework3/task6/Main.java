package homework3.task6;



class Annotation {
    private final String label;
    private final Figure figure;

    public Annotation(String label, Figure figure) {
        this.label = label;
        this.figure = figure;
    }

    public String getLabel() {
        return label;
    }

    public Figure getFigure() {
        return figure;
    }

    @Override
    public String toString() {
        return figure.toString() + ": " + label;
    }
}

abstract class Figure {
    public abstract boolean containsPoint(int x, int y);
}

class Rectangle extends Figure  {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public boolean containsPoint(int x, int y) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }

    @Override
    public String toString() {
        return "Rectangle (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")";
    }
}

class Circle extends Figure /*implements Movable*/ {
    private final int x;
    private final int y;
    private final int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public boolean containsPoint(int x, int y) {
        return Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2) <= Math.pow(radius, 2);
    }


    @Override
    public String toString() {
        return "Circle (" + x + ", " + y + "), " + radius;
    }
}

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

