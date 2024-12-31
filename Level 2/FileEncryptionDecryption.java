import java.io.*;
import java.util.Scanner;
public class FileEncryptionDecryption {
    static final int SHIFT = 4;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Encrypt a file");
        System.out.println("2. Decrypt a file");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter the file name or path: ");
        String filePath = scanner.nextLine();
        System.out.print("Enter the output file name or path: ");
        String outputFilePath = scanner.nextLine();
        try {
            String content = readFile(filePath);
            String result;
            if (choice == 1) {
                result = encrypt(content);
                System.out.println("File has been encrypted.");
            } else if (choice == 2) {
                result = decrypt(content);
                System.out.println("File has been decrypted.");
            } else {
                System.out.println("Invalid choice.");
                scanner.close();
                return;
            }
            writeFile(outputFilePath, result);
        } catch (IOException e) {
            System.out.println("An error occurred while handling the file.");
            e.printStackTrace();
        }
        scanner.close();
    }
    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }

        reader.close();
        return content.toString();
    }
    public static void writeFile(String filePath, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(content);
        writer.close();
    }
    public static String encrypt(String content) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : content.toCharArray()) {
            if (Character.isLetter(c)) {
                char shifted = (char) (c + SHIFT);
                if (Character.isLowerCase(c) && shifted > 'z') {
                    shifted = (char) (shifted - 26);
                } else if (Character.isUpperCase(c) && shifted > 'Z') {
                    shifted = (char) (shifted - 26);
                }
                encrypted.append(shifted);
            } else {
                encrypted.append(c); 
            }
        }
        return encrypted.toString();
    }
    public static String decrypt(String content) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : content.toCharArray()) {
            if (Character.isLetter(c)) {
                char shifted = (char) (c - SHIFT);
                if (Character.isLowerCase(c) && shifted < 'a') {
                    shifted = (char) (shifted + 26);
                } else if (Character.isUpperCase(c) && shifted < 'A') {
                    shifted = (char) (shifted + 26);
                }
                decrypted.append(shifted);
            } else {
                decrypted.append(c); 
            }
        }
        return decrypted.toString();
    }
}
