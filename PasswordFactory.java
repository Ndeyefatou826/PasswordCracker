public class PasswordFactory {
    public Cracker getCracker(String CrackerType) {
        if (CrackerType == null) {
            return null;
        }
        if (CrackerType.equalsIgnoreCase("Force Brute")) {
            return new BruteForce();
        } else if (CrackerType.equalsIgnoreCase("Dictionnaire")) {
            return new Dictionnaire();
        }
        return null;
    }
}
