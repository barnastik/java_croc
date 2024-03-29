package barnastik.homework3.task6.figure;

import barnastik.homework3.task6.functions.Movable;

public class Rectangle extends Figure implements Movable {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

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

    @Override
    public void move(int dx, int dy) {
        x1 += dx;
        y1 += dy;
        x2 += dx;
        y2 += dy;
    }

    public int getX1() {

        return x1;
    }

    public int getX2() {

        return x2;
    }

    public int getY1() {

        return y1;
    }

    public int getY2() {

        return y2;
    }


}

