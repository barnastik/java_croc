package barnastik.homework3.task6;

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
