public class MovieDatabaseProgram {
    public static void main(String []args){

        Movie movie = new Movie("Shaw Shank","Morgan Freeman","Sweet movie about prison");
        Movie movie2 = new Movie("March of the penguins","Morgan Freeman","Sweet movie about prison");


        MovieHashTable movies = new MovieHashTable();
        movies.stringHash(movie);
        movies.addMovie(movie);
        movies.addMovie(movie2);

        //movies.printDatabase();

        //movies.searchMovieByTitle("Shaw Shank");

        movies.doubleSize();
        movies.getDatabaseSize();
        movies.printDatabase();


    }
}
