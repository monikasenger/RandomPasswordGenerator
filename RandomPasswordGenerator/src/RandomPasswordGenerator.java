import java.util.Scanner;

/**
 * class to handles user interaction for generating random passwords.
 */
public class RandomPasswordGenerator {
    static Scanner sc = new Scanner(System.in);

    //  PasswordGenerator instance to generate passwords
    static PasswordGenerator pass = new PasswordGenerator();

    // user choice variable for condition
    static char ans;

    public static void main(String[] args) {
        // welcome message
        System.out.println("\n*************** RANDOM PASSWORD GENERATOR ***************");

        // loop to allow the user to generate multiple passwords
        do {
            // call generate  password method bye using object
            pass.generatePassword();

            // prompt the user to decide if they want to generate another password
            System.out.println("\nDo you want to generate another password? (Y/N): ");
            ans = sc.next().charAt(0); // read the first character of the user's input
        } while (ans == 'y' || ans == 'Y'); // continue the loop if the user inputs 'Y' or 'y'

        // thank the user for using the program
        System.out.println("\nThank You :)");
    }
}
