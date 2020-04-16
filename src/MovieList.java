public class MovieList {
    Movie head;
    Movie tail;

    public MovieList(){
        head = tail = null;
    }

    public void addMovie(Movie movie){
        if(head == null){
            head = movie;
            tail = head;
        }else {
            tail.setNext(movie);
            tail = movie;
        }
    }
}
