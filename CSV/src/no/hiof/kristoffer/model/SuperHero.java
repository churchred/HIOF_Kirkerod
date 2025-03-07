package no.hiof.kristoffer.model;

public class SuperHero {
    private String name;
    private String secretIdentity;

    public SuperHero(String name, String secretIdentity) {
        this.name = name;
        this.secretIdentity = secretIdentity;
    }

    public String getName() {
        return name;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    @Override
    public String toString(){
        return "Superhero name: " + name + " - secret identity: " + secretIdentity;
    }
}