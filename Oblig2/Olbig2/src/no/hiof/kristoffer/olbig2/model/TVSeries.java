package no.hiof.kristoffer.olbig2.model;

import com.sun.tools.javac.Main;

import java.util.ArrayList;

//      TVSeries
//          title - TV-seriens tittel
//          description - En beskrivelse av TV-serien
//          releaseDate - TV-seriens utgivelsesdato
//          episodes (spoiler: bruk ArrayList<Episode>)


public class TVSeries {

    private String title;
    private String description;
    private String releaseDate;
    private ArrayList<Episode> episodes = new ArrayList<Episode>();
    private double averageRunTime;
    private int numSeasons;


    public TVSeries(String title, String description, String releaseDate){
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString(){
        return(
                "TV series Title: " + title +
                        "\nDescription: " + description +
                        "\nRelease date: " + releaseDate +
                        "\nNumber of episodes: " + episodes.size());
    }


    // Set functions
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    public void addEpisodes(Episode episode) {
        // Oppgave 2.7 - Holde på antall sesonger
        if (episode.getSeasonNumber() > numSeasons+1){
            System.out.println("Error, cannot add episode as Season is too high");
        } else{
            if(episode.getSeasonNumber() == numSeasons+1){
                numSeasons += 1;
            }
            this.episodes.add(episode);
            updateAverageRunTime();
        }
    }


    // Get functions
    public String getReleaseDate() {
        return releaseDate;
    }
    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return title;
    }
    public ArrayList<Episode> getEpisodes() {
        return new ArrayList<>(episodes);
    }
    public int getNumSeasons(){
        return numSeasons;
    }

    // Get episodes in a season
    public ArrayList<Episode> getEpisodesInSeason(int season){

        // Lager ny liste vi skal returnere
        ArrayList<Episode> episodesInSpesificSeason = new ArrayList<>();

        for(Episode episode : episodes){
            if(episode.getSeasonNumber() == season){
                episodesInSpesificSeason.add(episode);
            }
        }

        return (episodesInSpesificSeason);
    }


    // Oppgave 2.5 - Gjennomsnittlig spilletid
    private void updateAverageRunTime(){
        int totalTime = 0;

        for(Episode episode : episodes){
            totalTime += episode.getRunTime();
        }

        averageRunTime = (double) totalTime / episodes.size();
    }

    public double getAverageRunTime(){
        return averageRunTime;
    }
}
