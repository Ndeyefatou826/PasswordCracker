import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

public class BruteForceHacher{

    private static final char[] LETTRES = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static PasswordCracker crackPassword3(String password) {
        String hachageRecherche = password; // Hachage à rechercher fourni par l'utilisateur

        long debut = System.nanoTime(); // Temps de départ

        String motTrouve = rechercherMotParHachage(hachageRecherche);

        long duree = System.nanoTime() - debut; // Calcul de la durée écoulée en nanosecondes
        long dureeMillisecondes = TimeUnit.NANOSECONDS.toMillis(duree); // Conversion en millisecondes

        if (motTrouve != null) {
            System.out.println("Mot correspondant trouvé : " + motTrouve);
        } else {
            System.out.println("Aucun mot correspondant trouvé.");
        }

        System.out.println("Temps écoulé : " + dureeMillisecondes + " millisecondes");
   
        return null;
    }

    private static String rechercherMotParHachage(String hachageRecherche) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();

            for (int longueurMot = 1; longueurMot <= LETTRES.length; longueurMot++) {
                String motTrouve = rechercherMotRecursif(md, sb, hachageRecherche, longueurMot);
                if (motTrouve != null) {
                    return motTrouve; // Mot correspondant trouvé
                }
            }

            return null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String rechercherMotRecursif(MessageDigest md, StringBuilder sb, String hachageRecherche, int longueurMot) {
        if (sb.length() == longueurMot) {
            String mot = sb.toString();
            String hachage = calculerHachage(md, mot);

            if (hachage.equals(hachageRecherche)) {
                return mot; // Mot correspondant trouvé
            }

            return null;
        }

        for (char lettre : LETTRES) {
            sb.append(lettre);
            String motTrouve = rechercherMotRecursif(md, sb, hachageRecherche, longueurMot);
            if (motTrouve != null) {
                return motTrouve; // Mot correspondant trouvé
            }
            sb.setLength(sb.length() - 1);
        }

        return null;
    }

    private static String calculerHachage(MessageDigest md, String mot) {
        md.update(mot.getBytes());
        byte[] digest = md.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    
}


