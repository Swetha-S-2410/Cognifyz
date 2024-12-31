import java.util.Random;
import java.util.Scanner;
public class RandomPasswordGenerator {
    public static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialChars) {
        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()-_+=<>?";
        StringBuilder passwordChars = new StringBuilder();

        if (includeNumbers) {
            passwordChars.append(numbers);
        }
        if (includeLowercase) {
            passwordChars.append(lowercaseLetters);
        }
        if (includeUppercase) {
            passwordChars.append(uppercaseLetters);
        }
        if (includeSpecialChars) {
            passwordChars.append(specialChars);
        }
        if (passwordChars.length() == 0) {
            return "";
        }
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(passwordChars.length());
            password.append(passwordChars.charAt(index));
        }
        return password.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the desired length of the password:");
        int length = scanner.nextInt();
        System.out.println("Include numbers? (true/false):");
        boolean includeNumbers = scanner.nextBoolean();
        System.out.println("Include lowercase letters? (true/false):");
        boolean includeLowercase = scanner.nextBoolean();
        System.out.println("Include uppercase letters? (true/false):");
        boolean includeUppercase = scanner.nextBoolean();
        System.out.println("Include special characters? (true/false):");
        boolean includeSpecialChars = scanner.nextBoolean();
        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);
        if (password.isEmpty()) {
            System.out.println("No valid character types selected. Cannot generate a password.");
        } else {
            System.out.println("Generated Password: " + password);
        }
        scanner.close();
    }
}

