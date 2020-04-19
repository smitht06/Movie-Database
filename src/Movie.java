public class Movie {
    private String movieTitle;
    private String leadActor;
    private String description;
    private String yearReleased;
    Movie next;
    Movie prev;
    private int index;

    public Movie(){
    }

    public Movie(String movieTitle, String leadActor, String description, String yearReleased){
        this.next = null;
        this.prev = null;
        this.movieTitle = movieTitle;
        this.leadActor = leadActor;
        this.description = description;
        this.yearReleased = yearReleased;
    }

    public int getIndex() {
        return index;
    }

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
