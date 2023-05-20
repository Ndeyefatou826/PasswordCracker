import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DictionaryHacher{

    public static PasswordCracker crackPassword4(String password) {
        
        String fichierCSV = "password1.csv"; // Chemin vers le fichier CSV
        String hachageRecherche = password; // Hachage à rechercher fourni par l'utilisateur

        long debut = System.nanoTime(); // Temps de départ

        String motCorrespondant = rechercherMotParHachageDansCSV(fichierCSV, hachageRecherche);

        long duree = System.nanoTime() - debut; // Calcul de la durée écoulée en nanosecondes
        long dureeMillisecondes = TimeUnit.NANOSECONDS.toMillis(duree); // Conversion en millisecondes

        if (motCorrespondant != null) {
            System.out.println("Mot correspondant trouvé : " + motCorrespondant);
        } else {
            System.out.println("Aucun mot correspondant trouvé.");
        }

        System.out.println("Temps écoulé : " + dureeMillisecondes + " millisecondes");
    
        return null;
    }

    private static String rechercherMotParHachageDansCSV(String fichierCSV, String hachageRecherche) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fichierCSV))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] motsEtHachages = ligne.split(";"); 
                    String mot = motsEtHachages[0];
                    String hachage = motsEtHachages[1];
                    if (hachage.equals(hachageRecherche)) {
                        return mot; // Mot correspondant trouvé
                    }
                }
            }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Aucun mot correspondant trouvé
    }

    
     
}


