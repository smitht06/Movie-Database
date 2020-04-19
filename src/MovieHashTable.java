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

    public int stringHash(String movieTitle){
        int stringHash = 5831;
        int [] charArray = new int[movieTitle.length()];
        for(int i = 0; i < movieTitle.length(); i++){
            charArray[i] = (int) movieTitle.charAt(i);
            stringHash = (5831 * 33) + charArray[i];
        }
        return stringHash;
    }


    public int stringHash(Movie movie){
        int stringHash = 5831;
        String movieTitle = movie.getMovieTitle();
        int [] charArray = new int[movieTitle.length()];
        for(int i = 0; i < movie.getMovieTitle().length(); i++){
            charArray[i] = (int) movieTitle.charAt(i);
            stringHash = (5831 * 33) + charArray[i];
        }
        return stringHash;
        }

    public void addMovie(Movie movie){
        int stringHash = stringHash(movie);
        movieDatabase[stringHash % movieDatabase.length].addMovie(movie);
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
        int stringHash = stringHash(title);
        movieDatabase[stringHash].searchListByTitle(title);
    }

    public void readFile(String fileName){
        File file = new File(fileName);
        try {
            Scanner scan = new Scanner(file);
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
        for(int i = 0; i < movieDatabase.length; i++){
            if(movieDatabase[i].getHead() != null){
                newMovieDatabase[stringHash(movieDatabase[i].getHead()) % newMovieDatabase.length] = movieDatabase[i];
        }
        }
        this.movieDatabase = newMovieDatabase;
    }

    public void getDatabaseSize(){
        System.out.println(this.movieDatabase.length);
    }
}
