public class OppgaveA
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

    // tell(): Returnerer antall forekomster av "verdi" i det
    // heap-ordnede treet med rot i "rot".
    public static int tell(Node rot, int verdi)
    {

        // Holde styr på om vi har funnet en match her eller ikke
        int antall = 0;

        // Hvis vi er i bunn av en gren:
        if (rot == null) return 0;

        // Hvis vi finner verdien:
        if (rot.verdi == verdi) antall = 1;

        // Hvis verdien i grenen er høyre enn den vi leter etter
        // er det ikke vits i å fortsette nedover der:
        if (rot.verdi > verdi) return 0;

        // Leter videre nedover rekursivt:
        return antall + tell(rot.venstre, verdi) + tell(rot.høyre, verdi);
    }


    // main(): Testprogram
    public static void main(String argv[])
    {
        // Lager treet som er gitt i figur 1 i oppgaveteksten
        Node rot = new Node(1,
                new Node(2,
                        new Node(17,
                                new Node(25, null, null),
                                new Node(19, null, null)),
                        null),
                new Node(17, null,
                        new Node(36, null, null)));

        // Tester metoden tell() for noen verdier
        System.out.println("tell(2)  = " + tell(rot,2));
        System.out.println("tell(17) = " + tell(rot,17));
        System.out.println("tell(25) = " + tell(rot,25));
        System.out.println("tell(50) = " + tell(rot,50));
    }
}
