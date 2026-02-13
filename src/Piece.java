public class Piece {
    private String nom;
    private boolean electrifiee = false;
    private int occupants = 0;
    private boolean platree = false;

    public Piece(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public synchronized void entrer() {
        occupants++;
        if (occupants > 1) {
            throw new IllegalStateException("DEUX OUVRIERS DANS LA PIECE !");
        }
    }

    public synchronized void sortir() {
        occupants--;
    }

    public synchronized void electrifier() {
        electrifiee = true;
        notifyAll();
    }

    public synchronized void platrer() {
        this.platree = true;
    }

    public synchronized void attendreElectricite() throws InterruptedException {
        while (!electrifiee) {
            wait();
        }
    }

    public boolean isElectrifiee() {
        return electrifiee;
    }

    public boolean isPlatree() {
        return electrifiee;
    }

    public int getOccupants() {
        return occupants;
    }
}