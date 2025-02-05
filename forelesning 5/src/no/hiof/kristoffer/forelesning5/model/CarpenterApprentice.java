package no.hiof.kristoffer.forelesning5.model;

import java.time.LocalDate;

public class CarpenterApprentice extends Carpenter{


    private LocalDate trainingStartDate;
    private LocalDate trainingEndDate;

    public CarpenterApprentice(String firstName, String lastName, int age, int numHousesBuilt,
                               LocalDate trainingStartDate, LocalDate trainingEndDate){

        super(firstName, lastName, age, numHousesBuilt);

        this.trainingEndDate = trainingEndDate;
        this.trainingStartDate = trainingStartDate;
    }

    // Getters and setters: StartDate
    public LocalDate getTrainingStartDate() {
        return trainingStartDate;
    }
    public void setTrainingStartDate(LocalDate trainingStartDate) {
        this.trainingStartDate = trainingStartDate;
    }

    // Getters and setters: EndDate
    public LocalDate getTrainingEndDate() {
        return trainingEndDate;
    }
    public void setTrainingEndDate(LocalDate trainingEndDate) {
        this.trainingEndDate = trainingEndDate;
    }
}
