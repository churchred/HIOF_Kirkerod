

package no.hiof.kristoffer.olbig2;


// Oppgave 2.1 - Modellklasser
// Vi skal kunne opprette TV-serier med tilhørende data.
// Vi trenger derfor noen klasser for å representere dette.
//
// Lag derfor 2 klasser med instansvariabler:
//      Episode
//          title - Episodens tittel
//          episodeNumber - Episodens nummer i sesongen
//          seasonNumber - Nummeret på sesongen episoden er fra
//          runtime - Episodens spilletid i minutter
//      TVSeries
//          title - TV-seriens tittel
//          description - En beskrivelse av TV-serien
//          releaseDate - TV-seriens utgivelsesdato
//          episodes (spoiler: bruk ArrayList<Episode>)

// Vi ønsker to konstruktører for å kunne opprette en Episode,
// en med alle instansevariablene, og en med alle unntatt spilletid (overloading).

// En episode skal kunne legges til enkeltvis via en metode addEpisode(Episode episode) i TVSeries-klassen.
// Husk å gjøre instansvariablene private, og lag get- og set-metoder for disse (innkapsling).


import no.hiof.kristoffer.olbig2.model.Episode;
import no.hiof.kristoffer.olbig2.model.TVSeries;

public class Main {
    public static void main(String[] args) {


        // Oppgave 2.2 - Opprette objekter
        //      Lag en kjørbar klasse kalt Main.java som skal benytte klassene du akkurat laget.
        //      Opprett et objekt av TVSeries-klassen for en TV-serie du selv ønsker.
        //      Opprett og legg til noen Episode-objekter til denne TV-serien.

        TVSeries series1 = new TVSeries(
                "Leverage",
                "A group of thieves steal from criminals to help regular people",
                "12.01.12");

        series1.addEpisodes(new Episode("The first job", 1, 1));
        series1.addEpisodes(new Episode("The second job", 2, 1));
        series1.addEpisodes(new Episode("The third job", 3, 1));
    }
}