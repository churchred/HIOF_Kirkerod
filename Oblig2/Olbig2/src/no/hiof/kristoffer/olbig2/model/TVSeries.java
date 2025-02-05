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
        this.episodes.add(episode);
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
}
