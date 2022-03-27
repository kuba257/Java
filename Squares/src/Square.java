public class Square {
    private final int number;
    private double side;
    private double x;
    private double y;

    public Square(int number, double side, double x, double y) {
        this.number = number;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public int getNumber() {
        return number;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Square{" +
                "number=" + number +
                ", side=" + side +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
