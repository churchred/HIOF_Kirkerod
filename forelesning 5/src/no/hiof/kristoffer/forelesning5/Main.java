package no.hiof.kristoffer.forelesning5;

import no.hiof.kristoffer.forelesning5.model.Person;
import no.hiof.kristoffer.forelesning5.model.Carpenter;


public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Ola", "Nordmann", 20);
        System.out.println("Person: " + person1.getFirstName() + " " + person1.getLastName());

        Carpenter carpenter1 = new Carpenter("Rudolf", "Arnesen", 45, 3);
        System.out.println("Person: " + carpenter1.getFirstName() + " " + carpenter1.getLastName());
    }
}