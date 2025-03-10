package no.hiof.prog2.oblig.model;

import java.time.LocalDate;

/*
Oppgave 2.2
 */
public class Movie extends Production{


    public Movie(String title) {
        super(title);
    }

    public Movie(String title, String description, int runtimeInMinutes, LocalDate releaseDate) {
        super(title, description, runtimeInMinutes, releaseDate);
    }


}
