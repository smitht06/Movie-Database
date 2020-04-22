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
        Movie last = head;
        if(head == null){
            head = movie;
            tail = head;
            movie.setPrev(null);
            movie.setIndex(0);
        }else {
            movie.setIndex(tail.getIndex()+1);
            Movie prev = tail;
            tail.setNext(movie);
            tail = movie;
            tail.setPrev(prev);
        }
    }

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

    public void printList(){
        Movie movie = head;
        while (movie != null){
            System.out.println(movie.getMovieTitle());
            System.out.println(movie.getLeadActor());
            System.out.println(movie.getDescription());
            movie = movie.getNext();
        }
    }

    public int listSize(){
        Movie movie = head;
        int counter = 0;
        while(movie != null){
            counter ++;
            movie = movie.getNext();
        }
        return counter;
    }

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

    public Movie searchListByTitle(String data){
        Movie movie = this.head;
        while (movie != null){
            if(data.equals(movie.getMovieTitle())){
                System.out.println("Movie found! " + movie.getMovieTitle());
                return movie;
            }else{
                movie = movie.getNext();
            }
        }
        return null;
    }

    public void deleteMovie(Movie movie) {
        try {
            if (movie.getNext() != null && movie == head) {
                setHead(movie.getNext());
            }else if (movie != head && movie != tail){
                movie.getPrev().setNext(movie.getNext());
                movie.getNext().setPrev(movie.getPrev());
            }else if(movie.getNext() == null && movie.getPrev() == null){
                setHead(null);
            }else{
                movie.getPrev().setNext(null);
            }
        } catch (NullPointerException e) {
            System.out.println("movie not found");
        }
    }
}
