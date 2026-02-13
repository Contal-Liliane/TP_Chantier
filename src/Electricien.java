import java.util.List;
import java.util.concurrent.Semaphore;

public class Electricien extends Thread {
    private List<Piece> pieces;
    private Semaphore s;
    private static int compteur = 0;
    private static final int NB_ELECTRICIENS = 3;

    public Electricien(String nom, List<Piece> pieces, Semaphore s) {
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

                System.out.println("Electricien " + getName() + " commence : " + p.getNom());
                Thread.sleep(5000);
                p.electrifier();
                System.out.println("Electricien " + getName() + " termine : " + p.getNom());
            }

            synchronized (Electricien.class) {
                compteur++;
                if (compteur == NB_ELECTRICIENS) {
                    s.release();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}