package no.hiof.kristoffer;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("text.txt");
        writeToFile(file);
    }

    public static void writeToFile(File file){
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.append("Hello There!");
            fileWriter.append("\n  -Kenobi.");
        }
        catch(IOException exception){
            System.err.println(exception.getMessage());
        }
    }

    public static void readFromFile(File file){

        try ( BufferedReader buffReader = new BufferedReader(new FileReader(file)) ){

            String lineContainer;

            while( (lineContainer = buffReader.readLine()) != null ){
                System.out.println(lineContainer);
            }
        }
        catch (FileNotFoundException exception){
            System.err.println(exception.getMessage());
        }
        catch (IOException exception){
            System.err.println("Something went wrong..");
        }
    }

}
