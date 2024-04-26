public class Main {
    public static void main(String[] args) {

        printYearsAndDays(751_000);
    }

    public static void printYearsAndDays(long minutes){
        if (minutes < 0){
            System.out.println("Invalid Value");
        } else {
            long year = minutes / 525600;
            long remainingMinutes = minutes % 525600;
            long days = remainingMinutes / 1440;

            System.out.println(minutes + " min = " + year + " years and " + days + " days");
        }
    }
}
