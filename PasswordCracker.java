import java.util.Scanner;

public class PasswordCracker {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------------------------");
        System.out.println("Veuillez saisir le mot de passe ou hash:");
        System.out.println("-----------------------------------------");

        String password = sc.nextLine();

        System.out.println("-----------------------------------------");
        System.out.println("Comment souhaitez-vous procéder:");
        System.out.println("-----------------------------------------");
        System.out.println("1.Casser le mot de passe");
        System.out.println("2.Hacher le mot de passe");
        int choix1 = sc.nextInt();

        System.out.println("-----------------------------------------");
        System.out.println("Choisissez la technique:");
        System.out.println("-----------------------------------------");
        System.out.println("1.Par brute force");
        System.out.println("2.Par dictionnaire");
        int choix2 = sc.nextInt();


        PasswordCracker cracker = PasswordCrackerFactory.getInstance(choix1, choix2, password);

       }

    }
