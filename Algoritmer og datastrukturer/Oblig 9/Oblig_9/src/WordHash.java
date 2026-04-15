import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;

// WordBST: BinÃ¦rt sÃ¸ketre med ord og ordfrekvenser
public class WordHash
{

    // Edit: Erstatt variablene rot og n  med et HashMap som kan lagre strenger og heltall
    HashMap<String, Integer> H = new HashMap<String, Integer>();

    // Edit: Skriv også om konstruktøren og metoden size().
    public int size()
    {
        return H.size();
    }

    // Edit: Skriv om metodene insert() og search()
    public void insert(String ord)
    {
        // Sjekker om den finnes fra før eller ikke før vi legger til nytt ord i listen
        if(H.containsKey(ord) == false){
            H.put(ord, 1);
        }
        else{
            // Hvis den finnes så øker vi antallet med 1
            H.put(ord, H.get(ord)+1);
        }
    }

    // Edit: Skriv om metodene insert() og search()
    public void search(String ord)
    {
        // Sjekker om den finnes fra før eller ikke før vi printer den
        if(H.containsKey(ord) == true){
            System.out.println(ord + ": " + H.get(ord));
        }
    }

    // Edit: Skriv også om metoden print(), slik at den skriver ut alle verdiene i hashtabellen.
    public void print()
    {

        // Først lager jeg en ny liste til å holde på alle key verdier i Mappet
        ArrayList <String> listOfKeys = new ArrayList<>(H.keySet());

        // Sorterer så listen alfabetsik baesrt på keys(ord)
        Collections.sort(listOfKeys);

        // Så printer vi dem ut i rekkefølge, vi må også bruke GET på
        // det orginale mappet for å hente ut verdien til keyen
        for (String key : listOfKeys) {
            System.out.println(key + ": " + H.get(key));
        }
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
        WordHash wBST = new WordHash();

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
