package no.hiof.kristoffer.oblig5;

import no.hiof.kristoffer.oblig5.model.TVSeries;
import no.hiof.kristoffer.oblig5.repository.TVSeriesCSVRepository;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class CSVMain {
    public static void main(String[] args) {
        TVSeries breakingBad = new TVSeries("Breaking Bad", "Drug manufacturer/dealer adventures",
                LocalDate.of(2008, 1, 20));

        TVSeries daysOfOurLives = new TVSeries("Days of our Lives", "Long running series",
                LocalDate.of(1965, 11, 8));

        ArrayList<TVSeries> listOfTVSeries = new ArrayList<>();
        listOfTVSeries.add(breakingBad);
        listOfTVSeries.add(daysOfOurLives);

        TVSeriesCSVRepository csvRepository = new TVSeriesCSVRepository(new File("tvseries.csv"));

        csvRepository.addListOfTVSeries(listOfTVSeries);

        ArrayList<TVSeries> tvSeriesListFromCSV = csvRepository.getAllTVSeries();
        for (TVSeries tvSeriesX : tvSeriesListFromCSV) {
            System.out.println(tvSeriesX + "\n");
        }

        System.out.println("\n---Get Breaking Bad---");
        TVSeries fetchedBreakingBad = csvRepository.getTVSeries("Breaking Bad");
        System.out.println(fetchedBreakingBad);
    }
}
