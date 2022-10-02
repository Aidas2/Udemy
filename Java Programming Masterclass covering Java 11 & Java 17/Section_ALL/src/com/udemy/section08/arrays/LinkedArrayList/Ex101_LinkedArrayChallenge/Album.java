package com.udemy.section08.arrays.LinkedArrayList.Ex101_LinkedArrayChallenge;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String albumName;
    private String performerName;
    private ArrayList<Song> songs;


    public Album(String albumName, String performerName) {
        this.albumName = albumName;
        this.performerName = performerName;
        this.songs = new ArrayList<>();
    }

    public String getAlbumName() {
        return albumName;
    }


    public void addNewSongToAlbum(String songName, double songDuration) {
        if (checkIfSongExist(songName)) {
            System.out.println("This song already included in album");
        } else {
            Song song = new Song(songName, songDuration);
            this.songs.add(song);
        }
    }

    public void addSongToPlaylist(String songName, LinkedList<Song> playlist) {
        Song existingSong = findSongByName(songName);
        if(findSongByName(songName) != null) {
            playlist.add(existingSong);
        } else {
            System.out.println("Song " + songName + " can't be added to playlist (it isn't included in album)");
        }
    }

    /// helpful methods

    private boolean checkIfSongExist(String songName) {
        for (Song checkedSong: this.songs) {
            if (checkedSong.getName().equals(songName)) {
                return true;
            }
        }
        return false;
    }

    private Song findSongByName(String songName) {
        for (Song findedSong: this.songs) {
            if(findedSong.getName().equals(songName)) {
                return findedSong ;
            }
        }
        return null;
    }

    public void printSongsInAlbum() {
        System.out.println("Album " + this.albumName + " contains " + this.songs.size() + " songs:");
        for (int i = 0; i < this.songs.size(); i++) {
            System.out.println("Song Nr." + (i + 1) + " " + this.songs.get(i).getName() + ", duration: " + this.songs.get(i).getDuration());
        }
        System.out.println();
    }


}
