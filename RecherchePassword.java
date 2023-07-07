import java.util.Scanner;

public class RecherchePassword {
    public static void main(String[] args) throws Exception {
        PasswordFactory passwordFactory = new PasswordFactory();

        Scanner sc = new Scanner(System.in);
        /*
          System.out.println("Entrer un mot de passe");
          String psw = sc.nextLine();
        */

        System.out.println("Cracker password par :");
        System.out.println("1: Force Brute !:");
        System.out.println("2: Dictionnaire !:");

        int choix = sc.nextInt();

        switch (choix) {
            case 1:
                Cracker BruteForce = passwordFactory.getCracker("Force Brute");
                long debut = System.currentTimeMillis();
                BruteForce.passwordCrack();
                long fin = System.currentTimeMillis();
                System.out.println("La recherche a durée "+((fin-debut)/1000)+" secondes");
                break;
                
            case 2:
                Cracker Dictionnaire = passwordFactory.getCracker("Dictionnaire");
                long debut2 = System.currentTimeMillis();
                Dictionnaire.passwordCrack();
                long fin2 = System.currentTimeMillis();
                System.out.println("La recherche a durée "+((fin2-debut2)/1000)+" secondes");
                break;
            default:
                System.out.println("Il faut choisir entre 1 && 2");
                break;
        }
        sc.close();
    }
}