package no.hiof.kristoffer.oblig5.repository;

import no.hiof.kristoffer.oblig5.model.TVSeries;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TVSeriesCSVRepository implements TVSeriesRepository{

    private File file;

    public TVSeriesCSVRepository(File file) {
        this.file = file;

        /*
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write("title;description");
            bufferedWriter.newLine();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
         */
    }

    @Override
    public ArrayList<TVSeries> getAllTVSeries() {
        ArrayList<TVSeries> allTVSeries = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(";");

                String title = values[0];
                String description = values[1];
                int year = Integer.parseInt(values[2]);
                int month = Integer.parseInt(values[3]);
                int day = Integer.parseInt(values[4]);

                LocalDate releaseDate = LocalDate.of(year, month, day);

                allTVSeries.add(new TVSeries(title, description, releaseDate));
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("File could not be found: " + e.getMessage());
        }
        catch (IOException e) {
            System.err.println("Something went wrong when reading file: " + e.getMessage());
        }

        return allTVSeries;
    }

    /*
    Kan utelates hvis kompleksiteten blir for stor
     */
    @Override
    public TVSeries getTVSeries(String titleOfSeries) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(";");

                String title = values[0];

                if (title.equals(titleOfSeries)) {
                    String description = values[1];
                    int year = Integer.parseInt(values[2]);
                    int month = Integer.parseInt(values[3]);
                    int day = Integer.parseInt(values[4]);

                    LocalDate releaseDate = LocalDate.of(year, month, day);

                    return new TVSeries(title, description, releaseDate);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("File could not be found: " + e.getMessage());
        }
        catch (IOException e) {
            System.err.println("Something went wrong when reading file: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            for (TVSeries tvSeriesX : listOfTVSeries) {
                bufferedWriter.write(tvSeriesX.getTitle() + ";" + tvSeriesX.getDescription() + ";" +
                        tvSeriesX.getReleaseDate().getYear() + ";" +
                        tvSeriesX.getReleaseDate().getMonthValue() + ";" +
                        tvSeriesX.getReleaseDate().getDayOfMonth());
                bufferedWriter.newLine();
            }
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void addTVSeries(TVSeries series){

    }
}
