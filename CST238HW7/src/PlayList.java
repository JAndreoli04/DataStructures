/*
 * Title: PlayList.java
 * Abstract: Playlist class to manage a play list of Songs
 * Author: Justin Andreoli
 * Email: jandreoli@csumb.edu
 * Estimate: 1 hours
 * Date: 10/14/2024
 */

public class PlayList {
    //attributes
    public static final int DEFAULT_SIZE = 10;
    private Song [] playList;
    private int playListSize;

    public PlayList() {
        this.playList = new Song[DEFAULT_SIZE];
        this.playListSize = 0;
    }

    public void add(Song s){
        if(playListSize == DEFAULT_SIZE){
            resize();
        }
        this.playList[playListSize] = s;
        this.playListSize++;

    }

    //method to resize playList
    private void resize(){
        Song [] temp = new Song[playList.length*2];
        for(int i = 0; i < playListSize; i++){
            temp[i] = playList[i];
        }
        this.playList = temp;
    }

    //method to move a song from one position to another using shifting
    public void move(int startingPosition, int endingPosition){
        //check position are valid
        if(startingPosition > playListSize || startingPosition < 0){
            System.out.println("starting position out of bounds");
            return;
        }if(endingPosition > playList.length || endingPosition < 0){
            System.out.println("ending position out of bounds");
            return;
        }

        //if starting position > ending position, shift right
        //if starting position < ending position, shift left

        if(startingPosition > endingPosition){
            Song temp = this.playList[startingPosition];
            for(int i = startingPosition; i > endingPosition; i--){
                this.playList[i] = playList[i-1];
            }
            this.playList[endingPosition] = temp;

        }else if(startingPosition < endingPosition){
            Song temp = this.playList[startingPosition];
            for(int i = startingPosition; i < endingPosition; i++){
                this.playList[i] = playList[i+1];
            }
            this.playList[endingPosition] = temp;
        }

    }

    //toString method to return all songs in order
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < playListSize; i++){
            sb.append((i+1) + ". " + this.playList[i] + "\n");
        }

        return sb.toString();

    }

    //a method to perform linear search
    private int linearSearch(int year){
        System.out.println("Running Linear Search");
        for (int i = 0; i < playListSize; i++) {
            if(year == playList[i].getYear()){
                return i;
            }
        }
        return -1;
    }

    private int binarySearch(int year){
        System.out.println("Running Binary Search");
        int low = 0;
        int high = playListSize - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(year == playList[mid].getYear()){
                return mid;
            }else if(year < playList[mid].getYear()){
                high = mid - 1;
            }else if(year > playList[mid].getYear()){
                low = mid + 1;
            }
        }
        return -1;
    }

    //a method to check if the PlayList is sorted by year (in ascending order)
    private boolean isSortedByYear(){
        for(int i = 0; i < this.playListSize-1; i++){
            if(this.playList[i].getYear() > this.playList[i+1].getYear()){
                return false;
            }
        }
        return true;
    }

    //a general search method to perform binary search by year
    public int search(int year){
        if(this.isSortedByYear()){
            return binarySearch(year);
        }else{
            return linearSearch(year);
        }
    }

    //Additional searches
    //using linear search find the shortest Song and return its index, if no songs return -1
    public int shortestSongIndex(){
        int shortest = Integer.MAX_VALUE;
        int index =-1;
        for(int i = 0; i < playListSize; i++){
            if(this.playList[i].getLengthInSeconds() < shortest){
                shortest = this.playList[i].getLengthInSeconds();
                index = i;
            }
        }
        return index;
    }

    //using linear search find the longest Song and return it
    //if the list contains no songs, return null
    public Song longestSong(){
        int longest = Integer.MIN_VALUE;
        int index =-1;
        for(int i = 0; i < playListSize; i++){
            if(this.playList[i].getLengthInSeconds() > longest){
                longest = this.playList[i].getLengthInSeconds();
                index = i;
            }
        }
        if(index == -1){
            return null;
        }else{
            return this.playList[index];
        }
    }


    public static void main(String[] args) {
//        Song s = new Song ("Never gonna give you up" , "Rick Astley", 1987, 230);
//        Song s2 = new Song ("Never gonna" , "Rick Astley", 1987, 215);
//        Song s3 = new Song ("give you up" , "Rick Astley", 1970, 215);
//        Song s4 = new Song ("give you up" , "Rick Astley", 1989, 190);
//        Song s5 = new Song ("give you up" , "Rick Astley", 1990, 215);
//        Song s6 = new Song ("give you up" , "Rick Astley", 1999, 215);
//
//        //System.out.println(s);
//
//        PlayList pl = new PlayList();
//        pl.add(s);
//        pl.add(s2);
//        pl.add(s3);
//
//        System.out.println(pl);
//
//        pl.move(1,2);
//        System.out.println(pl);
//
//        pl.move(2,0);
//        System.out.println(pl);
//
//        pl.add(s4);
//        pl.add(s5);
//        pl.add(s6);
//        System.out.println(pl);
//
//
//        System.out.println(pl.search(2030));
//        System.out.println(pl.longestsong());
//        PlayList pl2 = new PlayList();
//        System.out.println(pl2.longestsong());

        PlayList pl1 = new PlayList();
        pl1.add(new Song("Rapper's Delight", "Sugarhill Gang", 1979, 427));
        pl1.add(new Song("Never Gonna Give You Up", "Rick Astley", 1987,215));
        System.out.println(pl1);
        System.out.println(pl1.search(1979) + " - first index for 1979 (should be 0)");
        System.out.println("Index of shortest song, should be 1: "
                + pl1.shortestSongIndex());
        System.out.println();
        pl1.move(1, 0);

        System.out.println(pl1);
        System.out.println(pl1.search(1979) + " - first index for 1979 (should be 1)");
        System.out.println("Index of shortest song, should be 0: "
                + pl1.shortestSongIndex());
        System.out.println("Title of longest song (should be Rapper's Delight): " +
                pl1.longestSong().getTitle());
        System.out.println();
        PlayList pl2 = new PlayList();
        System.out.println(pl2);
        System.out.println(pl2.search(1979) + " - first index for 1979 (should be -1)");
        System.out.println("Index of shortest song, should be -1: "
                + pl2.shortestSongIndex());
        System.out.println("Longest song (should be null): " +
                pl2.longestSong());
    }
}
