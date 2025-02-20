package no.hiof.kristoffer.oblig3.model;

public class Person {

    private String firstName;
    private String lastName;

    // Konstruktør
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter-metoder
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Setter-metoder
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Override toString()
    @Override
    public String toString() {
        return "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName;
    }
}
