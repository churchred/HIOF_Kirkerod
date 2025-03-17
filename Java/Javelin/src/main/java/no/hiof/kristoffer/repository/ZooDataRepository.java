package no.hiof.kristoffer.repository;

import no.hiof.kristoffer.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

/*
Denne klassen er én implementasjon av ZooRepository som baserer seg på hardkodede data. Denne klassen er altså nyttig
å benytte under utvikling/testing.
 */
public class ZooDataRepository implements ZooRepository{

    /*
    Instansvariabler som representerer de viktigste dataene i systemet. Handlinger mot data i denne klassen vil gjøres
    opp mot disse.
     */
    private ArrayList<Zoo> zoos = new ArrayList<>();
    private Animal mascot;


    public ZooDataRepository() {
        Zoo kristiansand = new Zoo("Kristansand");

        Chimp julius = new Chimp("Julius", LocalDate.of(1979, 12, 26),
                80);
        HoneyBadger nils = new HoneyBadger("Nils", LocalDate.now());
        Panda po = new Panda("Po", LocalDate.now(), "Black");
        kristiansand.addAnimal(julius);
        kristiansand.addAnimal(nils);
        kristiansand.addAnimal(po);

        Zoo noahsArk = new Zoo("Noahs Ark");
        noahsArk.addAnimal(new Chimp("Monke", LocalDate.now(), 60));

        zoos.add(kristiansand);
        zoos.add(noahsArk);
        mascot = julius;
    }


    @Override
    public Animal getMascot() {
        return mascot;
    }


    @Override
    public ArrayList<Zoo> getAllZoos() {
        return zoos;
    }

    @Override
    public Zoo getZooByName(String name){
        for (Zoo zoox : zoos){
            if (zoox.getName().equalsIgnoreCase(name)){
                return zoox;
            }
        }
        return null;
    }

}