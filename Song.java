package com.company;

public class Song {

    private String songName;
    private double duration;

    public Song(String songName, double duration) {
        this.songName = songName;
        this.duration = duration;
    }

    public String getSongName() {
        return songName;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return songName+": "+duration;
    }
}
