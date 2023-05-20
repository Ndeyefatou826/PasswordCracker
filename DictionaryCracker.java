import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DictionaryCracker{

    public static PasswordCracker crackPassword2(String password) {

        String motRecherche = password; // Mot à rechercher fourni par l'utilisateur
        String fichierCSV = "password.csv"; // Chemin vers le fichier CSV

        long debut = System.nanoTime(); // Temps de départ

        boolean motTrouve = rechercherMotDansCSV(motRecherche, fichierCSV);

        long duree = System.nanoTime() - debut; // Calcul de la durée écoulée en nanosecondes
        long dureeMillisecondes = TimeUnit.NANOSECONDS.toMillis(duree); // Conversion en millisecondes

        if (motTrouve) {
            System.out.println("Le mot de passe est : " + motRecherche);
        } else {
            System.out.println("Le mot de passe n'a pas été trouvé.");
        }

        System.out.println("Temps écoulé: " + dureeMillisecondes + " millisecondes");

        return null; 
    }
    private static boolean rechercherMotDansCSV(String motRecherche, String fichierCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichierCSV))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] mots = ligne.split(",");
                for (String mot : mots) {
                    if (mot.equals(motRecherche)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    
}


