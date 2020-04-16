public class MovieList {
    Node head;
    Node tail;

    public MovieList(){
        head = tail = null;
    }

    public void addMovie(Node movie){
        if(head == null){
            head = movie;
            tail = head;
        }else {
            tail.setNext(movie);
            tail = movie;
        }
    }
}
