public class MegaBytesConverter {
    public static void main(String[] args) {

        printMegaBytesAndKiloBytes(5000);
        printMegaBytesAndKiloBytes(-1024);
        printMegaBytesAndKiloBytes(2500);
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {

        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            long megaBytes = kiloBytes / 1024;
            long remainingKiloBytes = kiloBytes % 1024;
            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + remainingKiloBytes + " KB");
        }
    }
}
