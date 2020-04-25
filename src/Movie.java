/*
 * File: Movie.java
 * Author: Anthony Smith
 * Date: 4/25/2020
 * COP 5416
 * Project 3
 * Purpose: This class creates a movie or node in the movie list
 * */
public class Movie {
    //declare all global variables
    private String movieTitle;
    private String leadActor;
    private String description;
    private String yearReleased;
    private Movie next;
    private Movie prev;
    private int index;

    //constructor
    public Movie(){
    }

    //default constructor
    public Movie(String movieTitle, String leadActor, String description, String yearReleased){
        this.next = null;
        this.prev = null;
        this.movieTitle = movieTitle;
        this.leadActor = leadActor;
        this.description = description;
        this.yearReleased = yearReleased;
    }

    //index on the movieList
    public int getIndex() {
        return index;
    }

    //getters and setters
    public void setIndex(int index) {
        this.index = index;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(String yearReleased) {
        this.yearReleased = yearReleased;
    }

    public Movie getNext() {
        return next;
    }

    public void setNext(Movie next) {
        this.next = next;
    }

    public Movie getPrev() {
        return prev;
    }

    public void setPrev(Movie prev) {
        this.prev = prev;
    }
}
