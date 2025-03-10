package no.hiof.kristoffer.model;


import java.util.ArrayList;

public class SuperHero {

    private String name;
    private String secretIdentitiy;
    private ArrayList<SuperHero> sideKicks = new ArrayList<>();


    public SuperHero(){

    }

    public SuperHero(String name, String secretIdentitiy) {
        this.name = name;
        this.secretIdentitiy = secretIdentitiy;
    }

    @Override
    public String toString() {
        return "Superhero name: " + name + " - Secret identity: " + secretIdentitiy;
    }

    public ArrayList<SuperHero> getSideKicks() {
        return sideKicks;
    }

    public void setSideKicks(ArrayList<SuperHero> sideKicks) {
        this.sideKicks = sideKicks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecretIdentitiy() {
        return secretIdentitiy;
    }

    public void setSecretIdentitiy(String secretIdentitiy) {
        this.secretIdentitiy = secretIdentitiy;
    }
}