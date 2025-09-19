package no.hiof.oleedvao.forelesning22;

import no.hiof.oleedvao.forelesning22.model.Album;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {


    public final static String DB_URL = "jdbc:mysql://localhost:3306/albumdb";
    public final static String USERNAME = "root";
    public final static String PASSWORD = "gibbs1996";










    public static void main(String[] args) {


        // addAlbum(new Album("Ring of Fire", "Adelle", 1969));

        System.out.println("All albums from database:");
        ArrayList<Album> allAlbums = getAllAlbums();

        for (Album album : allAlbums){
            System.out.println(album);
        }

    }

    public static void addAlbum(Album album){
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)){
            String mySql = "INSERT INTO album (Title, Artist, Year) values (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(mySql)){

                preparedStatement.setString(1, album.getTitle());
                preparedStatement.setString(2, album.getArtist());
                preparedStatement.setInt(3, album.getYear());

                preparedStatement.executeUpdate();

            }



        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }


    public static ArrayList<Album> getAllAlbums(){

        ArrayList<Album> allAlbum = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)){
            String mySql = "SELECT * FROM album";

            try (PreparedStatement preparedStatement = connection.prepareStatement(mySql);
                 ResultSet resultSet = preparedStatement.executeQuery()){

                while (resultSet.next()) {
                    String title = resultSet.getString("Title");
                    String artist = resultSet.getString("Artist");
                    int year = resultSet.getInt("Year");

                    Album fetchedAlbum = new Album(title, artist, year);
                    allAlbum.add(fetchedAlbum);

                }


            }


        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        return allAlbum;
    }
}



public Production(String title, String description, int
                  runtimeInMinutes, LocalDate releaseDate) {
    this.title = title;
    this.description = description;
    this.runtimeInMinutes = runtimeInMinutes;
    this.releaseDate = releaseDate;
}







