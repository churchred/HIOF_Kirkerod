package no.hiof.kristoffer.oblig5.repository;


import no.hiof.kristoffer.oblig5.model.Episode;
import no.hiof.kristoffer.oblig5.model.TVSeries;

import java.time.LocalDate;
import java.util.ArrayList;

// Opprett en klasse TVSeriesDataRepository.
public class TVSeriesDataRepository implements TVSeriesRepository{

    //   Lag en instansvariabel kalt allTvSeries som holder på en liste med TVSeries-objekter.
    private ArrayList<TVSeries> allTvSeries = new ArrayList<>();

    //   Lag en konstruktør som fyller listen med minst en
    //   TV-serie med noen inneholdte episoder.
    public TVSeriesDataRepository() {

        // Lage noen TV-Serier
        TVSeries karlOgCo = new TVSeries(
                "Karl & Co",
                "Karl gjør ting med Co",
                LocalDate.of(2000, 12, 7));

        TVSeries motIBrystet = new TVSeries(
                "Mot i Bryste",
                "Karl gjør ting Nils",
                LocalDate.of(2000, 12, 7));

        TVSeries hosMartin = new TVSeries(
                "Hos Martin",
                "Martin eier en resturant",
                LocalDate.of(2000, 12, 7));

        // Episoder til hver serie:
        Episode a_ep_1 = new Episode("An episode", 1, 1);
        Episode a_ep_2 = new Episode("Another episode", 2, 1);
        Episode a_ep_3 = new Episode("Last episode", 3, 1);
        karlOgCo.addEpisode(a_ep_1);
        karlOgCo.addEpisode(a_ep_2);
        karlOgCo.addEpisode(a_ep_3);

        Episode b_ep_1 = new Episode("An episode", 1, 1);
        Episode b_ep_2 = new Episode("Another episode", 2, 1);
        Episode b_ep_3 = new Episode("Last episode", 3, 1);
        motIBrystet.addEpisode(b_ep_1);
        motIBrystet.addEpisode(b_ep_2);
        motIBrystet.addEpisode(b_ep_3);

        Episode c_ep_1 = new Episode("An episode", 1, 1);
        Episode c_ep_2 = new Episode("Another episode", 2, 1);
        Episode c_ep_3 = new Episode("Last episode", 3, 1);
        hosMartin.addEpisode(c_ep_1);
        hosMartin.addEpisode(c_ep_2);
        hosMartin.addEpisode(c_ep_3);

        allTvSeries.add(karlOgCo);
        allTvSeries.add(motIBrystet);
        allTvSeries.add(hosMartin);
    }
    @Override
    public ArrayList<TVSeries> getAllTVSeries(){
        return new ArrayList<>(allTvSeries);
    }

    @Override
    public TVSeries getTVSeries(String title){
        for (TVSeries tvSeries : allTvSeries){
            if(tvSeries.getTitle().equalsIgnoreCase(title)){
                return tvSeries;
            }
        }
        return null;
    }

    @Override
    public void addTVSeries(TVSeries series){
        allTvSeries.add(series);
    }

    @Override
    public void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries){
        System.out.println("Metode ikke i bruk");
    }


}
