/*
 * File: MovieList.java
 * Author: Anthony Smith
 * Date: 4/25/2020
 * COP 5416
 * Project 3
 * Purpose: This class creates a movie list that is doubly linked
 * */


public class MovieList {
    //declare variables
    private Movie head;
    private Movie tail;

    //constructor
    public MovieList(){
        head = tail = null;
    }

    //method adds a movie to the list and links it to the previous
    public void addMovie(Movie movie){
        Movie last = head;
        if(head == null){
            head = movie;
            tail = head;
            movie.setPrev(null);
            movie.setIndex(0);
        }else{
            movie.setIndex(tail.getIndex()+1);
            Movie prev = tail;
            tail.setNext(movie);
            tail = movie;
            tail.setPrev(prev);
        }
    }

    //getters and setters
    public Movie getHead() {
        return head;
    }

    public Movie getTail() {
        return tail;
    }

    public void setHead(Movie head) {
        this.head = head;
    }

    public void setTail(Movie tail) {
        this.tail = tail;
    }

    //this method prints the entire list to the console
    public void printList(){
        Movie movie = head;
        while (movie != null){
            System.out.println("Title: " + movie.getMovieTitle());
            System.out.println("Description: " + movie.getDescription());
            System.out.println("Lead Actor: " + movie.getLeadActor());
            System.out.println("Year Released: " + movie.getYearReleased());
            System.out.println("-----------------------------------");
            movie = movie.getNext();
        }
    }

    //this list outputs the size of the list
    public int listSize(){
        Movie movie = head;
        int counter = 0;
        while(movie != null){
            counter ++;
            movie = movie.getNext();
        }
        return counter;
    }

    //this moethod traverses through a list
    public Movie[] traverseList(){
        Movie movie = head;
        Movie [] movieArray = new Movie[listSize()];
        int i =0;
        while (movie != null){
            movieArray[i] = movie;
            i++;
            movie = movie.getNext();
        }
        return movieArray;
    }

    //this methos searches the list for a movie title
    public Movie searchListByTitle(String data){
        Movie movie = this.head;
        while (movie != null){
            if(data.equals(movie.getMovieTitle())){
                System.out.println("Movie found! \nTitle: " + movie.getMovieTitle());
                System.out.println("Description: " + movie.getDescription());
                System.out.println("Lead Actor: " + movie.getLeadActor());
                System.out.println("Year Released: " + movie.getYearReleased());
                System.out.println("-----------------------------------");
                return movie;
            }else{
                movie = movie.getNext();
            }
        }
        return null;
    }

    //this method deletes a movie from the list
    public void deleteMovie(Movie movie) {
        try {
            //if the movie is the head and there is more than 1 movie in the list make the next movie the head
            if (movie.getNext() != null && movie == head) {
                setHead(movie.getNext());
            //if the movie is not the head and not the tail connect the previous to the next
            }else if (movie != head && movie != tail){
                movie.getPrev().setNext(movie.getNext());
                movie.getNext().setPrev(movie.getPrev());
            //if its the only one in the list set the head to null
            }else if(movie.getNext() == null && movie.getPrev() == null){
                setHead(null);
            //if at the end of the list set the previous movie's next as null
            }else{
                movie.getPrev().setNext(null);
            }
        } catch (NullPointerException e) {
            System.out.println("movie not found");
        }
    }
}
