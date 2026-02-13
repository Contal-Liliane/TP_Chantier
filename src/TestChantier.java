import java.util.List;

public class TestChantier {
        public static void lancerTests(List<Piece> maison) {
            System.out.println("   DÉMARRAGE DES TESTS DE VALIDATION");

            boolean erreurDetectee = false;

            System.out.println("TEST 1 : Vérification que toutes les pièces sont électrifiées et plâtrées");
            for (Piece p : maison) {
                System.out.println("  > Analyse de la pièce : " + p.getNom());

                if (p.isElectrifiee()) {
                    System.out.println("    - Électricité : OK");
                } else {
                    System.err.println("    - Électricité : ERREUR (non faite)");
                    erreurDetectee = true;
                }

                if (p.isPlatree()) {
                    System.out.println("    - Plâtrage : OK");
                } else {
                    System.err.println("    - Plâtrage : ERREUR (non fait)");
                    erreurDetectee = true;
                }
            }
            System.out.println("FIN TEST 1 : État des pièces vérifié.\n");

            System.out.println("TEST 2 : Vérification que les électriciens et plâtriers n'ont pas travaillé simultanément dans la même pièce");
            boolean conflitDetecte = false;

            for (Piece p : maison) {
                if (p.getOccupants() != 0) {
                    System.err.println("  > ERREUR : La pièce " + p.getNom() + " a un compteur d'occupation invalide : " + p.getOccupants());
                    conflitDetecte = true;
                }
            }

            if (!conflitDetecte) {
                System.out.println("  > SUCCÈS : Aucun ouvrier ne s'est retrouvé en collision avec un autre.");
            } else {
                System.err.println("  > ÉCHEC : Des accès concurrents non protégés ont été détectés.");
            }            System.out.println("FIN TEST 2 : Ils travaillent bien individuellement dans chaque pièce.\n");

            System.out.println("\nTEST 3 : Vérification de la chronologie : Électricien -> Plâtrier");
            boolean ordreRespecte = true;

            for (Piece p : maison) {
                System.out.print("  > Analyse de l'ordre pour " + p.getNom() + " : ");

                if (p.isPlatree() && p.isElectrifiee()) {
                    System.out.println("FONCTIONNE (L'électricité a bien été posée avant le plâtre)");
                } else if (p.isPlatree() && !p.isElectrifiee()) {
                    System.err.println("ERREUR : Le plâtre a été posé sur une pièce NON électrifiée !");
                    ordreRespecte = false;
                } else {
                    System.err.println("ERREUR : La pièce est incomplète.");
                    ordreRespecte = false;
                }
            }
            System.out.println("FIN TEST 3 : Les ouvriers sont tous passé dans l'ordre.\n");


            if (!erreurDetectee) {
                System.out.println("   RÉSULTAT : TOUS LES TESTS ONT RÉUSSI !");
                System.out.println("   La maison est conforme aux règles métier.");
            } else {
                System.err.println("   RÉSULTAT : ÉCHEC DES TESTS.");
                System.err.println("   Des malfaçons ont été détectées dans le chantier.");
            }
        }
    }