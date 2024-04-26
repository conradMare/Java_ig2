public class TernaryOperatorExample {
    public static void main(String[] args) {
        int ageClient =20;
        String ageText = (ageClient >= 18) ? "Over eighteen" : "Still a kid";
        System.out.println("Our client is " + ageText);
    }
}
