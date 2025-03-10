package no.hiof.kristoffer;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.implementation.bind.annotation.Super;
import no.hiof.kristoffer.model.SuperHero;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SuperHero batman = new SuperHero("Batman", "Bruce Wayne");
        SuperHero wolverine = new SuperHero("Wolverine", "Logan");
        SuperHero wonderWoman = new SuperHero("Wonder Woman", "Diana Prince");

        // Batman sidekicks
        ArrayList<SuperHero> batmanSidekicks = new ArrayList<>();
        batmanSidekicks.add(new SuperHero("Robin", "Jason Todd"));
        batmanSidekicks.add(new SuperHero("Batgirl", "Barbara Gordon"));
        batman.setSideKicks(batmanSidekicks);

        ArrayList<SuperHero> superHeroes = new ArrayList<>();
        superHeroes.add(batman);
        superHeroes.add(wolverine);
        superHeroes.add(wonderWoman);

        File file = new File("JSON_file.json");
        writeSuperHeroesToJSON(superHeroes, file);

        ArrayList<SuperHero> superHeroesFromJSON = readSuperHeroesFromJSON(file);
        for (SuperHero superHeroX : superHeroesFromJSON){
            System.out.println(superHeroX);
        }

    }

    public static void writeSuperHeroesToJSON(ArrayList<SuperHero> listOfSuperheroes,
                                              File file) {
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, listOfSuperheroes);
        }
        catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static ArrayList<SuperHero> readSuperHeroesFromJSON(File file){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            SuperHero[] superHeroArray = objectMapper.readValue(file, SuperHero[].class);
            return new ArrayList<>(Arrays.asList(superHeroArray));
        }
        catch (IOException exception){
            System.err.println(exception);
        }

        return new ArrayList<>();

    }

}