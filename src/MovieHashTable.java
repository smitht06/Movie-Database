import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MovieHashTable {
    private MovieList[] movieDatabase;
    private double numberOfMovies = 0;
    DecimalFormat df = new DecimalFormat(".##");

    public MovieHashTable() {
        this.movieDatabase = new MovieList[12];
        for(int i = 0; i < this.movieDatabase.length; i++){
            this.movieDatabase[i] = new MovieList();
        }
    }

    public int stringHash(String movieTitle){
        int stringHash = 5831;
        int [] charArray = new int[movieTitle.length()];
        for(int i = 0; i < movieTitle.length(); i++){
            charArray[i] = (int) movieTitle.charAt(i);
            stringHash = (5831 * 33) + charArray[i];
        }
        return stringHash;
    }

    public int stringHashMod(String movieTitle){
        return stringHash(movieTitle) % movieDatabase.length;
    }

    public void addMovie(Movie movie){
        int stringHash = stringHashMod(movie.getMovieTitle());
        movieDatabase[stringHash].addMovie(movie);
        numberOfMovies++;
        double loadFactor = numberOfMovies / movieDatabase.length;
        if(loadFactor > .5){
            System.out.println("Load factor = " + df.format(loadFactor) + " doubling size...");
            doubleSize();
        }
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
        int stringHash = stringHashMod(title);
        movieDatabase[stringHash].searchListByTitle(title);
    }

    public void readFile(String fileName){
        File file = new File(fileName);
        try {
            Scanner scan = new Scanner(file);
            System.out.println("File successfully added!");
            while(scan.hasNextLine()){
                String [] line = scan.nextLine().split(",");
                Movie movie = new Movie(line[0], line[1], line[2], line[3]);
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
        for (int i = 0; i < movieDatabase.length; i++) {
                Movie[] listArray = movieDatabase[i].traverseList();
                for(Movie movie : listArray){
                    int newAddress = stringHash(movie.getMovieTitle()) % newMovieDatabase.length;
                    newMovieDatabase[newAddress].addMovie(movie);
                }
        }
        this.movieDatabase = newMovieDatabase;
    }

    public void getDatabaseSize(){
        System.out.println(this.movieDatabase.length);
    }

    public void deleteMovie(String movie){
        MovieList location = movieDatabase[stringHashMod(movie)];
        Movie delete = location.searchListByTitle(movie);
        location.deleteMovie(delete);
        System.out.println("Movie deleted");
    }
}
