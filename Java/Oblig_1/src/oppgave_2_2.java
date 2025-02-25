import java.text.DecimalFormat;  // To round the answer
import java.util.Scanner;        // Import the Scanner class

public class oppgave_2_2 {
    public static void main(String[] args) {

       // Gravitasjonen på månen er ca. 16.5 prosent av jordens.
       // Skriv et program som beregner din vekt på månen.


        // Lager et object som kan lese input
        Scanner input = new Scanner(System.in);  // Create a Scanner object

        // Ask for and read user input
        System.out.println("Enter you weight(kg): ");
        double earthWeight = input.nextDouble();

        // Calculate and present new weight
        double moonWeight = earthWeight * 0.165;

        // Limit new value to two decimal places
        DecimalFormat round = new DecimalFormat("#.00");
        String roundedMoonWeight = round.format(moonWeight);

        // Print answer
        //System.out.println("(" + earthWeight + "kg(earth) --> " + roundedMoonWeight + "kg(moon)");
        System.out.println("Your weight on the moon would be " + roundedMoonWeight + "kg");



    }
}
