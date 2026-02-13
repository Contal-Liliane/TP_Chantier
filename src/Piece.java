public class Piece {
    private String nom;
    private boolean electrifiee = false;
    private boolean platree = false;

    public Piece(String nom) { this.nom = nom; }
    public String getNom() { return nom; }

    public synchronized void electrifier() {
        this.electrifiee = true;
        this.notifyAll(); // Réveille les plâtriers en attente sur CETTE pièce
    }

    public synchronized void attendreElectricite() throws InterruptedException {
        while (!electrifiee) {
            wait(); // Le plâtrier attend ici
        }
    }

    public synchronized void platrer() {
        this.platree = true;
    }
}