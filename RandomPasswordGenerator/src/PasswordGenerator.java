import java.util.Random;
import java.util.Scanner;

/**
 * class contains the logic for generating random passwords based on user specifications.
 */
public class PasswordGenerator {

 static Scanner sc = new Scanner(System.in);// Scanner for user input


  static Random random = new Random();// Static Random instance to generate random  for characters


     // Method to  generate a password according to user preference
    public void generatePassword() {
        // prompt the user to enter the length of the password
        System.out.print("\nEnter the desired length of the password: ");
        int length = sc.nextInt(); // read the  password length
        sc.nextLine();

        // ask if the user wants lowercase letters in their password
        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = sc.nextLine().equalsIgnoreCase("y");

        // ask if the user wants uppercase letters in their password
        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = sc.nextLine().equalsIgnoreCase("y");

        // ask if the user wants numbers in their password
        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = sc.nextLine().equalsIgnoreCase("y");

        // ask if the user wants special characters in their password
        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialChars = sc.nextLine().equalsIgnoreCase("y");

        // generate the password using the user's preferences
        String password = generatePassword(length, includeLowercase, includeUppercase, includeNumbers, includeSpecialChars);

        // display the generated password or an error message if no character types were selected
        System.out.println("\nGenerated Password: " + password);
    }

    /**
     * method to generate a random password based on user specifications.
     *
     * @param length         The desired length of the password.
     * @param lowercase      Whether to include lowercase letters.
     * @param uppercase      Whether to include uppercase letters.
     * @param numbers        Whether to include numbers.
     * @param specialChars   Whether to include special characters.
     * @return               The generated password or an error message.
     */
    public String generatePassword(int length, boolean lowercase, boolean uppercase, boolean numbers, boolean specialChars) {
        // stringBuilder to construct the password
        StringBuilder password = new StringBuilder();

        // stringBuilder to create all selected character types
        StringBuilder characterPool = new StringBuilder();

        // add lowercase letters to the pool if selected by the user
        if (lowercase) {
            characterPool.append("abcdefghijklmnopqrstuvwxyz");
        }

        // add uppercase letters to the pool if selected by the user
        if (uppercase) {
            characterPool.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }

        // add numbers to the pool if selected by the user
        if (numbers) {
            characterPool.append("0123456789");
        }

        // add special characters to the pool if selected by the user
        if (specialChars) {
            characterPool.append("!@#$%^&*()-_=+[]{}|;:,.<>?/");
        }

        // condition to check if the user selected at least one character type
        if (characterPool.length() == 0) {
            // return an error message if no character type was selected
            return "Error! At least one character type must be selected.";
        }

        // generate the password by selecting random characters from the pool
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());

            password.append(characterPool.charAt(index));
        }

        // convert the StringBuilder to a String and return the generated password
        return password.toString();
    }
}
