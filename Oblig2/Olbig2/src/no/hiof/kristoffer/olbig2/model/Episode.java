package no.hiof.kristoffer.olbig2.model;


//      Episode
//          title - Episodens tittel
//          episodeNumber - Episodens nummer i sesongen
//          seasonNumber - Nummeret på sesongen episoden er fra
//          runtime - Episodens spilletid i minutter


public class Episode {

    private String title;
    private int episodeNumber;
    private int seasonNumber;
    private int runTime;

    public Episode(String title, int episodeNumber, int seasonNumber, int runTime){
        this.title = title;
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
        this.runTime = runTime;
    }

    public Episode(String title, int episodeNumber, int seasonNumber){
        this.title = title;
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
    }

    @Override
    public String toString() {
        System.out.println();
    }

    // Set functions
    public void setTitle(String title) {
        this.title = title;
    }
    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }
    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    // Get functions
    public String getTitle(){
        return title;
    }
    public int getSeasonNumber() {
        return seasonNumber;
    }
    public int getEpisodeNumber() {
        return episodeNumber;
    }
    public int getRunTime() {
        return runTime;
    }






}
