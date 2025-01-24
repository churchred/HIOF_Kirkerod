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

    public void Main(String title, int epNr, int SeaNr, int runTime){
        this.title = title;
        this.episodeNumber = epNr;
        this.seasonNumber = SeaNr;
        this.runTime = runTime;
    }

    public String getTitle() {
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

    public void setTitle(String title) {
        this.title = title;
    }




}
