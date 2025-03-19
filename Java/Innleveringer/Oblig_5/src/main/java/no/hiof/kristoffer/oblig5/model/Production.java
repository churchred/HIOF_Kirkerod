package no.hiof.kristoffer.oblig5.model;

import java.time.LocalDate;
import java.util.ArrayList;

/*
Oppgave 2.1
 */
public class Production {

    private String title;
    private String description;
    private int runtimeInMinutes;
    private LocalDate releaseDate; // Oppgave 2.3
    private Person director; // Oppgave 2.4
    private ArrayList<Role> roles = new ArrayList<>(); // Oppgave 2.5

    public Production(String title) {
        this.title = title;
    }

    /*
    Kanskje være tydeligere på hvordan konstruktøren skal se ut, og overordnet hvilke endringer som må gjøres.
     */
    public Production(String title, String description, int runtimeInMinutes, LocalDate releaseDate) {
        this.title = title;
        this.description = description;
        this.runtimeInMinutes = runtimeInMinutes;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                "\nDescription: " + description +
                "\nRuntime in minutes: " + releaseDate +
                "\nDirector: " + director.getFullName();
    }

    public ArrayList<Role> getRoles() {
        return new ArrayList<>(roles);
    }

    /*
    Oppgave 2.5
     */
    public void addToRoles(Role role) {
        roles.add(role);
    }

    /*
    Oppgave 2.5
     */
    public void addToRoles(ArrayList<Role> listOfRoles) {
        roles.addAll(listOfRoles);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRuntimeInMinutes() {
        return runtimeInMinutes;
    }

    public void setRuntimeInMinutes(int runtimeInMinutes) {
        this.runtimeInMinutes = runtimeInMinutes;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }
}
