import java.util.*;

public class SortTest2 {


    public static void main(String[] args) {


        // Oppgave 2
        //
        System.out.println("Oppgave 2");
        oppgave_2();

    }


    // Oppgave 2
    //
    public static void oppgave_2(){
        System.out.println("   n            tA         tL      tL/tA");
        System.out.println("------------------------------------------");
        int m = 10_000_000;

        // Looper igjennom 10 ganger og øker n med i-ganger
        for(int i = 1; i <= 10; i++){

            int n = m*i;

            // Lager listene våre
            int A[] = makeListOppgave2(n);
            LinkedList<Integer> L = makeLinkedListOppgave2(n);

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


    // Fyller en liste med n-antall tall (delvis sortert)
    public static int[] makeListOppgave2(int n){

        // Lager array med n-plasser
        int A[] = new int[n];
        Random r = new Random();

        // Krav 1 (0, 1, 2, 3, ... , n/3)
        for(int i = 0; i < n/3; i++){
            A[i] = i;
        }

        // Krav 2 (Tilfeldige tall mellom 0 og 2*n)
        for(int i = n/3; i < 2*(n/3); i++){
            A[i] = r.nextInt(2 * n);
        }

        // Krav 3 ((n/3),(n/3)+1,(n/3)+2,...,(2·n/3)−1)
        for(int i = 2*(n/3); i < 3*(n/3); i++){
            A[i] = i - n/3;
        }

        return A;
    }

    // Fyller en linked liste med n-antall tall (delvis sortert)
    public static LinkedList<Integer> makeLinkedListOppgave2(int n) {


        // Lager linked list med n-plasser
        LinkedList<Integer> L = new LinkedList<Integer>();
        Random r = new Random();

        // Krav 1 (0, 1, 2, 3, ... , n/3)
        for(int i = 0; i < n/3; i++){
            L.addLast(i);
        }

        // Krav 2 (Tilfeldige tall mellom 0 og 2*n)
        for(int i = n/3; i < 2*(n/3); i++){
            L.addLast(r.nextInt(2 * n));
        }

        // Krav 3 ((n/3),(n/3)+1,(n/3)+2,...,(2·n/3)−1)
        for(int i = 2*(n/3); i < 3*(n/3); i++){
            L.addLast(i - n/3);
        }

        return L;

    }

}