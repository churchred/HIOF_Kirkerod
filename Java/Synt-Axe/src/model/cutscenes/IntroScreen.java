package model.cutscenes;

import java.io.IOException;

public class IntroScreen {

    private String title = "Syntaxe";
    private String version = "0.1";
    private String developer = "Churchred Inc";
    private int speed = 10;


    public void play(){

        String intoText = "Welcome to " + title;

        for(int i = 0; i<intoText.length()+1; i++){


            clearScreen();
            System.out.println("\n" + intoText.substring(0, i));

            try {
                Thread.sleep(speed); // Pause for 1 seconds (1000 milliseconds)
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }



        }

    }


    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



}
