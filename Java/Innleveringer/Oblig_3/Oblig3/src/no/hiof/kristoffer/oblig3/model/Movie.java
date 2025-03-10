package no.hiof.kristoffer.oblig3.model;

import java.time.LocalDate;

public class Movie extends Production{

    public Movie(String title, int runTime, String description, LocalDate releaseDate){
        super(title, runTime, releaseDate, description);
    }

}
