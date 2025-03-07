package no.hiof.prog2.oblig.model;

/*
Oppgave 2.5
 */
public class Role {
    private String roleFirstName;
    private String roleLastName;
    private Person actor;

    public Role(String roleFirstName, String roleLastName, Person actor) {
        this.roleFirstName = roleFirstName;
        this.roleLastName = roleLastName;
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Role name: " + roleFirstName + " " + roleLastName + ", Actor: " + actor;
    }

    public String getRoleFirstName() {
        return roleFirstName;
    }

    public void setRoleFirstName(String roleFirstName) {
        this.roleFirstName = roleFirstName;
    }

    public String getRoleLastName() {
        return roleLastName;
    }

    public void setRoleLastName(String roleLastName) {
        this.roleLastName = roleLastName;
    }

    public Person getActor() {
        return actor;
    }

    public void setActor(Person actor) {
        this.actor = actor;
    }
}
