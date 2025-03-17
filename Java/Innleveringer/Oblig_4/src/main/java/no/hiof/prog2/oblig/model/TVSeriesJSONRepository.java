package no.hiof.prog2.oblig.model;


// Opprett en ny klasse TVSeriesCSVRepository.
// Denne skal kunne bli benyttet for å lese og lagre TVSeries-objekter med CSV-filer.
// Sett klassen til å implementere interfacet TVSeriesRepository
// og sørg for at alle metodene fra interfacet blir Overridet (ikke tenk på implementasjon helt enda).


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TVSeriesJSONRepository implements TVSeriesRepository{

    private File file;

    public TVSeriesJSONRepository(File file){
        this.file = file;
    }

    // Skal ta imot en ArrayList med TVSeries-objekter og lagre disse
    @Override
    public void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries){

        ObjectMapper objectMapper = new ObjectMapper();

        // Learn what time is!
        objectMapper.registerModule(new JavaTimeModule());

        try{
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, listOfTVSeries);
        }
        catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

    };

    // Skal returnere en ArrayList med alle lagrede TVSeries-objekter
    @Override
    public ArrayList<TVSeries> getAllTVSeries(){

        ObjectMapper objectMapper = new ObjectMapper();

        // Register the JavaTimeModule to handle Java 8 Date/Time types like LocalDate
        objectMapper.registerModule(new JavaTimeModule());

        try {
            TVSeries[] listOfSeries = objectMapper.readValue(file, TVSeries[].class);
            return new ArrayList<>(Arrays.asList(listOfSeries));
        }
        catch (IOException exception){
            System.err.println(exception);
        }

        return new ArrayList<>();

    };

    // Skal returnere et TVSeries-objekt basert på den spesifiserte tittelen.
    @Override
    public TVSeries getTVSeriesByTitle(String title){
        ArrayList<TVSeries> listOfSeries = getAllTVSeries();

        for (TVSeries series : listOfSeries){
            if(series.getTitle().equals(title)){
                return series;
            }
        }

        return null;
    };

    // Klasse kalt CSVMain med en main-metode.
    // Vi vil oppdatere denne som vi implementerer logikken for metodene.
    public static void CSVMain(String[] args) {

    };

}
