public class PasswordCrackerFactory {
    public static PasswordCracker getInstance (int choix1, int choix2, String password) {

        PasswordCracker cracker = null;
        
        if (choix1==1 && choix2==1) {
            cracker = BruteForceCracker.crackPassword1(password);
        } 
        else if (choix1==1 && choix2==2) {
            cracker = DictionaryCracker.crackPassword2(password);
        }
        else if (choix1==2 && choix2==1) {
            cracker = BruteForceHacher.crackPassword3(password);
        } 
        else if (choix1==2 && choix2==2){
            cracker = DictionaryHacher.crackPassword4(password);
        } 
        else 
        System.out.println("choix invalide");
        
        return cracker;
    }
}
