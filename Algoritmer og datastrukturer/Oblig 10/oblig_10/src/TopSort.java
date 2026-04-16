import java.io.*;
import java.util.*;

// Topologisk sortering

public class TopSort
{
    int n;            // Antall noder i grafen
    boolean nabo[][]; // Nabomatrise
    String data[];    // Data i hver node

    // TopSort(): KonstruktÃ¸r
    // Leser inn grafen fra fil, ingen feilsjekking
    public TopSort(String filNavn)
    {
        // Filformat:
        //   ant.noder
        //   node# data ant.naboer nabo# nabo# ...
        //   node# data ant.naboer nabo# nabo# ...
        //   ...
        try
        {
            // Ã…pner datafil for lesing
            Scanner in = new Scanner(new File(filNavn));
            // Leser antall noder
            n = in.nextInt();
            // Oppretter nabomatrisen
            nabo = new boolean[n][n];
            // Setter hele nabomatrisen, untatt diagonalen, til false
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    nabo[i][j] = (i == j) ? true : false;
            // Oppretter arrayen med data (string) for hver node
            data = new String[n];
            // For hver node: Les data og alle naboene noden har
            for (int i = 0; i < n; i++)
            {
                int nodeNr = in.nextInt();
                data[nodeNr] = in.next();
                int antNaboer = in.nextInt();
                for (int j = 0; j < antNaboer; j++)
                {
                    int naboNr = in.nextInt();
                    nabo[nodeNr][naboNr] = true;
                }
            }

        }
        catch (Exception e)
        {
            System.err.println("Error reading file " + filNavn);
            System.exit(1);
        }
    }

    // findAndPrint(): Finner og skriver ut en topologisk sortering
    public void findAndPrint()
    {
        /*** Skal programmeres i oblig. 10 ***/


        //
        //  1) Gå gjennom hele grafen, beregn og ta vare på inngraden til alle noder.
        //

        // Finner lengden på matrisen sine rader
        int amountOfNodes = data.length;

        // Lager en liste med int's for å holde på inngraden til hver node
        int[] listeInngrad = new int[amountOfNodes];

        // Går igjennom alle node-listene i nabo-listen og holder telling på inngraden til hver node
        for(int i = 0; i<amountOfNodes; i++){
            for(int ii = 0; ii<amountOfNodes; ii++) {

                // Hvis ikke seg selv, og den er True, så øk inngrad med 1
                if(i != ii && nabo[i][ii] == true){
                    listeInngrad[ii]++;
                }
            }
        }


        //
        //  2) Legg alle noder med inngrad lik 0 i en mengde S.
        //

        // Lager liste S
        List<Integer> S = new ArrayList<>();

        // Finner alle elementer i med inngrad 0
        for (int i = 0; i < amountOfNodes; i++) if(listeInngrad[i] == 0) S.add(i);




        //  3) Så lenge det finnes noder igjen i S:
        //         - Ta ut en node a fra mengden S.
        //         - Skriv ut noden a
        //         - For hver av noden a sine naboer som ikke er i S:
        //                  - Reduser inngraden til naboen med 1.
        //                  - Hvis denne naboen nå har fått inngrad lik 0, legg den til i mengden S.
        //
        //

        // Siden målet er å ta ut en og en node til S er tom så bruker jeg en while-løkke
        // (Tok laaang tid å komme hit, prøvde først å lage en kopi av S som jeg lekte med i
        //  en for-løkke..  xD)
        while(!S.isEmpty()){

            // Ta ut en node a fra mengden S.
            int node = S.remove(0);

            // Skriv ut noden a
            System.out.print(data[node] + ", ");

            // For hver av noden a sine naboer som ikke er i S
            for(int i=0; i < amountOfNodes; i++){
                if(!S.contains(i)){

                    // Reduser inngraden til naboen med 1.
                    if(nabo[node][i]) listeInngrad[i]--;

                    // Hvis denne naboen nå har fått inngrad lik 0, legg den til i mengden S.
                    if(listeInngrad[i] == 0) S.add(i);
                }
            }


        }


        //
        //  4) Algoritmen er ferdig, hele den topologiske sorteringen er skrevet ut.
        //

        for(int node : S) System.out.print(data[node] + ", ");

















    }

    // main(); Testprogram
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("File? ");
        String filNavn = scan.next();

        new TopSort(filNavn).findAndPrint();

    }
}
