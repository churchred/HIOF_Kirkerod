package no.hiof.kristoffer.oblig5;

import no.hiof.kristoffer.oblig5.model.TVSeries;
import no.hiof.kristoffer.oblig5.repository.TVSeriesJSONRepository;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class JSONMain {
    public static void main(String[] args) {
        TVSeries breakingBad = new TVSeries("Breaking Bad", "Drug manufacturer/dealer adventures",
                LocalDate.of(2008, 1, 20));

        TVSeries daysOfOurLives = new TVSeries("Days of our Lives", "Long running series",
                LocalDate.of(1965, 11, 8));

        ArrayList<TVSeries> listOfTVSeries = new ArrayList<>();
        listOfTVSeries.add(breakingBad);
        listOfTVSeries.add(daysOfOurLives);

        System.out.println("\n---JSON---");
        TVSeriesJSONRepository jsonRepository = new TVSeriesJSONRepository(new File("tvseries.json"));

        jsonRepository.addListOfTVSeries(listOfTVSeries);
        ArrayList<TVSeries> tvSeriesListFromJSON = jsonRepository.getAllTVSeries();
        for (TVSeries tvSeriesX : tvSeriesListFromJSON) {
            System.out.println(tvSeriesX + "\n");
        }

        System.out.println("\n---Get Breaking Bad from JSON---");
        TVSeries tvSeriesFromJSON = jsonRepository.getTVSeries("Breaking Bad");
        System.out.println(tvSeriesFromJSON);

    }
}
