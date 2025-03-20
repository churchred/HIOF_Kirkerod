package no.hiof.kristoffer.oblig5.model;
import io.javalin.http.Context;

import no.hiof.kristoffer.oblig5.repository.TVSeriesRepository;

import java.time.LocalDate;

public class TVSeriesController {

    private TVSeriesRepository repo;

    public TVSeriesController(TVSeriesRepository repo) {
        this.repo = repo;
    }

    public void getAllSeries(Context context){
        context.json(repo.getAllTVSeries());
    }

    public void getSeriesDetails(Context context){
        String seriesName = context.pathParam("tvseries-name");

        TVSeries fetchedSeries = repo.getTVSeries(seriesName);

        if (fetchedSeries != null) {
            context.json(fetchedSeries);
        }
        else {
            context.result("Could not find the SERIES " + seriesName);
        }
    }

    public void addTVSeries(Context context){
        // Hent ut verdiene og benytt dem til å opprette et nytt objekt av TVSeries
        String title = context.formParam("title");
        String description = context.formParam("description");
        LocalDate releaseDate = LocalDate.of(
                // Jeg antar her at brukere ikke kan gjøre feil, og alle er perfekte,
                // så ingen grunn til å legge til beskyttelse mot null verdier.
                Integer.parseInt(context.formParam("release-date-year")),
                Integer.parseInt(context.formParam("release-date-month")),
                Integer.parseInt(context.formParam("release-date-day"))
        );

        TVSeries series = new TVSeries(title, description, releaseDate);

        // Legg til i TVSeriesDataRepository-objektet
        repo.addTVSeries(series);

        // Rediriger brukeren til den nylig opprettede TV-serien sin detalj-oversikt
        context.redirect("/tvseries/" + series.getTitle());
    }


}
