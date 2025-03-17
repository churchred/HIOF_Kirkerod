package no.hiof.kristoffer.repository;


import no.hiof.kristoffer.model.Animal;
import no.hiof.kristoffer.model.Zoo;

import java.util.ArrayList;


public interface ZooRepository {

    Animal getMascot();
    ArrayList<Zoo> getAllZoos();

    Zoo getZooByName(String name);


}