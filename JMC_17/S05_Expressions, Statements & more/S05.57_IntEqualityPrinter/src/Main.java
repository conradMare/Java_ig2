public class Main {
    public static void main(String[] args) {

        printEqual(5, 3, 9);
        printEqual(3, 4, 3);
        printEqual(5, 5, 5);
    }

    public static void printEqual(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0) {
            System.out.println("Invalid Value");
            return;
        }

        if (x == y && y == z) {
            System.out.println("All numbers are equal");
        } else if (x == y || y == z || z == x) {
            System.out.println("Neither all are equal or different");
        } else {
            System.out.println("All numbers are different");
        }
    }
}
