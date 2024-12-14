/*
 * Title: Song.java
 * Abstract: Song class that holds a title, artist, year, and length in a Song object
 * Author: Justin Andreoli
 * Email: jandreoli@csumb.edu
 * Estimate: 30 minutes
 * Date: 10/14/2024
 */

public class Song {
    //Attributes
    private String title;
    private String artist;
    private int year;
    private int lengthInSeconds;

    //parameterized constructor
    public Song(String title, String artist, int year, int lengthInSeconds) {

        this.artist = artist;
        this.year = year;
        this.lengthInSeconds = lengthInSeconds;

    }

    //get methods for all 4 attributes
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public int getYear() {
        return year;
    }
    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    //equals (Song s) method that checks if two Song objects have the same title, artist, and length
    public boolean equals(Song s){
        return this.title.equals(s.getTitle())
                && this.artist.equals(s.getArtist())
                && this.year == s.getYear();
    }

    public String getMinutes(){
        int M = this.lengthInSeconds / 60;
        int S = this.lengthInSeconds % 60;
        return M + String.format(":%02d", S);
    }

    //toString method
    public String toString(){
        return this.title + " ("+ this.artist +", " +
                this.year + ") " + this.getMinutes();
    }
}
