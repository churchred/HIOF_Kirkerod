package model;


public class IntroScreen {

    private String title = "Syntaxe";
    private String version = "v0.1";
    private String developer = "Churchred Inc";
    private int speed = 100;


    public void play(){

        System.out.println("Welcome to " + title + " " + version);
        System.out.println("\nDeveloped by " + developer);

    }


    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



}