import java.io.*;
import java.net.*;

public class BruteForce extends Cracker {

    public String passwordCrack() throws IOException {

        String alphanum = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        String pwd = "";
        for (int i = 0; i < alphanum.length(); i++) {
            for (int j = 0; j < alphanum.length(); j++) {
                for (int w = 0; w < alphanum.length(); w++) {
                    for (int k = 0; k < alphanum.length(); k++) {
                        for (int z = 0; z < alphanum.length(); z++) {

                            pwd = alphanum.charAt(i) + "" + alphanum.charAt(j) + alphanum.charAt(w) + alphanum.charAt(k)
                                    + alphanum.charAt(z);
                            URL url = new URL("http://localhost/User.php?pwd=" + pwd);
                            URLConnection connection = url.openConnection();

                            try (BufferedReader in = new BufferedReader(
                                    new InputStreamReader(connection.getInputStream()))) {
                                String line;
                                while ((line = in.readLine()) != null) {
                                    if (line.equals("c'est pas le bon")) {
                                        // Ne rien faire ici si le résultat n'est pas correct
                                    } else {
                                        // Afficher uniquement les résultats corrects
                                        System.out.println("Connexion reussie ");
                                        System.out.println("Mot de passe trouvé : " + pwd);
                                        return null;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Aucun mot de passe trouvé.");
        return pwd;
    }

}