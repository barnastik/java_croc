package barnastik.homework3.task6;

class Circle extends Figure implements Movable {
    private int x;
    private int y;
    private int radius;

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

    @Override
    public void move(int dx, int dy) {
        int x_new = x + dx;
        int y_new = y + dy;
        this.x = x_new;
        this.y = y_new;

    }
    public int getX() {

        return x;
    }

    public void setX(int x) {

        this.x = x;
    }

    public int getY() {

        return y;
    }

    public void setY(int y) {

        this.y = y;
    }

    public int getRadius() {

        return radius;
    }
}
