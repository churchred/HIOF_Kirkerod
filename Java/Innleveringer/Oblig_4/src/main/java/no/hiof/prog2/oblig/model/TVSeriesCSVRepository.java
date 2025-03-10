package no.hiof.prog2.oblig.model;


// Opprett en ny klasse TVSeriesCSVRepository.
// Denne skal kunne bli benyttet for å lese og lagre TVSeries-objekter med CSV-filer.
// Sett klassen til å implementere interfacet TVSeriesRepository
// og sørg for at alle metodene fra interfacet blir Overridet (ikke tenk på implementasjon helt enda).


import java.util.ArrayList;

public class TVSeriesCSVRepository implements TVSeriesRepository{

    // Skal ta imot en ArrayList med TVSeries-objekter og lagre disse
    @Override
    public void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries){
        System.out.println("N/A");
    };

    // Skal returnere en ArrayList med alle lagrede TVSeries-objekter
    @Override
    public ArrayList<TVSeries> getAllTVSeries(){
        return
    };

    // Skal returnere et TVSeries-objekt basert på den spesifiserte tittelen.
    @Override
    public TVSeries getTVSeriesByTitle(String title){
        return
    };

    // Klasse kalt CSVMain med en main-metode.
    // Vi vil oppdatere denne som vi implementerer logikken for metodene.
    public static void CSVMain(String[] args) {

    };

}
