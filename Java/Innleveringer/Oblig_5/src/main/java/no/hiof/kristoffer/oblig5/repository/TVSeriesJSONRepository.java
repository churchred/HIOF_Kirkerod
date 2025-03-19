package no.hiof.kristoffer.oblig5.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.hiof.kristoffer.oblig5.model.TVSeries;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TVSeriesJSONRepository implements TVSeriesRepository{

    private final File file;
    private static ObjectMapper objectMapper;

    public TVSeriesJSONRepository(File file) {
        this.file = file;
        /*
        Kan potensielt sløyfes
         */
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        objectMapper = new ObjectMapper();
        //objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
    }

    @Override
    public void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, listOfTVSeries);
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<TVSeries> getAllTVSeries() {
        try {
            TVSeries[] tvSeriesArray = objectMapper.readValue(file, TVSeries[].class);
            return new ArrayList<>(Arrays.asList(tvSeriesArray));
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public TVSeries getTVSeries(String title) {

        ArrayList<TVSeries> allTVSeries = getAllTVSeries();
        for (TVSeries tvSeriesX : allTVSeries) {
            if(tvSeriesX.getTitle().equals(title)) {
                return tvSeriesX;
            }
        }

        return null;
    }

    @Override
    public void addTVSeries(TVSeries series){

    }


}
