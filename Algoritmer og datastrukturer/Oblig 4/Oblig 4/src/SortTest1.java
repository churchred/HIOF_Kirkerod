import java.util.*;

public class SortTest1 {


    public static void main(String[] args) {

        // Oppgave 1
        //
        System.out.println("Oppgave 1");
        oppgave_1();

    }

    // Oppgave 1
    //
    public static void oppgave_1(){
        System.out.println("   n            tA         tL      tL/tA");
        System.out.println("------------------------------------------");
        int m = 1_000_000;

        // Looper igjennom 10 ganger og øker n med i-ganger
        for(int i = 1; i <= 10; i++){

            int n = m*i;

            // Lager listene våre
            int A[] = makeList(n);
            LinkedList<Integer> L = makeLinkedList(n);

            // Så tar vi tiden på sortertingen av hver liste
            long tA, tL, t;

            // Vanlig liste
            t = System.currentTimeMillis();
            Arrays.sort(A);
            tA = System.currentTimeMillis() - t;

            // Linked liste
            t = System.currentTimeMillis();
            Collections.sort(L);
            tL = System.currentTimeMillis() - t;

            // Printer ut resultatet:
            System.out.printf("%5d %10d %10d %10.2f%n",
                    n, tA, tL, (float) tL / (float) tA);

        }
    }

    // Fyller en liste med n-antall tall (usortert)
    public static int[] makeList(int n) {

        // Legger inn n tilfeldige tall i en array
        int A[] = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++)
            A[n - i - 1] = r.nextInt(2 * n);

        // Sorterer dataen i listen (Quicksort+)
        // Arrays.sort(A);

        return A;
    }

    // Fyller en linked liste med n-antall tall (usortert)
    public static LinkedList<Integer> makeLinkedList(int n) {

        // Legger inn n tilfeldige tall i en lenket liste
        LinkedList<Integer> L = new LinkedList<Integer>();
        Random r = new Random();
        for (int i = 0; i < n; i++)
            L.addFirst(Integer.valueOf(r.nextInt(2*n)));

        // Sorterer den linkede lista (Timesort)
        // Collections.sort(L);

        return L;
    }

}