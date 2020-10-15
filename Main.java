package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

   public static Scanner skan = new Scanner(System.in);

    private static ArrayList<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {

        Album album1 = new Album("Album One","Damien Rice");
        album1.addSongToAlbum("song1", 4.32);
        album1.addSongToAlbum("delicate", 2.43);
        album1.addSongToAlbum("volcano", 2.54);
        albums.add(album1);

        album1 = new Album("Second","Madonna");

        album1.addSongToAlbum("Water", 5.31);
        album1.addSongToAlbum("Flames", 3.35);
        album1.addSongToAlbum("Spiracle", 2.53);
        albums.add(album1);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(1).addToPlaylist("Flames", playlist);
        albums.get(0).addToPlaylist("delicate",playlist);
        albums.get(0).addToPlaylist("volcano",playlist);
        albums.get(1).addToPlaylist("Water", playlist);
        albums.get(1).addToPlaylist("Spiracle",playlist);

        play(playlist);




    }


    private static void play (LinkedList<Song> playlist){

        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> iterator = playlist.listIterator();

        showMenu();

        if (playlist.size()==0){
            System.out.println("no song on playlist");
        }else {
            System.out.println("Now playing: "+iterator.next().toString());
        }

        while (!quit){
            System.out.println("Enter option:");
            int option= skan.nextInt();

            switch (option){
                case 0: quit=true;
                break;
                case 1://play forward

                    if(!forward){
                        if (iterator.hasNext()){
                            iterator.next();
                            forward=true;
                        }
                    }

                    if(iterator.hasNext()) {
                        System.out.println(iterator.next().toString());
                    }else {
                        System.out.println("End of the list");
                        forward = false;
                    }
                    break;
                case 2://repeat song
                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous().toString());
                        if(forward){
                            if(iterator.hasNext()){
                                iterator.next();
                            }
                        }else iterator.previous();
                    }else {
                        System.out.println("Beginning of the list reached");
                        forward = true;
                    }
                    break;
                case 3://previous song

                    if(forward){
                        if(iterator.hasPrevious()){
                            iterator.previous();
                            forward=false;
                        }
                    }
                    if(iterator.hasPrevious()) {
                        System.out.println( iterator.previous());
                    }else {
                        System.out.println("Beginning of the list");
                        forward=true;
                    }
                    break;
                case 4://options
                    showMenu();
                    break;
                case 5://delete song
                    iterator.remove();
                    System.out.println("Song removed");
                    if(iterator.hasNext()){
                        System.out.println("Now playing: "+iterator.next().toString());
                    }else if (iterator.hasPrevious()){
                        System.out.println("Now playing: "+iterator.previous().toString());
                    }else System.out.println("Playlist is empty");
                    break;
                case 6://show playlist
                    System.out.println("=====================\n" +
                            "Your playlist:\n");
                    for (Song song : playlist) {
                        System.out.println(song.toString());
                    }
                    System.out.println("=====================");
                    break;

                default:
                    System.out.println("There's no such option. Choose option from menu:\n");
                    showMenu();
            }
        }

    }

    public static void showMenu(){

        System.out.println("Available options:\n" +
                "0- quit\n" +
                "1- play next\n" +
                "2- repeat song\n" +
                "3- previous song\n" +
                "4- show menu options\n" +
                "5- delete song from the playlist\n" +
                "6- show playlist");
    }






}

