package no.hiof.kristoffer.model;

import java.time.LocalDate;

public class HoneyBadger extends Animal {

    private int snakesEaten = 0;

    public HoneyBadger(String name, LocalDate birthDate) {
        super(name, birthDate);
        this.species = "Honeybadger";
    }

    public int getSnakesEaten(){
        return snakesEaten;
    }

    private void eatSnakes(){
        snakesEaten++;
    }
}
