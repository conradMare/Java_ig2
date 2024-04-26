public class TeenNumberChecker {
    public static void main(String[] args) {
        System.out.println(hasTeen(1, 2, 3) + " " + isTeen(4));
    }

    public static boolean hasTeen(int num1, int num2, int num3) {
        return (num1 > 12 && num1 < 20) || (num2 > 12 && num2 < 20) || (num3 > 12 && num3 < 20);
    }

    public static boolean isTeen(int nums) {
        return nums > 12 && nums < 20;
    }
}
