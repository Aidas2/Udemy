package InnerClass.ChallengeAidasV1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dev on 18/09/15.
 */

// Lesson 111. Inner class challenge:
// Modify the playlist challenge so that the Album class uses an inner class.
// Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
// The inner SongList class will use an ArrayList and will provide a method to add a song.
// It will also provide findSong() methods which will be used by the containing Album class
// to add songs to the playlist.
// Neither the Song class or the Main class should be changed.

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

//    public boolean addSong(String title, double duration) {
//        if(findSong(title) == null) {
//            this.songs.add(new Song(title, duration));
//            return true;
//        }
//        return false;
//    }
    public boolean addSong(String title, double duration) {
        return this.songs.addSong(new Song(title, duration));
    }

//    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
//        int index = trackNumber -1;
//        if((index >=0) && (index <= this.songs.size())) {
//            playList.add(this.songs.get(index));
//            return true;
//        }
//        System.out.println("This album does not have a track " + trackNumber);
//        return false;
//    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(trackNumber);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        } else {
            System.out.println("This album does not have a track " + trackNumber);
            return false;
        }
    }

//    public boolean addToPlayList(String title, LinkedList<Song> playList) {
//        Song checkedSong = findSong(title);
//        if(checkedSong != null) {
//            playList.add(checkedSong);
//            return true;
//        }
//        System.out.println("The song " + title + " is not in this album");
//        return false;
//    }
    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

//=========================================================

    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        public boolean addSong(Song song) {
            if(this.songs.contains(song)) {
                return false;
            } else {
                this.songs.add(song);
                return true;
            }
        }

        private Song findSong(String title) {
            for(Song checkedSong: this.songs) {
                if(checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        }

        public Song findSong (int trackNumber) {
            int index = trackNumber - 1;
            if(index >= 0 && index < this.songs.size()){
                return this.songs.get(index);
            } else {
                return null;
            }
        }
    }


}
