import model.IntroScreen;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Keyboard terminal ENTER listener
        Scanner scanner = new Scanner(System.in);

        // Display intro screen
        IntroScreen intro = new IntroScreen();
        intro.play();

        System.out.println("\n\nPress Enter to begin you adventure...");
        scanner.nextLine(); // Waits for user to press Enter

        System.out.println("Enter you name: ");
        String name = scanner.nextLine(); // Waits for user to press Enter
        System.out.println(name);

    }

}
