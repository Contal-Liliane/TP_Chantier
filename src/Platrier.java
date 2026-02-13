import java.util.List;
import java.util.concurrent.Semaphore;

public class Platrier extends Thread {
    private List<Piece> pieces;
    private Semaphore s;

    public Platrier(String nom, List<Piece> pieces, Semaphore s) {
        super(nom);
        this.pieces = pieces;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Piece p;
                synchronized (pieces) {
                    if (pieces.isEmpty()) break;
                    p = pieces.remove(0);
                }

                p.attendreElectricite();

                System.out.println("Platrier " + getName() + " commence : " + p.getNom());
                Thread.sleep(10000);
                p.platrer();
                System.out.println("Platrier " + getName() + " termine : " + p.getNom());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}