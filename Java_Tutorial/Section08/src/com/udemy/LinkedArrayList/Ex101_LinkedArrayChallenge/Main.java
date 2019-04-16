package com.udemy.LinkedArrayList.Ex101_LinkedArrayChallenge;


// Create a program that implements a playlist for songs
// Create a Song class having Title and Duration for a song.
// The program will have an Album class containing a list of songs.
// The albums will be stored in an ArrayList
// Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.
// Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
// List the songs in the playlist
// A song must exist in an album before it can be added to the playlist (so you can only play songs that
// you own).
// Hint:  To replay a song, consider what happened when we went back and forth from a city before we
// started tracking the direction we were going.
// As an optional extra, provide an option to remove the current song from the playlist
// (hint: listiterator.remove()

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {


        Album album1 = new Album("Pavasaris", "Nerija");
        album1.addNewSongToAlbum("Stormbringer", 4.6);
        album1.addNewSongToAlbum("Love don't mean a thing", 4.22);
        album1.addNewSongToAlbum("Holy man", 4.3);
        album1.addNewSongToAlbum("Hold on", 5.6);
        album1.addNewSongToAlbum("Lady double dealer", 3.21);
        album1.addNewSongToAlbum("You can't do it right", 6.23);
        album1.addNewSongToAlbum("High ball shooter", 4.27);
        album1.addNewSongToAlbum("The gypsy", 4.2);
        album1.addNewSongToAlbum("Soldier of fortune", 3.13);
        albums.add(album1);
        album1.printSongsInAlbum();

        Album album2 = new Album("Vasara", "Stasys Povilaitis");
        album2.addNewSongToAlbum("For those about to rock", 5.44);
        album2.addNewSongToAlbum("I put the finger on you", 3.25);
        album2.addNewSongToAlbum("Lets go", 3.45);
        album2.addNewSongToAlbum("Inject the venom", 3.33);
        album2.addNewSongToAlbum("Snowballed", 4.51);
        album2.addNewSongToAlbum("Evil walks", 3.45);
        album2.addNewSongToAlbum("C.O.D.", 5.25);
        album2.addNewSongToAlbum("Breaking the rules", 5.32);
        album2.addNewSongToAlbum("Night of the long knives", 5.12);

        albums.add(album2);
        album2.printSongsInAlbum();

        printAlbums();

        LinkedList<Song> playList = new LinkedList<>();

        Song song = new Song("Dainele", 3.5);
        playList.add(song);

        albums.get(0).addSongToPlaylist("Holy man", playList);
        albums.get(0).addSongToPlaylist("Stormbringer", playList);
        albums.get(1).addSongToPlaylist("Lets go", playList);
        albums.get(1).addSongToPlaylist("Breaking the rules", playList);
        albums.get(1).addSongToPlaylist("C.O.D.", playList);
        albums.get(1).addSongToPlaylist("Dainuska", playList);

        //printPlayList(playList);

        play(playList);

    }

    private static void play(LinkedList<Song> playList) {

        if(playList.size() == 0) {
            System.out.println("There is no songs ir playlist");
        } else {
            printMenu();
        }

        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("App closed.");
                    quit = true;
                    break;
                case 1: // going forwards
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing" + listIterator.next().toString());
                    } else {
                        System.out.println("Reached end of playlist");
                        forward = false;
                    }
                    break;
                case 2: // going backwards
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("Reached start of playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of playlist");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We are at the end of playlist");
                        }
                    }


                    break;
                case 4:
                    printPlayList(playList);
                    break;
                case 5://removeSongFromPlaylist();
                    // you don't need that method, task don't requires to pass songName or smth else,
                    // you can identify which song to delete by listIterator (he holds/specifies CURRENT position);

                    if(playList.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
                default:
                    System.out.println("Not allowed action");
            }
        }


    }

    private static void printAlbums() {
        System.out.println("There are " + albums.size() + " albums:");
        for (int i = 0; i < albums.size(); i++) {
            System.out.println("Album Nr." + (i + 1) + ". " + albums.get(i).getAlbumName());
        }
        System.out.println();
    }

    private static void printPlayList(LinkedList<Song> playlist) {
        ListIterator<Song> listIterator = playlist.listIterator();

        System.out.println("====================================\n" + "There are " + playlist.size() + " songs ir playlist:");
        while (listIterator.hasNext()) {
            int index = playlist.indexOf(listIterator);
            System.out.println("Song Nr." + (index+1) + " " + listIterator.next().toString())  ;
        }
        System.out.println("==================================");
    }

    public static void printMenu() {
        System.out.println("Press: \n" +
                "0 - to quit \n" +
                "1 - to skip forward \n" +
                "2 - to skip backward \n" +
                "3 - to repeat song \n" +
                "4 - to print playlist \n" +
                "5 - to remove song");
    }

    // you don't need that method, task don't requires to pass songName or smth else,
//    public void removeSongFromPlaylist() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter song name:");
//        String songName = scanner.nextLine();
//
//    }

}
