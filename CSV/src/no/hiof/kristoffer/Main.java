package no.hiof.kristoffer;

import no.hiof.kristoffer.model.SuperHero;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SuperHero batnman = new SuperHero("The Fin", "Aaro Ilmari Sivula");
        SuperHero wolverwine = new SuperHero("Platinum-man", "Tadas Vaitkevicius");
        SuperHero wonderWoman = new SuperHero("Stone-man", "Stein Osen");

        ArrayList<SuperHero> superHeroes = new ArrayList<>();
        superHeroes.add(batnman);
        superHeroes.add(wolverwine);
        superHeroes.add(wonderWoman);

        File csvFile = new File("superheroes.csv");
        writeSuperHeroesToCSV(superHeroes, csvFile);

    }

    public static ArrayList<SuperHero> readSuperHeroFromCSV(File file){
        ArrayList<SuperHero> fetchedSuperHeroes = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){

                String line;
                while( (line = bufferedReader.readLine()) != null ) {

                    String[] values = line.split(", ");
                    String name = values[0];
                    String secretIdentity = values[1];

                    SuperHero superHero = new SuperHero(name, secretIdentity);
                    fetchedSuperHeroes.add(superHero);
                }

        }
        catch(FileNotFoundException exception){
            System.err.println(exception.getMessage());
        }
        catch(IOException exception){
            System.err.println(exception.getMessage());
        }


        return fetchedSuperHeroes;
    }

    public static void writeSuperHeroesToCSV(ArrayList<SuperHero> heroArrayList, File file){

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){

            for (SuperHero superhero : heroArrayList){
                String name = superhero.getName();
                String secretIdentity = superhero.getSecretIdentity();

                bufferedWriter.write(name + ", " + secretIdentity);
                bufferedWriter.newLine();

            }
        }
        catch(IOException exception){
            System.err.println(exception.getMessage());
        }
    }

}
