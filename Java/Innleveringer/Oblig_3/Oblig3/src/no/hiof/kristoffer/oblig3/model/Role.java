package no.hiof.kristoffer.oblig3.model;

public class Role {

    private String roleFirstName;
    private String roleLastName;
    private Person actor;

    // Konstruktør
    public Role(String roleFirstName, String roleLastName, Person actor) {
        this.roleFirstName = roleFirstName;
        this.roleLastName = roleLastName;
        this.actor = actor;
    }

    // Getter-metoder
    public String getRoleFirstName() {
        return roleFirstName;
    }

    public String getRoleLastName() {
        return roleLastName;
    }

    public Person getActor() {
        return actor;
    }

    // Setter-metoder
    public void setRoleFirstName(String roleFirstName) {
        this.roleFirstName = roleFirstName;
    }

    public void setRoleLastName(String roleLastName) {
        this.roleLastName = roleLastName;
    }

    public void setActor(Person actor) {
        this.actor = actor;
    }

    // Override toString()
    @Override
    public String toString() {
        return "\nRole first name: " + roleFirstName +
                "\nRole last name: " + roleLastName +
                "\nActor: " + actor.getFullName();
    }
}
