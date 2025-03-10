package no.hiof.kristoffer.oblig3.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Production {

    private String title;
    private int runTime;
    private LocalDate releaseDate;
    private String description;
    private Person director;
    private ArrayList<Role> roleList = new ArrayList<>();

    // Konstruktører
    public Production(String title, int runTime, LocalDate releaseDate, String description) {
        this.title = title;
        this.runTime = runTime;
        this.releaseDate = releaseDate;
        this.description = description;
    }

    public Production(String title, LocalDate releaseDate, String description) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.description = description;
    }

    // Override toString()
    @Override
    public String toString() {
        return "\n\nEpisode title: " + title +
                "\nRun Time: " + runTime +
                "\nRelease date: " + releaseDate +
                "\nDescription: " + description +
                "\nDirector: " + (director != null ? director.getFullName() : "Not assigned") +
                "\nList of Roles: " + roleList;
    }

    // Metoder for roller
    public ArrayList<Role> getRoleList() {
        return new ArrayList<>(roleList);
    }

    public void addToRoles(ArrayList<Role> roleList) {
        this.roleList.addAll(roleList);
    }

    public void addToRoles(Role role) {
        this.roleList.add(role);
    }

    // Setter-metoder
    public void setTitle(String title) {
        this.title = title;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    // Getter-metoder
    public String getTitle() {
        return title;
    }

    public int getRunTime() {
        return runTime;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public Person getDirector() {
        return director;
    }
}
