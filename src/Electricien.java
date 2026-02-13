import java.util.List;

public class Electricien extends Thread {
    private List<Piece> pieces;

    public Electricien(String nom, List<Piece> pieces) {
        super(nom);
        this.pieces = pieces;
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
                p.electrifier(); // Libère le verrou pour cette pièce
                System.out.println("Electricien " + getName() + " termine : " + p.getNom());
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}