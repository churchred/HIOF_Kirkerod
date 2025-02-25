package no.hiof.kristoffer.oblig3.model;

import java.util.ArrayList;

public class TVSeries {

    private String title;
    private String description;
    private String releaseDate;
    private ArrayList<Episode> episodes = new ArrayList<>();
    private double averageRunTime;
    private int numSeasons;

    // Konstruktør
    public TVSeries(String title, String description, String releaseDate) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    // Override toString()
    @Override
    public String toString() {
        return "TV series Title: " + title +
                "\nDescription: " + description +
                "\nRelease date: " + releaseDate +
                "\nNumber of episodes: " + episodes.size();
    }

    // Setter-metoder
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    // Henter alle roller fra alle episoder
    public ArrayList<Role> hentRollebesetning() {
        ArrayList<Role> rollebesetning = new ArrayList<>();

        for (Episode episode : episodes) {
            rollebesetning.addAll(episode.getRoleList());
        }
        return rollebesetning;
    }

    // Legger til episoder og oppdaterer antall sesonger
    public void addEpisodes(Episode episode) {
        if (episode.getSeasonNumber() > numSeasons + 1) {
            System.out.println("Error, cannot add episode as Season is too high");
        } else {
            if (episode.getSeasonNumber() == numSeasons + 1) {
                numSeasons++;
            }
            episodes.add(episode);
            updateAverageRunTime();
        }
    }

    // Henter episoder i en spesifikk sesong
    public ArrayList<Episode> getEpisodesInSeason(int season) {
        ArrayList<Episode> episodesInSpesificSeason = new ArrayList<>();

        for (Episode episode : episodes) {
            if (episode.getSeasonNumber() == season) {
                episodesInSpesificSeason.add(episode);
            }
        }
        return episodesInSpesificSeason;
    }

    // Oppdaterer gjennomsnittlig spilletid
    private void updateAverageRunTime() {
        int totalTime = 0;

        for (Episode episode : episodes) {
            totalTime += episode.getRunTime();
        }
        averageRunTime = (double) totalTime / episodes.size();
    }

    // Getter-metoder
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public ArrayList<Episode> getEpisodes() {
        return new ArrayList<>(episodes);
    }

    public int getNumSeasons() {
        return numSeasons;
    }

    public double getAverageRunTime() {
        return averageRunTime;
    }
}
