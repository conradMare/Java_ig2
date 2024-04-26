public class Main {
    public static void main(String[] args) {

        System.out.println(area(10));
        System.out.println(area(20));
    }

    public static double area(double radius) {
        if (radius < 0) {
            return -1;
        } else {
            double PI = Math.PI;
            double areaofcircle = radius * radius * PI;
            return areaofcircle;

        }
    }

    public static double area(double x, double y) {

        if (x < 0) {
            return -1;
        } else if (y < 0) {
            return -1;
        } else {
            double areaofrectangle = x * y;
            return areaofrectangle;

        }
    }
}
