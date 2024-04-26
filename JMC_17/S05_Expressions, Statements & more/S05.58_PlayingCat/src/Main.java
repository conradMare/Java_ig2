public class Main {
    public static void main(String[] args) {

        System.out.println(isCatPlaying(false, 35));
    }

    public static boolean isCatPlaying(boolean summer, int temperature) {
        boolean playing = false;
        int limit = 35;

        if (summer)
            limit = 45;

        if (temperature >= 25 && temperature <= limit)
            playing = true;

        return playing;
    }
}
