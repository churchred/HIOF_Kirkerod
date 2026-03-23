import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

// WordBST: BinÃ¦rt sÃ¸ketre med ord og ordfrekvenser
public class WordBST
{

    // Erstatt variablene rot og n med et TreeMap
    private TreeMap<String, Integer> T;

    // WordBST(): KonstruktÃ¸r som lager et tomt sÃ¸ketre
    public WordBST()
    {
        T = new TreeMap<>();
    }

    // size(): Antall ord som er lagret i treet
    public int size()
    {
        return T.size();
    }

    // insert(): Setter inn ny forekomst av et ord
    public void insert(String ord)
    {
        // Først nå vi sjekke om den finnes fra før.
        // Hvis den finnes øker vi antall forekomster med 1, og
        // hvis ikke så legger vi den til.
        if (T.containsKey(ord)){
            T.replace(ord, T.get(ord)+1); // Øker forekomster for ordet med 1
        } else{
            T.put(ord, 1); // Den fantes ikke fra før, så vi legger den til
        }

    }

    // search(): SÃ¸k etter et ord. Skriv ut ordet og ordfrekvensen
    // hvis det finnes i sÃ¸ketreet.
    public void search(String ord)
    {
        // Hvis den finnes i treet, print ut antall forekomster vi har funnet
        if(T.containsKey(ord)){
            System.out.println(ord + ": " + T.get(ord));
        }
    }

    // print(): Alfabetisk utskrift av hele sÃ¸ketreet. Kaller en
    // rekursiv metode som gjÃ¸r selve utskriften.
    public void print()
    {
        for (String key : T.keySet())
            System.out.println(key + ": " + T.get(key));
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
