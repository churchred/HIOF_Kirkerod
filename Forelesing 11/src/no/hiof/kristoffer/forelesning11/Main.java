package no.hiof.kristoffer.forelesning11;

import no.hiof.kristoffer.forelesning11.model.Person;
import no.hiof.kristoffer.forelesning11.util.UnitConverter;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("---final instance variable---");

        Person person = new Person("12345678910");
        System.out.println("Birth number: " + person.getBirthNumber());

        Person person2 = new Person("Ola", "Nordmann", 5, "10987654321");
        System.out.println("Birth number 2: " + person2.getBirthNumber());

        System.out.println("\n---Utility class---");
        double result = UnitConverter.cmToMeter(600);
        System.out.println("600 cm is " + result + " meter");

        double result2 = UnitConverter.meterToCm(250);
        System.out.println("250 meter is " + result2 + " cm");

        double result3 = UnitConverter.meterToKm(3400);
        System.out.println("3400 meter is " + result3 + " km");

        double result4 = UnitConverter.kmToMeter(6.845);
        System.out.println("6.845 km is " + result4 + " meter");

        System.out.println("Cm/meter conversion factor: " +
                UnitConverter.CM_METER_FACTOR);

        System.out.println("\n---Math and LocalDate");
        System.out.println();
        System.out.println("Pi is " + Math.PI);
        System.out.println("the square root of 25: " + Math.sqrt(25));
        System.out.println("5 to the power of 2 is " + Math.pow(5, 2));

        System.out.println("Today: " + LocalDate.now());
    }
}