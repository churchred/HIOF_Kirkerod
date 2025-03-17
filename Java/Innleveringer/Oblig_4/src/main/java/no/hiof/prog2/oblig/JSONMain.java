package no.hiof.prog2.oblig;

import no.hiof.prog2.oblig.model.TVSeries;
import no.hiof.prog2.oblig.model.TVSeriesCSVRepository;
import no.hiof.prog2.oblig.model.TVSeriesJSONRepository;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class JSONMain {
    public static void main(String[] args) {

        // Makes TV stuff
        TVSeries breakingBad = new TVSeries("Breaking Bad", "Drug manufacturer/dealer adventures",
                LocalDate.of(2008, 1, 20));

        TVSeries arcane = new TVSeries("Arcane", "LoL the series",
                LocalDate.of(2018, 10, 23));

        ArrayList<TVSeries> list = new ArrayList<>();
        list.add(breakingBad);
        list.add(arcane);

        // Make file stuff
        File file = new File("tvseries.json");

        // Make rep stuff
        TVSeriesJSONRepository TV = new TVSeriesJSONRepository(file);

        // Skriv denne listen til fil ved hjelp av addListOfTVSeries().
        TV.addListOfTVSeries(list);

        // Skriv logikken for getAllTVSeries() test bruk av den implementerte metoden i JSONMain.

        for (TVSeries series : TV.getAllTVSeries()){
            System.out.println(series.getDescription());
        }

        System.out.println(TV.getTVSeriesByTitle("Arcane").getTitle());
        System.out.println(TV.getTVSeriesByTitle("SImpsons"));
    }
}
