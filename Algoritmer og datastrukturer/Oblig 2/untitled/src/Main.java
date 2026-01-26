import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

class Oblig_2
{
    public static void lineær(long n)
    {
        int tmp = 1;
        for (long i = 0; i < n; i++)
            tmp *= 1;
    }

    public static void kvadratisk(long n)
    {
        int tmp = 1;
        for (long i = 0; i < n; i++)
            for (long j = 0; j < n; j++)
                tmp *= 1;
    }

    public static int logaritmisk(long n)
    {
        int tmp = 1, iterasjoner = 0;
        for (long i = n; i > 0; i /= 2, iterasjoner++)
            tmp *= 1;
        return iterasjoner;
    }


    // skal utføre et antall multiplikasjoner som er lik n·log2n.
    public static void superlineær(long n){
        int tmp = 1;

        // Lineær ytre løkke
        for (long i = 0; i < n; i++)
            // Logaritmisk indre løkke
            for (long j = n; j > 0; j/=2)
                tmp *= 1;

    }

    // skal utføre et antall multiplikasjoner som er lik n^3.
    public static void kubisk(long n){
        int tmp = 1;
        for (long i = 0; i < n; i++){
            for (long j = 0; j < n; j++){
                for (long k = 0; k < n; k++){
                    tmp *= 1;
                }
            }
        }
    }


    // skal utføre et antall multiplikasjoner som er lik 2ⁿ
    public static void eksponentiell(long n){
        int tmp = 1;
        for (long i = 0; i < n; i++)
            tmp *= 1;
    }

    // skal utføre et antall multiplikasjoner som er lik n! (n-fakultet)
    public static void kombinatorisk(long n){
        int tmp = 1;
        for (long i = 0; i < n; i++){
            tmp *= 1;
        }
    }

    public static void main(String[] args)
    {
        Scanner S = new Scanner(System.in);
        long n, T, T1, T2;
        int valg, iterasjoner = 0;

        // Liste med navn på funksjonene (Brukes kun for terminal-pynting)
        ArrayList<String> nameList = new ArrayList<>(
                Arrays.asList(
                        "O(n)",
                        "O(n²)",
                        "O(log n)",
                        "O(n * log n)",
                        "O(n³)",
                        "O(2ⁿ)",
                        "O(n!)"
                )
        );

        // Valg av metode (antar bruker alltid angir gyldige verdier xD)
        System.out.println("1:O(n) 2:O(n²) 3:O(log_n) 4:O(n*log_n) 5:O(n³) 6:O(2ⁿ) 7:O(n!)");
        System.out.print("$ ");
        valg = S.nextInt();
        System.out.println("You chose: " + nameList.get(valg-1));
        System.out.print("How big is n? ");
        n = S.nextLong();

        // eksponentiell, så vil vi regne ut verdien for 2ⁿ FØR vi tar tiden på løkken
        if (valg == 6){
            double value = Math.pow(2, n);
            n = (long) value;
            System.out.println("   -->  (n³ = " + n + ")");
        }
        // kombinatorisk, så vil vi regne ut verdien for n! FØR vi tar tiden på løkken
        if (valg == 7){
            long nn = 1;
            for (long i = 0; i < n; i++) {
                nn *= (n - i);
            }
            n = nn;
            System.out.println("   -->  (n! = " + n + ")");
        }

        // Tar tiden og bruker riktig metode
        T1 = System.currentTimeMillis();
        if (valg == 1)
            lineær(n);
        else if (valg == 2)
            kvadratisk(n);
        else if (valg == 3)
            iterasjoner = logaritmisk(n);
        else if (valg == 4)
            superlineær(n);
        else if (valg == 5)
            kubisk(n);
        else if (valg == 6)
            eksponentiell(n);
        else if (valg == 7)
            kombinatorisk(n);
        T2 = System.currentTimeMillis();


        // Hvis over 1 sekund så får vi tiden i sekunder med 2 gjeldene sifer
        T = T2 - T1;
        if (T > 1000){
            System.out.print("T = " + String.format("%.2f", T / 1000.0) + " s");
        } else{
            System.out.print("T = " + T+ " ms");
        }

        // Hvis vi har med iterasjoner i tellingen
        if (valg == 3)
            System.out.print(" (" + iterasjoner + ")");
        System.out.println();
    }
}