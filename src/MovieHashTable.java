import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    public void printDatabase(){
        for(MovieList movieList : movieDatabase){
            movieList.printList();
        }
    }

    public void searchMovieByTitle(String title){
        for (int i = 0; i < movieDatabase.length; i++){
            movieDatabase[i].searchListByTitle(title);
        }
    }
    public void readFile(String fileName){
        File file = new File(fileName);
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String [] line = scan.nextLine().split(",");
                Movie movie = new Movie(line[0],line[1],line[2]);
                addMovie(movie);
            }
        }catch(FileNotFoundException e){
            System.out.println("Check file name, file not found");
        }
    }

    public void doubleSize(){
        MovieList [] newMovieDatabase = new MovieList[movieDatabase.length * 2];
        for(int i = 0; i < newMovieDatabase.length; i++){
            newMovieDatabase[i] = new MovieList();
        }
        for(int i = 0; i < movieDatabase.length; i++){
            newMovieDatabase[i] = movieDatabase[i];
        }
        this.movieDatabase = newMovieDatabase;
    }

    public void getDatabaseSize(){
        System.out.println(this.movieDatabase.length);
    }
}
