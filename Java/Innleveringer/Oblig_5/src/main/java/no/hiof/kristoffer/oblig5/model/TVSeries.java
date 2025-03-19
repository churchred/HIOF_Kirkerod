package no.hiof.kristoffer.oblig5.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class TVSeries {

    private String title;
    private String description;
    private LocalDate releaseDate;
    private ArrayList<Episode> episodes = new ArrayList<>();

    private double averageRuntime;
    private int numSeasons = 0;

    public TVSeries() {

    }

    public TVSeries(String title, String description, LocalDate releaseDate) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    /*
    Oppgave 2.7
     */
    public ArrayList<Role> getCast() {
        ArrayList<Role> cast = new ArrayList<>();

        for (Episode episode : episodes) {
            cast.addAll(episode.getRoles()); // Uten håndtering av duplikater

            /*
            Oppgave 3.1 (Bonus) - Erstatt linjen over med dette
            for (Role role : episode.getRoles()) {
                if(!cast.contains(role)) {
                    cast.add(role);
                }
            }
             */
        }

        return cast;
    }

    public int numberOfEpisodesWithActor(Person actor) {
        int number = 0;

        for (Role role : getCast()) {
            if (role.getActor() == actor) {
                number++;
            }
        }

        return number;
    }


    public ArrayList<Episode> getEpisodesInSeason(int season) {
        ArrayList<Episode> episodesInSeason = new ArrayList<>();
        for (Episode episode : episodes) {
            if (episode.getSeasonNumber() == season) {
                episodesInSeason.add(episode);
            }
        }
        return episodesInSeason;
    }

    public void addEpisode(Episode episode) {
        int episodeSeasonNumber = episode.getSeasonNumber();

        if (episodeSeasonNumber != numSeasons && episodeSeasonNumber != numSeasons+1) {
            System.out.println("Can't add episode for season " + episode.getSeasonNumber() + " when only " +
                    numSeasons + " exists.");
        }
        else {
            episodes.add(episode);
            updateAverageRuntime(); 
        }

        if (episodeSeasonNumber == numSeasons+1) {
            numSeasons++;
        }

    }

    private void updateAverageRuntime() {
        int sumRunTime = 0;
        for (Episode episode : episodes) {
            sumRunTime += episode.getRuntimeInMinutes();
        }
        averageRuntime = (double) sumRunTime / episodes.size();
    }

    @Override
    public String toString() {
        return "TV series title: " + title +
                "\nDescription: " + description +
                "\nRelease date: " + releaseDate.toString() +
                "\nNumber of episodes: " + episodes.size();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getAverageRuntime() {
        return averageRuntime;
    }

    public ArrayList<Episode> getEpisodes() {
        return new ArrayList<>(episodes);
    }

    public int getNumSeasons() {
        return numSeasons;
    }
}
