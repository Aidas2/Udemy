package com.udemy.section19.databases.example04_queryAlbumsByArtists;

import com.udemy.section19.databases.example04_queryAlbumsByArtists.model.Artist;
import com.udemy.section19.databases.example04_queryAlbumsByArtists.model.Datasource;

import java.util.List;

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
                datasource.queryAlbumsForArtist("Iron Maiden", Datasource.ORDER_BY_ASC);

        for(String album : albumsForArtist) {
            System.out.println(album);
        }

        //==============================================================================================================


        //==============================================================================================================



        datasource.close();
    }
}
