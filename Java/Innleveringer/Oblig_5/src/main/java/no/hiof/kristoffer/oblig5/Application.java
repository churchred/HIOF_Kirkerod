package no.hiof.kristoffer.oblig5;

import io.javalin.Javalin;
import io.javalin.vue.VueComponent;
import io.javalin.http.Handler;
import no.hiof.kristoffer.oblig5.model.TVSeries;
import no.hiof.kristoffer.oblig5.model.TVSeriesController;
import no.hiof.kristoffer.oblig5.repository.TVSeriesDataRepository;
import org.jetbrains.annotations.NotNull;
import io.javalin.http.Context;

import java.time.LocalDate;

//  Lag en kjørbar klasse kalt Application.java
public class Application {



    public static void main(String[] args) {

        TVSeriesDataRepository TVSeriesData = new TVSeriesDataRepository();
        TVSeriesController controller = new TVSeriesController(TVSeriesData);

        // Opprett et Javalin-objekt. Sørg for at at objektet konfigureres til å støtte vue
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.staticFiles.enableWebjars();
            javalinConfig.vue.vueInstanceNameInJs = "app";
        }).start();


        // Oppgave 2.3 - Hjemmeside
        // Benytt Javalin til å koble opp rot-path'en "/" til vue-komponenten home-page.vue
        app.get("/", new VueComponent("home-page"));

        // Oppgave 2.4 - TV-serie oversikt
        //  Benytt Javalin til å opprette API-path'en "/api/tvseries"
        app.get("/api/tvseries", controller::getAllSeries);

        // Koble opp path'en "/tvseries" til vue-komponenten tvseries-overview.vue
        app.get("/tvseries", new VueComponent("tvseries-overview"));


        // Oppgave 2.5 - Detaljoversikt for hver enkelt TV-serie
        // Opprett en API-path'en "/api/tvseries/{tvseries-name}". "tvseries-name"
        app.get("/api/tvseries/{tvseries-name}", controller::getSeriesDetails);

        // Koble opp path'en "/tvseries/{tvseries-name}" til vue-komponenten tvseries-detail.vue.
        app.get("/tvseries/{tvseries-name}", new VueComponent("tvseries-detail"));

        // Oppgave 2.6 - Legge til TV-serie
        // Koble opp path'en "/add-tvseries" til vue-komponenten add-tvseries.vue.
        app.get("/add-tvseries", new VueComponent("add-tvseries"));

        // Opprett et API-endepunkt med .post()
        app.post("/api/add-tvseries", controller::addTVSeries);
        
    }
}