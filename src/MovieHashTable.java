import org.w3c.dom.ls.LSOutput;

public class MovieHashTable {
    private MovieList[] movieDatabase;

    public MovieHashTable() {
        this.movieDatabase = new MovieList[12];
        for(int i = 0; i < this.movieDatabase.length; i++){
            this.movieDatabase[i] = new MovieList();
        }
    }

    public int stringHash(Movie movie){
        int stringHash = 5831;
        String movieTitle = movie.getMovieTitle();
        int [] charArray = new int[movieTitle.length()];

        for(int i = 0; i < movie.getMovieTitle().length(); i++){
            charArray[i] = (int) movieTitle.charAt(i);
            stringHash = (5831 * 33) + charArray[i];
        }
        return stringHash % movieDatabase.length;
        }

    public void addMovie(Movie movie){
        int stringHash = stringHash(movie);
        movieDatabase[stringHash].addMovie(movie);
    }

    public MovieList[] getMovieDatabase() {
        return movieDatabase;
    }

    public void setMovieDatabase(MovieList[] movieDatabase) {
        this.movieDatabase = movieDatabase;
    }
}
