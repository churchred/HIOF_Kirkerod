package no.hiof.kristoffer;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import no.hiof.kristoffer.model.Zoo;
import no.hiof.kristoffer.repository.ZooDataRepository;
import no.hiof.kristoffer.repository.ZooRepository;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.staticFiles.enableWebjars();
            javalinConfig.vue.vueInstanceNameInJs = "app";
        }).start();

        ZooRepository zooRepository = new ZooDataRepository();

        app.get("/api/zoo/{zoo-name}", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                String zooName = context.pathParam("zoo-name");
                // context.result(zooName);

                Zoo fetchedZoo = zooRepository.getZooByName(zooName);

                if (fetchedZoo != null){
                    context.json(fetchedZoo);
                }
                else{
                    context.result("Could not find: " + zooName);
                }


            }
        });

        app.get("/api/all-zoos", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                context.json(zooRepository.getAllZoos());
            }
        });

        app.get("/api/mascot", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                context.json(zooRepository.getMascot());
            }
        });


        // --- Pages ---
        app.get("/", new VueComponent("home-page"));

        app.get("/other-page", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                context.result("Hello from the other page!");
            }
        });

    }
}