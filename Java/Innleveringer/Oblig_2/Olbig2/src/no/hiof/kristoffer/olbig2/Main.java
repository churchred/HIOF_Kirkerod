

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

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


        // Oppgave 2.2 - Opprette objekter
        //      Lag en kjørbar klasse kalt Main.java som skal benytte klassene du akkurat laget.
        //      Opprett et objekt av TVSeries-klassen for en TV-serie du selv ønsker.
        //      Opprett og legg til noen Episode-objekter til denne TV-serien.


        // Oppgave 2.2 - Opprette objekter
        // Opprett et objekt av TVSeries-klassen for en TV-serie du selv ønsker.

        TVSeries series1 = new TVSeries(
                "Leverage",
                "A group of thieves steal from criminals to help regular people",
                "12.01.12");

        // Opprett og legg til noen Episode-objekter til denne TV-serien.
        //  series1.addEpisodes(new Episode("The first job", 1, 1, 30));
        // series1.addEpisodes(new Episode("The second job", 2, 1, 30));
        // series1.addEpisodes(new Episode("The third job", 3, 1, 30));


        // Oppgave 2.3 - Utskrift og toString()
        // Print toString for episoder
        //System.out.println(series1.getEpisodes().toString());

        // Print toString for series
        //System.out.println(series1.toString());


        // Oppgave 2.4 - Hente episoder i sesong
        // Lag en metode i TVSeries som henter ut alle episodene i en sesong
        // Loop som lager 5 sesonger med 10 episode i hver sesong
        // Oppgave 2.6 - Generere tilfeldig spilletid
        int maxSeasons = 5;
        int maxEpisodes = 10;
        Random randomNumber = new Random();
        for(int season = 1; season<maxSeasons+1; season++){
            for(int episode = 1; episode<maxEpisodes+1; episode++){
                series1.addEpisodes(new Episode("S" + season + "E" + episode, episode, season, randomNumber.nextInt(31-20) + 20));
            }
        }

        // Hent alle episoder i sesong 4 og skriv deretter ut navnet på hver episode i sesongen til konsollen.
        ArrayList<Episode> episodesInSeasonFour = series1.getEpisodesInSeason(4);
        for(Episode episode : episodesInSeasonFour){
            System.out.println(episode.getTitle());
        }

        // Hent så ut averageRunTime og skriv den ut til terminalen.
        System.out.println(series1.getAverageRunTime());

        // Oppgave 2.8 - "Teste" antall sesonger
        series1.addEpisodes(new Episode("test", 1, 10, 30));
        series1.addEpisodes(new Episode("test", 1, 6, 30));

    }
}