import java.util.*;

public class CaesarCipher {
    private static final Scanner scanner = new Scanner(System.in);

    // Encrypts text using a Caesar cipher with the given shift value
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                result.append((char) (((character - base + shift) % 26) + base));
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    // Decrypts text encrypted with a Caesar cipher with the given shift value
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift); // Decrypting is just encrypting with the negative shift
    }

    public static String inputText() {
        return scanner.nextLine();
    }

    public static int shift() {
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        System.out.println("Input a string to be encrypted: ");
        String text = inputText();
        System.out.println("Type the integer you want to shift by: ");
        int shift = shift();

        String encryptedText = encrypt(text, shift);
        System.out.println("Encrypted: " + encryptedText);

        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted: " + decryptedText);
        
        // Close the scanner when done
        scanner.close();
    }
}