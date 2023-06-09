
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connexion {
    public static void main(String[] args) {
        try {
            // URL du script PHP qui gère la requête
            String url = "http://localhost/Networking/formulaire.php";
            
            // Paramètres de la requête (login et mot de passe)
            String login = "admin";
            String password = "passe";
            
            // Création de l'URL
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            
            // Spécification de la méthode de requête (POST dans ce cas)
            con.setRequestMethod("POST");
            
            // Envoi des paramètres de la requête
            String postData = "login=" + login + "&password=" + password;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postData);
            wr.flush();
            wr.close();
            
            // Récupération de la réponse du script PHP
            int responseCode = con.getResponseCode();
            
            // Vérification du code de réponse HTTP
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Les informations de connexion sont correctes
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                System.out.println("Connexion réussie !");
                System.out.println("Le mot de passe est: " +password);
            } else {
                // Les informations de connexion sont incorrectes
                System.out.println("Connexion échouée : Informations de connexion incorrectes.");
            }
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la connexion : " + e.getMessage());
        }
    }
}
