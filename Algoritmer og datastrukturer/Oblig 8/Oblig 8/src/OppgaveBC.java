import java.util.Queue;
import java.util.LinkedList;
import java.io.*;

public class OppgaveBC
{

    static class Node
    {
        int verdi;    // Heltallsverdi
        Node venstre; // Venstre barn
        Node høyre;   // Høyre barn

        // Konstruktør
        public Node(int data, Node v, Node h)
        {
            verdi = data;
            venstre = v;
            høyre = h;
        }
    }

    // Oppgave B
    public static void reparer(Node rot)
    {
        // Holde styr på hvor vi er i treet
        Node current = rot;

        while (true){

            // Holde styr på den minste verdien vi har funnet
            Node minste = current;

            // Sjekker til venstre og høyre, og ser om vi finner en mindre verdi
            // Måtte legge til en "!= null" sjekk også, fordi den krasjet når den kom til
            // null verdier(bunn av grenene)
            if(current.venstre != null && current.venstre.verdi < minste.verdi) minste = current.venstre;
            if(current.høyre != null && current.høyre.verdi < minste.verdi) minste = current.høyre;

            // Hvis den vi har nå fortsatt er minst, så ligger den riktig
            if (minste.verdi == current.verdi) break;

            // Hvis ikke, så må vi bytte litt
            int temp_value = current.verdi;
            current.verdi = minste.verdi;
            minste.verdi = temp_value;

            // Så går vi til neste gren
            current = minste;
        }

    }

    // Oppgave C
    public static void lagHeapOrdning(Node rot)
    {
        if (rot.venstre != null) lagHeapOrdning(rot.venstre);
        if (rot.høyre != null) lagHeapOrdning(rot.høyre);
        reparer(rot);
    }

    // Nivå for nivå utskrift, for testing
    public static void print(Node rot)
    {
        if (rot == null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        int n_nivå = 1, n_print = 0, n_neste = 0;
        q.add(rot);
        while (!q.isEmpty())
        {
            Node denne = q.remove();
            if (denne.venstre != null)
            {
                q.add(denne.venstre);
                n_neste++;
            }
            if (denne.høyre != null)
            {
                q.add(denne.høyre);
                n_neste++;
            }
            System.out.print(denne.verdi + " ");
            // Triks for å skrive ut hvert nivå på en egen linje
            if (++n_print == n_nivå)
            {
                System.out.println();
                n_print = 0;
                n_nivå = n_neste;
                n_neste = 0;
            }
        }
        if (n_print != 0)
            System.out.println();
        System.out.println();
    }

    // Testprogram
    public static void main(String argv[])
    {
        // Lager og og skriver ut treet i figur 3 i oppgaveteksten:
        Node rot = new Node(36,
                new Node(19,
                        new Node(17,
                                new Node(25, null, null),
                                new Node(2, null, null)),
                        new Node(7, null, null)),
                new Node(25,
                        new Node(1, null, null),
                        new Node(3, null, null)));


        // Sammenligner treet før og etter sortering
        print(rot);
        lagHeapOrdning(rot);
        print(rot);
    }
}