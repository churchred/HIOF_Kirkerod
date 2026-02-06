import java.util.Scanner;

public class Oppgave_5_6 {
    public static void main(String[] args) {

        // Oppgave 5:
        //
        int n = 8;
        int m = 3;
        System.out.println("\n\nOppgave 5: ");
        System.out.println(String.format("Answer: C(%d, %d) = %d", n, m, C_iterativ(n, m)));

        // Oppgave 6
        //

        // Get user input
        Scanner S = new Scanner(System.in);
        System.out.println("\n\nOppgave 6:");
        System.out.println("Velg verdi for n");
        System.out.print("$ ");
        int valg = S.nextInt();

        // Calculate all n-values
        for(int i = 0; i <= valg; i++){
            System.out.println(
                    String.format("C(%d, %d) = %d", valg, i, C_iterativ(valg, i))
            );
        }
    }


    public static long C_iterativ(int n, int m){

        // Lager en nested liste som kan holde hver rad i trekanten
        // (Plusser på 1 siden n=8 skal inkludere 0 til og med 8)
        long[][] list = new long[n+1][n+1];

        // Går igjennom alle radene for n-rader
        for (int row = 0; row <= n; row++) {

            // Så lager vi hver verdi til raden vi er på
            for(int col = 0; col <= row; col++){

                // Hvis vi er på første eller siste element i raden så er svaret alltid 1
                if(col == 0)  list[row][col] =  1;
                else if(col == row)  list[row][col] =  1;

                // Hvis ikke regner vi ut svaret basert på raden over
                else list[row][col] = list[row-1][col-1] + list[row-1][col];

                // Printing for testing purposes
                // System.out.println(String.format("C(%d, %d) = %d", row, col, list[row][col]));

                // Hvis svaret er regnet ut så stopper vi selv om vi ikke er ferdig med hele raden
                if (col == m) break;
            }
        }

        return list[n][m];
    }
}