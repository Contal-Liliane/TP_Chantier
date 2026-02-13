public class Platrier extends Thread {

    public Platrier(String nom) {
        super(nom);
    }

    public void travailler() {
        try {
            System.out.println(getName() + " (Plâtrier) : je commence à travailler");
            Thread.sleep(10000);
            System.out.println(getName() + " (Plâtrier) : j'ai fini mon travail");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        travailler();
    }
}
