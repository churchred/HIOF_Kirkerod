package no.hiof.kristoffer.oblig3;

import no.hiof.kristoffer.oblig3.model.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Oppretter filmobjekter
        Movie fallGuy = new Movie("Fall Guy", 59, "A cool movie. With Explotion!", LocalDate.of(2021, 1, 20));
        Movie matrix = new Movie("Matrix", 112, "Red or blue pill?", LocalDate.of(1995, 3, 12));

        // Skriver ut filmtitler
        System.out.println(fallGuy.getTitle());
        System.out.println(matrix.getTitle());

        // Oppretter regissører
        Person thomas = new Person("Thomas", "Gjertsen");
        Person ole = new Person("Ole", "Peterson");

        // Setter regissører
        matrix.setDirector(thomas);
        fallGuy.setDirector(ole);

        // Skriver ut regissører
        System.out.println(matrix.getDirector().getFullName());
        System.out.println(fallGuy.getDirector().getFullName());

        // Oppretter skuespillere
        Person actor1 = new Person("Robert", "Downey");
        Person actor2 = new Person("Nathalie", "Portman");
        Person actor3 = new Person("Stein", "Osen");
        Person actor4 = new Person("Tadas", "Syversen");

        // Oppretter roller
        Role role1 = new Role("Tony", "Stark", actor1);
        Role role2 = new Role("Black", "Widow", actor2);
        Role role3 = new Role("Steve", "Rogers", actor3);
        Role role4 = new Role("Steve", "Rogers", actor3);
        Role role5 = new Role("Bruce", "Banner", actor4);

        // Legger til roller i film
        matrix.addToRoles(role1);
        matrix.addToRoles(role2);
        matrix.addToRoles(role3);

        // Oppretter TV-serie
        TVSeries series1 = new TVSeries("Leverage", "A group of thieves steal from criminals to help regular people", "12.01.12");

        // Oppretter episoder
        Episode episode1 = new Episode("S1E1", 1, 1, "A cool episode!", LocalDate.of(1996, 1, 2), 22);
        Episode episode2 = new Episode("S1E2", 2, 1, "A cool episode!", LocalDate.of(1996, 1, 8), 20);
        Episode episode3 = new Episode("S1E3", 3, 1, "A cool episode!", LocalDate.of(1996, 1, 5), 23);

        // Legger til roller i episoder
        episode1.addToRoles(role1);
        episode1.addToRoles(role2);
        episode2.addToRoles(role3);
        episode3.addToRoles(role5);

        // Legger til episoder i serien
        series1.addEpisodes(episode1);
        series1.addEpisodes(episode2);
        series1.addEpisodes(episode3);

        // Skriver ut rollebesetningen i serien
        for (Role role : series1.hentRollebesetning()) {
            System.out.println(role);
        }
    }
}
