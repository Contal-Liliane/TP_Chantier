import java.util.*;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore s = new Semaphore(0);

        List<Piece> aElectrifier = Collections.synchronizedList(new ArrayList<>());
        List<Piece> aPlatrer = Collections.synchronizedList(new ArrayList<>());

        List<Piece> maisonComplete = new ArrayList<>();
        String[] noms = {"Cuisine", "Salon", "Chambre 1", "Chambre 2", "Salle de bain", "WC", "Garage", "Entrée", "Bureau", "Terrasse"};
        for (String nom : noms) {
            Piece p = new Piece(nom);
            aElectrifier.add(p);
            aPlatrer.add(p);
        }

        Electricien e1 = new Electricien("Tod", aElectrifier, s);
        Electricien e2 = new Electricien("Tad", aElectrifier, s);
        Electricien e3 = new Electricien("Ted", aElectrifier, s);

        Platrier p1 = new Platrier("Pit", aPlatrer, s);
        Platrier p2 = new Platrier("Pet", aPlatrer, s);

        e1.start(); e2.start(); e3.start();
        p1.start(); p2.start();

        e1.join(); e2.join(); e3.join();
        p1.join(); p2.join();

        TestChantier.lancerTests(maisonComplete);
        System.out.println("La maison est terminée");
    }
}