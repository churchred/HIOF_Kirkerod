package no.hiof.prog2.oblig.model;


// Opprett en ny klasse TVSeriesCSVRepository.
// Denne skal kunne bli benyttet for å lese og lagre TVSeries-objekter med CSV-filer.
// Sett klassen til å implementere interfacet TVSeriesRepository
// og sørg for at alle metodene fra interfacet blir Overridet (ikke tenk på implementasjon helt enda).


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TVSeriesCSVRepository implements TVSeriesRepository{

    private File file;

    public TVSeriesCSVRepository(File file){
        this.file = file;
    }

    // Skal ta imot en ArrayList med TVSeries-objekter og lagre disse
    @Override
    public void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){

            for (TVSeries series : listOfTVSeries){

                String tittel = series.getTitle();
                String beskrivelse = series.getDescription();
                int year = series.getReleaseDate().getYear();
                int month = series.getReleaseDate().getMonthValue();
                int day = series.getReleaseDate().getDayOfMonth();

                bufferedWriter.write(tittel + ", " + beskrivelse + ", " + year + ", " + month + ", " + day);
                bufferedWriter.newLine();

            }
        }
        catch(IOException exception){
            System.err.println(exception.getMessage());
        }
    };

    // Skal returnere en ArrayList med alle lagrede TVSeries-objekter
    @Override
    public ArrayList<TVSeries> getAllTVSeries(){
        ArrayList<TVSeries> listOfSeries = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){

            String line;
            while( (line = bufferedReader.readLine()) != null ) {

                String[] values = line.split(", ");
                String tittel = values[0];
                String beskrivelse = values[1];

                LocalDate date = LocalDate.of(
                        Integer.parseInt(values[2]),
                        Integer.parseInt(values[3]),
                        Integer.parseInt(values[4]));

                TVSeries series = new TVSeries(tittel, beskrivelse, date);
                listOfSeries.add(series);
            }

        }
        catch(IOException exception){
            System.err.println(exception.getMessage());
        }

        return listOfSeries;
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
