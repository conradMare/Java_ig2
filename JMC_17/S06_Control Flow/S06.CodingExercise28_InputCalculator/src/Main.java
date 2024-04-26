import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputCalculator.inputThenPrintSumAndAverage();
    }

    public class InputCalculator {
        public static void inputThenPrintSumAndAverage() {
            Scanner scanner = new Scanner(System.in);
            int sum = 0;
            int count = 0;
            long average = 0;

            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
                count++;
            }

            scanner.close();

            if (count > 0) {
                average = Math.round(sum / (double) count);
            }
            System.out.println("SUM = " + sum + " AVG = " + average);
        }
    }
}
