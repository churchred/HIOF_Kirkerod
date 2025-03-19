package no.hiof.kristoffer.oblig5.model;

import java.time.LocalDate;


public class Episode extends Production{

    private int episodeNumber;
    private int seasonNumber;

    public Episode(String title, int episodeNumber, int seasonNumber, String description, int runtimeInMinutes,
                   LocalDate releaseDate) {
        super(title, description, runtimeInMinutes, releaseDate);
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
    }

    public Episode(String title, int episodeNumber, int seasonNumber) {
        super(title);
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
    }

    @Override
    public String toString() {
        return "Episode title: " + getTitle() +
                "\nEpisode number: " + episodeNumber +
                "\nSeason number: " + seasonNumber +
                "\nRuntime in minutes: " + getRuntimeInMinutes();
    }


    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }


}
