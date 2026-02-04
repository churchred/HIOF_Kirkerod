import java.util.Scanner;

public class Oppgave_1_3 {
    public static void main(String[] args) {


        // Oppgave 1:
        //
        System.out.println("\n\nOppgave 1:");
        System.out.println(C_rekursiv(5, 4));

        // Oppgave 2
        //

        System.out.println("\n\nOppgave 2:");
        int max_value = 8;  // So we can center the text in the terminal

        // Loops through all 8 values of n, and all 8 for each of those 8
        for(int i = 0; i <= max_value; i++){
            System.out.print("n=" + i +  " ".repeat((max_value-i)));

            for(int j = 0; j <= i; j++){
                System.out.print(" " + C_rekursiv(i, j));
            }

            System.out.println(""); // New line
        }


        // Oppgave 3
        //

        System.out.println("\n\nOppgave 3:");

        // Get user input
        Scanner S = new Scanner(System.in);
        System.out.println("Velg verdi for n");
        System.out.print("$ ");
        int valg = S.nextInt();

        // Calculate all n-values
        for(int i = 0; i <= valg; i++){
            System.out.println(
                String.format("C(%d, %d) = %d", valg, i, C_rekursiv(valg, i))
            );
        }

    }


    public static long C_rekursiv(int n, int m){

        if(m == 0) return 1;
        else if(m == n) return 1;

        return C_rekursiv(n-1,m) + C_rekursiv(n-1,m-1);
    }
}