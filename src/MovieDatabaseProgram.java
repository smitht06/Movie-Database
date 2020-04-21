import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieDatabaseProgram {
    public static void main(String []args){

        Movie movie = new Movie("Shaw Shank","Morgan Freeman","Sweet movie about prison","1995");
        Movie movie2 = new Movie("March of the penguins","Morgan Freeman","Sweet movie about prison","2006");
        Movie movie3 = new Movie("nutha","Morgan Freeman","Sweet movie about prison","2006");

        MovieHashTable movies = new MovieHashTable();

        movies.addMovie(movie);
        movies.addMovie(movie2);
        movies.addMovie(movie3);



        //movies.printDatabase();


//
//        movies.doubleSize();
//        movies.getDatabaseSize();
//        movies.printDatabase();
        movies.readFile("movies.txt");

        //movies.printDatabase();

       //System.out.println(movies.getMovieDatabase()[4].getHead().getMovieTitle());
        //movies.printDatabase();
//        int i = 0;
//        for(MovieList movies432 : movies.getMovieDatabase()){
//            System.out.println(i++);
//            movies432.printList();
//        }
////        Scanner scan =  new Scanner(System.in);
////        String moviesearch = scan.nextLine();
////        movies.searchMovieByTitle(moviesearch);
//        System.out.println("\n\n");
//        movies.doubleSize();
//        i = 0;
//        for(MovieList movies432 : movies.getMovieDatabase()){
//            System.out.println(i++);
//            movies432.printList();
//        }

//        movies.searchMovieByTitle("the lion king");
//        System.out.println(movies.getMovieDatabase().length);
//
//        System.out.println(movies.stringHash("March of the penguins") % 24);
//        System.out.println(movies.stringHash("taken") % 24);
        movies.printDatabase();
        System.out.println("\n\n\n");
        movies.deleteMovie(movie2);
        movies.printDatabase();

    }


}
