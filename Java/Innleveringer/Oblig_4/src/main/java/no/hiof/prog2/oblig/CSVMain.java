package no.hiof.prog2.oblig;

import no.hiof.prog2.oblig.model.TVSeries;
import no.hiof.prog2.oblig.model.TVSeriesCSVRepository;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class CSVMain {

    public static void main(String[] args) {

        TVSeries breakingBad = new TVSeries("Breaking Bad", "Drug manufacturer/dealer adventures",
                LocalDate.of(2008, 1, 20));

        TVSeries arcane = new TVSeries("Arcane", "LoL the series",
                LocalDate.of(2018, 10, 23));

        ArrayList<TVSeries> list = new ArrayList<>();
        list.add(breakingBad);
        list.add(arcane);

        File file = new File("tvseries.csv");

        TVSeriesCSVRepository TV = new TVSeriesCSVRepository(file);

        TV.addListOfTVSeries(list);

        //  Skriv ut en beskrivelse av her av disse for å bekrefte at objektene innholder riktig informasjon.
        for (TVSeries series : TV.getAllTVSeries()){
            System.out.println(series.getDescription());
        }

        // Skriv ut en beskrivelse av dette objektet for å demonstrere at metoden fungerer.
        System.out.println(TV.getTVSeriesByTitle("Arcane").getDescription());
        System.out.println(TV.getTVSeriesByTitle("Superman"));

        // 

    }
}
