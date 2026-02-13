public class Main {

    public static void main(String[] args) throws InterruptedException {
        for int i = 0; i < 3; i++) {
            new Platrier("Electicien " + (i + 1)).start();
        }

        for (int i = 0; i < 2; i++) {
            new Electricien("Platrier " + (i + 1)).start();
        }

    }