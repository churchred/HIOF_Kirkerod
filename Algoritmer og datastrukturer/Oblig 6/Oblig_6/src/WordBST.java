import java.io.*;
import java.util.Scanner;


// WordBST: BinÃ¦rt sÃ¸ketre med ord og ordfrekvenser
public class WordBST
{
    // WordNode: Indre klasse for en node i sÃ¸ketreet
    class WordNode
    {
        /*** Skal programmeres i oppgave 1 ***/
        String ord;
        WordNode venstre, hoyre;
        int antall;
        WordNode forelder;

        public WordNode(String ord, WordNode venstre, WordNode hoyre)
        {
            this.ord = ord;
            this.venstre = venstre; this.hoyre = hoyre;
            antall = 0;
            forelder = null;
        }

        public void print(){
            System.out.println("Ord: " + this.ord + "   -   Antall forekomster: " + this.antall);
        }

    }

    private WordNode rot; // Roten i hele sÃ¸ketreet
    private int n;        // Antall noder i hele treet

    // WordBST(): KonstruktÃ¸r som lager et tomt sÃ¸ketre
    public void WordBST()
    {
        rot = null;
        n = 0;
    }

    // size(): Antall ord som er lagret i treet
    public int size()
    {
        return n;
    }

    // insert(): Setter inn ny forekomst av et ord
    public void insert(String ord)
    {
        /*** Skal programmeres i oppgave 2 ***/
        WordNode newNode = new WordNode(ord, null, null);

        // Sjekker om treet er tomt
        //
        if (rot == null) {
            rot = newNode;
            n++;
            return;
        }

        // Vi begynner på toppen
        WordNode current = rot;
        WordNode parent = null; // For å holde styr på sist viable blad i treet. Gir oss enklere innsettning etterpå.

        // Sjekker om ordet finnes fra før OG finner ny plass til den.
        //
        while(current != null){
            // Compare gir oss en negativ hvis lavere, positiv hvis høyre og en null hvis match (ALfabetisk)
            parent = current; // Siste besøkte node
            int compared = ord.compareTo(current.ord);

            // Hvis den finnes fra før:
            if(compared == 0) {current.antall++; return;}

            // Hvis den er lavere i alfabetet så går vi videre nedover mot VENSTRE i treet
            else if(compared < 0) current = current.venstre;

            // Hvis ikke så leter vi videre ned mot HØYRE i treet
            else current = current.hoyre;
        }

        // Så plasserer vi inn bladet i treet der den hører hjemme
        //
        newNode.antall = 1;
        if (ord.compareTo(parent.ord) < 0)
            parent.venstre = newNode;
        else
            parent.hoyre = newNode;

        // Og øker størrelsen på treet med 1
        n++;

    }

    // search(): SÃ¸k etter et ord. Skriv ut ordet og ordfrekvensen
    // hvis det finnes i sÃ¸ketreet.
    public void search(String ord)
    {
        /*** Skal programmeres i oppgave 3 ***/

        WordNode current = rot;

        while(current != null){
            // Compare gir oss en negativ hvis lavere, positiv hvis høyre og en null hvis match (ALfabetisk)
            int compared = ord.compareTo(current.ord);

            // Hvis den finnes fra før:
            if(compared == 0) {
                System.out.println(ord + ": " + current.antall);
                break;
            }

            // Hvis den er lavere i alfabetet så går vi videre nedover mot VENSTRE i treet
            else if(compared < 0) current = current.venstre;

            // Hvis ikke så leter vi videre ned mot HØYRE i treet
            else current = current.hoyre;
        }
    }

    // print(): Alfabetisk utskrift av hele sÃ¸ketreet. Kaller en
    // rekursiv metode som gjÃ¸r selve utskriften.
    public void print()
    {
        print(rot);
    }

    // print(): Rekursiv utskrift av hele sÃ¸ketreet med rot i "rot"
    private void print(WordNode rot)
    {
        /*** Skal programmeres i oppgave 4 ***/

        // Hvis er på bunn i grenen
        if (rot == null) return;

        // Først venstre grener
        print(rot.venstre);

        // Så selve noden
        System.out.println(rot.ord + ": " + rot.antall);

        // Til slutt høyre grener
        print(rot.hoyre);

    }

    // main(): Testprogram
    public static void main (String argv[])
    {
        // Leser filnavn fra bruker
        Scanner scan = new Scanner(System.in);
        System.out.print("File? ");
        String fileName = scan.next();

        // Oppretter ordleser og tomt sÃ¸ketre
        WordReader wR = new WordReader(fileName);
        WordBST wBST = new WordBST();

        // Leser alle ordene pÃ¥ filen og legger inn i treet
        String ord = wR.nextWord();
        while (ord != null)
        {
            wBST.insert(ord);
            ord = wR.nextWord();
        }
        // Skriver ut antall ulike ord som fantes i filen
        System.out.println(wBST.size() + " unique words " +
                "read from file " + fileName);

        // Menyvalg for Ã¥ teste programmet
        int valg = 0;
        while(valg != 3)
        {
            System.out.print("\n1:Search, 2:Print, 3:Quit ? ");
            valg = scan.nextInt();
            if (valg == 1)
            {
                System.out.print("Search for? ");
                ord = scan.next();
                wBST.search(ord.toLowerCase());
            }
            else if (valg == 2)
                wBST.print();
        }
    }
}
