package com.udemy.section19.databases.example07_preparedStatments;

import com.udemy.section19.databases.example07_preparedStatments.model.Artist;
import com.udemy.section19.databases.example07_preparedStatments.model.Datasource;
import com.udemy.section19.databases.example07_preparedStatments.model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        //==============================================================================================================
        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_ASC);
        if(artists == null) {
            System.out.println("No artists!");
            return;
        }

        for(Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        //==============================================================================================================
        List<String> albumsForArtist =
                datasource.queryAlbumsForArtist("Pink Floyd", Datasource.ORDER_BY_ASC);

        for(String album : albumsForArtist) {
            System.out.println(album);
        }

        //==============================================================================================================
        List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", Datasource.ORDER_BY_ASC);
        if(songArtists == null) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : songArtists) {
            System.out.println("Artist name = " + artist.getArtistName() +
                    " Album name = " + artist.getAlbumName() +
                    " Track = " + artist.getTrack());
        }

        datasource.querySongsMetadata();

        //==============================================================================================================
        System.out.println("\n" + "==================================================================================");
        int count = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

        datasource.createViewForSongArtists();

        //==============================================================================================================
        //version#1:
        /*
        songArtists = datasource.querySongInfoView("Go Your Own Way");
        if(songArtists.isEmpty()) { //better than sonArtists == null
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : songArtists) {
            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
                    " Album name = " + artist.getAlbumName() +
                    " Track number = " + artist.getTrack());
        }
        */
        //version#2 (with sql injection)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: "); //Go Your Own Way" or 1=1 or "
        String title = scanner.nextLine();

        songArtists = datasource.querySongInfoView(title);
        if(songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : songArtists) {
            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
                    " Album name = " + artist.getAlbumName() +
                    " Track number = " + artist.getTrack());
        }

        // SELECT name, album, track FROM artist_list WHERE title = "Go Your Own Way" or 1=1 or ""  //treated as sql
        // SELECT name, album, track FROM artist_list WHERE title = "Go Your Own Way or 1=1 or ""   //treated as one single literal value



        datasource.close();
    }
}
