import java.util.List;

public class Platrier extends Thread {
    private List<Piece> piecesAPlatrer;

    public Platrier(String nom, List<Piece> pieces) {
        super(nom);
        this.piecesAPlatrer = pieces;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Piece p;
                synchronized (piecesAPlatrer) {
                    if (piecesAPlatrer.isEmpty()) break;
                    p = piecesAPlatrer.remove(0);
                }

                // Attente spécifique à la pièce
                p.attendreElectricite();

                System.out.println("Platrier " + getName() + " commence : " + p.getNom());
                Thread.sleep(10000);
                p.platrer();
                System.out.println("Platrier " + getName() + " termine : " + p.getNom());
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}