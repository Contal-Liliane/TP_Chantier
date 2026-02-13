import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Liste des pièces à traiter
        List<Piece> piecesPourElec = Collections.synchronizedList(new ArrayList<>());
        List<Piece> piecesPourPlat = Collections.synchronizedList(new ArrayList<>());

        String[] noms = {"Cuisine", "Salon", "Chambre 1", "Chambre 2", "Salle de bain", "WC", "Garage", "Grenier", "Bureau", "Terrasse"};
        for (String n : noms) {
            Piece p = new Piece(n);
            piecesPourElec.add(p);
            piecesPourPlat.add(p);
        }

        Electricien[] elecs = {
                new Electricien("Tod", piecesPourElec),
                new Electricien("Tad", piecesPourElec),
                new Electricien("Ted", piecesPourElec)
        };

        Platrier[] plats = {
                new Platrier("Pit", piecesPourPlat),
                new Platrier("Pet", piecesPourPlat)
        };

        for (Electricien e : elecs) e.start();
        for (Platrier p : plats) p.start();

        for (Electricien e : elecs) e.join();
        for (Platrier p : plats) p.join();

        System.out.println("La maison est terminée");
    }
}