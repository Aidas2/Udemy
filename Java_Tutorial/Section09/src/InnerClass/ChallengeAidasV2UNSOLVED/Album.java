package InnerClass.ChallengeAidasV2UNSOLVED;

import java.util.ArrayList;
import java.util.LinkedList;

// Lesson 111. Inner class challenge:
// Modify the playlist challenge so that the Album class uses an inner class.
// Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
// The inner SongList class will use an ArrayList and will provide a method to add a song.
// It will also provide findSong() methods which will be used by the containing Album class
// to add songs to the playlist.
// Neither the Song class or the Main class should be changed.

public class Album {
    private String albumName;
    private String performerName;
    private SongList songs;

    public Album(String albumName, String performerName) {
        this.albumName = albumName;
        this.performerName = performerName;
        this.songs = new SongList();
    }

    public String getAlbumName() {
        return albumName;
    }

    public SongList getSongs() {
        return songs;
    }

    public int getSongsCount() {
        return songs.getSongs().size();
    }

    public void addNewSongToAlbum(String songName, double songDuration) {
        if (this.songs.checkIfSongExist(songName)) {
            System.out.println("This song already included in album");
        } else {
            Song song = new Song(songName, songDuration);
            this.songs.addSong(song);
            //System.out.println("Song " + song.getName() + " added to album");
        }
    }

    public void addSongToPlaylist(String songName, LinkedList<Song> playlist) {
        Song existingSong = this.songs.findSongByName(songName);
        if(this.songs.findSongByName(songName) != null) {
            playlist.add(existingSong);
        } else {
            System.out.println("Song " + songName + " can't be added to playlist (it isn't included in album)");
        }
    }

    public void printSongsInAlbum() {
        System.out.println("Album " + this.albumName + " contains " + getSongsCount() + " songs:");
        for (int i = 0; i < getSongsCount(); i++) {
            System.out.println("Song Nr." + (i + 1) + " " + this.songs.getSongs().get(i).getName() + ", duration: " + this.songs.getSongs().get(i).getDuration());
        }
        System.out.println();
    }

//=========================================================
    //new inner class;

    private class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }



        public ArrayList<Song> getSongs() {
            return songs;
        }

        public boolean addSong (Song song) {
            if(this.songs.contains(song)){
                return false;
            } else {
                return true;
            }
        }

        /// helpful methods

        public boolean checkIfSongExist(String songName) {
            for (Song checkedSong: this.songs) {
                if (checkedSong.getName().equals(songName)) {
                    return true;
                }
            }
            return false;
        }

        public Song findSongByName(String songName) {
            for (Song findedSong: this.songs) {
                if(findedSong.getName().equals(songName)) {
                    return findedSong ;
                }
            }
            return null;
        }









    }

}
