package com.udemy.section19.databases.example03_indexes_queryForArtistsAsc;

import com.udemy.section19.databases.example03_indexes_queryForArtistsAsc.model.Artist;
import com.udemy.section19.databases.example03_indexes_queryForArtistsAsc.model.Datasource;

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



        datasource.close();
    }
}
