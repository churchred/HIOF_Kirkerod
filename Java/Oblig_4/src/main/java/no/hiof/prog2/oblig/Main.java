package no.hiof.prog2.oblig;

import no.hiof.prog2.oblig.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /*
        Oppgave 2.2
         */
        Movie pussInBoots = new Movie("Puss in Boots: The Last Wish", "Cat with friends adventures",
                102, LocalDate.of(2022, 12, 7));
        Movie interstellar = new Movie("Interstellar", "Space/time adventures", 169,
                LocalDate.of(2014, 10, 26));

        System.out.println("---Oppgave 2.2---");
        System.out.println("Movie 1: " + pussInBoots.getTitle());
        System.out.println("Movie 2: " + interstellar.getTitle());

        Episode pilot = new Episode("Pilot", 1, 1);

        /*
        Oppgave 2.4
         */
        Person christopherNolan = new Person("Christopher", "Nolan");
        Person vinceGilligan = new Person("Vince", "Gilligan");

        interstellar.setDirector(christopherNolan);
        pilot.setDirector(vinceGilligan);

        System.out.println("\n---Oppgave 2.4---");
        System.out.println("The director of the movie " + interstellar.getTitle() + " is " +
                interstellar.getDirector().getFullName());
        System.out.println("The director of the episode " + pilot.getTitle() + " is " +
                pilot.getDirector().getFullName());


        /*
        Oppgave 2.5
         */
        Movie theDarkKnight = new Movie("The Dark Knight");

        Role batman = new Role("Bruce", "Wayne", new Person("Christian", "Bale"));
        theDarkKnight.addToRoles(batman);

        Role joker = new Role("Joker", "", new Person("Heath", "Ledger"));
        Role jimGordon = new Role("James", "Gordon", new Person("Gary", "Oldman"));
        ArrayList<Role> theDarkKnightRoles = new ArrayList<>();
        theDarkKnightRoles.add(joker);
        theDarkKnightRoles.add(jimGordon);

        theDarkKnight.addToRoles(theDarkKnightRoles);

        System.out.println("\n---Oppgave 2.5---");
        System.out.println("The Dark Knight Roles:");
        for (Role role : theDarkKnight.getRoles()) {
            System.out.println(role);
        }

        /*
        Oppgave 2.7 (og bonusoppgaven 3.1)
         */
        TVSeries breakingBad = new TVSeries("Breaking Bad", "Drug manufacturer/dealer adventures",
                LocalDate.of(2008, 1, 20));

        //Actors
        Person bryanCranston = new Person("Bryan", "Cranston");
        Person aaronPaul = new Person("Aaron", "Paul");
        Person deanNorris = new Person("Dean", "Norris");

        //Roles
        Role walterWhite = new Role("Walter", "White", bryanCranston);
        Role jessePinkman = new Role("Jesse", "Pinkman", aaronPaul);
        Role hankShrader = new Role("Hank", "Shrader", deanNorris);

        pilot.addToRoles(walterWhite);
        pilot.addToRoles(jessePinkman);

        Episode catsInTheBag = new Episode("Cat's in hte Bag", 2, 1);

        catsInTheBag.addToRoles(walterWhite);
        catsInTheBag.addToRoles(jessePinkman);
        catsInTheBag.addToRoles(hankShrader);

        breakingBad.addEpisode(pilot);
        breakingBad.addEpisode(catsInTheBag);

        System.out.println("\n---Oppgave 2.5---");
        System.out.println("Breaking Bad Cast:");
        ArrayList<Role> breakingBadCast = breakingBad.getCast();
        for (Role role : breakingBadCast) {
            System.out.println(role);
        }

        /*
        Oppgave 3.2 (bonus)
         */
        System.out.println("\n---Oppgave 3.1 (Bonus)");
        System.out.println("Episodes with Bryan Cranston: " + breakingBad.numberOfEpisodesWithActor(bryanCranston));
        System.out.println("Episodes with Dean Norris: " + breakingBad.numberOfEpisodesWithActor(deanNorris));


        /*
        Oppgave 3.3 (bonus)
         */
        System.out.println("\n---Oppgave 3.3---");

        TVSeries daysOfOurLives = generateDaysOfOurLives();

        ArrayList<Episode> episodesS42 = daysOfOurLives.getEpisodesInSeason(42);

        System.out.println("Days of our Lives Season 42");
        for (Episode episode : episodesS42) {
            LocalDate releaseDate = episode.getReleaseDate();
            System.out.println(episode.getTitle() + " Date: " + releaseDate.getDayOfWeek() + " " + releaseDate);
        }
    }

    /*
    Oppgave 3.3 (bonus)
     */
    public static TVSeries generateDaysOfOurLives() {
        LocalDate nextDate = LocalDate.of(1965, 11, 8);

        TVSeries daysOfOurLives = new TVSeries("Days of our Lives", "Long running series",
                nextDate);

        int episodeNumber = 1;
        int seasonNumber = 1;
        int currentYear = 1965;

        for (int e = 1; e < 15000; e++) {
            if (nextDate.getDayOfWeek().getValue() == 6) {
                nextDate = nextDate.plusDays(2);
            }
            if (nextDate.getYear() != currentYear) {
                currentYear = nextDate.getYear();
                seasonNumber++;
                episodeNumber = 1;
            }

            Episode episode = new Episode("Episode " + episodeNumber, episodeNumber, seasonNumber,
                    "Just another episode in the days of our lives", 20, nextDate);
            daysOfOurLives.addEpisode(episode);

            nextDate = nextDate.plusDays(1);
            episodeNumber++;

        }

        return daysOfOurLives;
    }
}
