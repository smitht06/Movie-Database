public class MovieList {
    private Movie head;
    private Movie tail;
    public MovieList(){
        head = tail = null;
    }

    public MovieList(Movie head, Movie tail) {
        this.head = head;
        this.tail = tail;
    }

    public void addMovie(Movie movie){
        if(head == null){
            head = movie;
            tail = head;
            movie.setIndex(0);
        }else {
            movie.setIndex(tail.getIndex()+1);
            tail.setNext(movie);
            tail = movie;
        }
    }

    public Movie getHead() {
        return head;
    }

    public Movie getTail() {
        return tail;
    }



}
