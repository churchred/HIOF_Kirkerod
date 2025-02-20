package no.hiof.kristoffer.oblig3.model;

import java.time.LocalDate;

public class Episode extends Production {

    private int episodeNumber;
    private int seasonNumber;

    // Konstruktører
    public Episode(String title, int episodeNumber, int seasonNumber,
                   String description, LocalDate releaseDate, int runTime) {
        super(title, runTime, releaseDate, description);
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
    }

    public Episode(String title, int episodeNumber, int seasonNumber,
                   String description, LocalDate releaseDate) {
        super(title, releaseDate, description);
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
    }

    // Override toString()
    @Override
    public String toString() {
        return "\nEpisode number: " + episodeNumber +
                "\nSeason number: " + seasonNumber +
                "\nEpisode title: " + getTitle() +
                "\nRun Time in minutes: " + getRunTime() +
                "\nRelease date: " + getReleaseDate() +
                "\nDescription: " + getDescription() +
                "\nDirector: " + (getDirector() != null ? getDirector().getFullName() : "Not assigned") +
                "\nList of Roles: " + getRoleList();
    }

    // Setter-metoder
    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    // Getter-metoder
    public int getSeasonNumber() {
        return seasonNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }
}
