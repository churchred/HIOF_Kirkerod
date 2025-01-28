package no.hiof.kristoffer.forelesning5.model;

public class Carpenter extends Person{

    private int numHousesBuilt;

    public Carpenter(String firstName, String lastName, int age, int numHousesBuilt){
        super(firstName, lastName, age);

        this.numHousesBuilt = numHousesBuilt;
    }



    // Getter
    public int getNumHousesBuilt() {
        return numHousesBuilt;
    }

    // Setter
    public void setNumHousesBuilt(int numHousesBuilt) {
        this.numHousesBuilt = numHousesBuilt;
    }

}
