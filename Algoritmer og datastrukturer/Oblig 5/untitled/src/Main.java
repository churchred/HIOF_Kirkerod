import java.util.Queue;
import java.util.LinkedList;

public class Main {

    // Oppgave 1
    static void settSum(Trenode rot) {

        // Hvis ikke finnes flere grener
        if (rot == null) return;

        // Går et hakk nedover i grenen og gjør at dette der også
        settSum(rot.venstre);
        settSum(rot.hoyre);

        // Henter verdier for grenene under, hvis det finnes noe der
        // og sjekker for ikke eksisterende grener
        int venstreSum = 0;
        if (rot.venstre != null) venstreSum = rot.venstre.sum;

        int hoyreSum = 0;
        if (rot.hoyre != null) hoyreSum = rot.hoyre.sum;

        // Legger alt sammen i denne noden
        rot.sum = venstreSum + hoyreSum + rot.verdi;

        // En sjekk for å se om jeg gjorde riktig:
        System.out.println(rot.sum);
    }


    // Oppgave 2
    static void settForelder(Trenode rot) {

        // Gjør om verdien for venstre siden hvis den finnes, og gjør en ny sjekk på dens nye grener
        if (rot.venstre != null){
            rot.venstre.forelder = rot;
            settForelder(rot.venstre);

        }

        // Gjør om verdien for høyre  siden hvis den finnes, og gjør en ny sjekk på dens nye grener
        if (rot.hoyre != null) {
            rot.hoyre.forelder = rot;
            settForelder(rot.hoyre);
        }

        // En sjekk for å se om jeg gjorde riktig:
        if (rot.forelder != null) System.out.println("Node value: " + rot.verdi + ", Parent value: " + rot.forelder.verdi);

    }

    // Oppgave 3
    static void skrivUt(Trenode rot) {

        // Lager en Queue
        Queue<Trenode> queue = new LinkedList<>();
        queue.add(rot);

        System.out.println("Verdi   Sum   Forelder");

        while (!queue.isEmpty()) {
            // Henter øverste element i Kø-en
            Trenode current = queue.poll();

            // Legger til de neste grenene i kø-en
            if(current.venstre != null) queue.add(current.venstre);
            if(current.hoyre != null) queue.add(current.hoyre);

            // Printer ut verdiene til denne noden
            System.out.println(current.verdi + "\t\t" + current.sum + "\t\t" +
                    (current.forelder != null ? current.forelder.verdi : "*"));
        }

    }

    // Testprogram
    public static void main(String args[]) {
        Trenode rot =
                new Trenode(8,
                        new Trenode(4,
                                new Trenode(2, null, null),
                                new Trenode(6, null, null)),
                        new Trenode(16,
                                new Trenode(14,
                                        new Trenode(12, null, null),
                                        new Trenode(15, null, null)),
                                new Trenode(18, null,
                                        new Trenode(20, null, null))));

        // Oppgave 1
        System.out.println("\n\nOppgave 1:");
        settSum(rot);


        // Oppgave 2
        System.out.println("\n\nOppgave 2:");
        settForelder(rot);

        // Oppgave 3
        System.out.println("\n\nOppgave 3:");
        skrivUt(rot);
    }
}


class Trenode
{
    int verdi;
    Trenode venstre, hoyre;
    int sum;
    Trenode forelder;

    public Trenode(int verdi, Trenode venstre, Trenode hoyre)
    {
        this.verdi = verdi;
        this.venstre = venstre; this.hoyre = hoyre;
        sum = 0;
        forelder = null;
    }
}