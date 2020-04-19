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

    public void printList(){
        Movie movie = head;
        while (movie != null){
            System.out.println(movie.getMovieTitle());
            System.out.println(movie.getLeadActor());
            System.out.println(movie.getDescription());
            movie = movie.next;
        }

    }
    public Movie searchListByTitle(String data){
        Movie movie = this.head;
        while (movie != null){
            if(data == movie.getMovieTitle()){
                System.out.println(movie.getMovieTitle());
                return movie;
            }else{
                movie = movie.next;
            }
        }
        return null;
    }
}
