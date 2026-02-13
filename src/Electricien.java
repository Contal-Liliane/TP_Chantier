public class Electricien extends Thread {

    public Electricien(String nom) {
        super(nom);
    }

    public void travailler() {
        try {
            System.out.println(getName() + " (Électricien) : je commence à travailler");
            Thread.sleep(5000);
            System.out.println(getName() + " (Électricien) : j'ai fini mon travail");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        travailler();
    }
}
