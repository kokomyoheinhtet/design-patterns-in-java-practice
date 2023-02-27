package A2_Factories;

class Point {
    private double x, y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static class Factory {

        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }

        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho * Math.cos(theta), theta * Math.sin(rho));
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class PointFactoryDemo {

    public static void main(String[] args) {
        Point cartesianPoint = Point.Factory.newCartesianPoint(1, 1);
        System.out.println(cartesianPoint);
        Point polarPoint = Point.Factory.newPolarPoint(30, 45);
        System.out.println(polarPoint);

    }
}
