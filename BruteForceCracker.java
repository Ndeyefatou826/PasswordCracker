public class BruteForceCracker {
    
    private static final char[] LETTRES = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static PasswordCracker crackPassword1(String password) {

        String motRecherche = password; // Mot à rechercher fourni par l'utilisateur
        
        long debut = System.currentTimeMillis(); // Temps de départ
        
        trouverMotRecursif(motRecherche, LETTRES, "");
        
        long duree = System.currentTimeMillis() - debut; // Calcul de la durée écoulée en millisecondes
        
        System.out.println("Temps écoulé: " + duree + " millisecondes");
        return null;
    
    }
    private static void trouverMotRecursif(String motRecherche, char[] lettres, String motActuel) {
        if (motActuel.length() == motRecherche.length()) {
            if (motActuel.equals(motRecherche)) {
                System.out.println("Le mot de passe saisi est: " + motActuel);
            }
            return;
        }

        for (int i = 0; i < lettres.length; i++) {
            trouverMotRecursif(motRecherche, lettres, motActuel + lettres[i]);
        }
    }

}



    

