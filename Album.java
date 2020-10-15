package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album{

    private String albumName;
    private String artist;
    private ArrayList<Song> albumContent;

    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist= artist;
        this.albumContent = new ArrayList<Song>();
    }

    private Song findInAlbum(String song){

        for (Song checked: albumContent){
            if(checked.getSongName().equals(song)){
               return checked;
            }
        }
        return null;
    }


    public void addSongToAlbum(String songName, double duration){
        Song newSong = new Song(songName,duration);
        if(findInAlbum(songName)==null) {
            albumContent.add(newSong);
        }else System.out.print("Song is already in the album");
    }

    public boolean deleteSongFromAlbum(String songName){

        Song found = findInAlbum(songName);
        if (found!=null){
            albumContent.remove(found);
            return true;
        }else return false;
    }

    public void showAlbum(Album album){
        for (int s=0; s<album.albumContent.size();s++){
            System.out.print((s + 1) + ". " + album.albumContent.get(s).getSongName() + " -" + album.albumContent.get(s).getDuration() + "min\n");
        }
    }

    public boolean addToPlaylist(String songName, LinkedList<Song> playlist){
        Song checked = findInAlbum(songName);

        if( checked!= null){
            playlist.add(checked);
            return true;
        }else {
            System.out.println("There's no such song in the album");
            return false;
        }


    }
}
