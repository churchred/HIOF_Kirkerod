package no.hiof.kristoffer.forelesning5;

import no.hiof.kristoffer.forelesning5.model.BussDriver;
import no.hiof.kristoffer.forelesning5.model.CarpenterApprentice;
import no.hiof.kristoffer.forelesning5.model.Person;
import no.hiof.kristoffer.forelesning5.model.Carpenter;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {


        Person person = new Person("Ola", "Nordmann", 20);
        System.out.println("Person: " + person.getFirstName() + " " + person.getLastName());


        Carpenter carpenter = new Carpenter("Rudolf", "Arnesen", 45, 3);

        System.out.println("Carpenter: " + carpenter.getFirstName() + " " + carpenter.getLastName());

        System.out.println("Carpenter has built " + carpenter.getNumHousesBuilt() + " houses.");


        carpenter.setFirstName("Noldus");
        carpenter.setLastName("Gnoldus");
        System.out.println("Carpenter: " + carpenter.getFirstName() + " " + carpenter.getLastName());

        BussDriver bussDriver = new BussDriver("Bjarne", "Bo", 55, "630 - Moss, Halden");

        System.out.println("Buss driver: " + bussDriver.getFirstName() + " " + bussDriver.getLastName());
        System.out.println("Buss driver has route " + bussDriver.getRoute());

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.of(2026, 6, 15);
        CarpenterApprentice  apprentice = new CarpenterApprentice("Jo", "Då", 21, 0, startDate, endDate);

        System.out.println(apprentice);


    }
}