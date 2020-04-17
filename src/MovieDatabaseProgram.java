public class MovieDatabaseProgram {
    public static void main(String []args){

        Movie movie = new Movie("Shaw Shank","Morgan Freeman","Sweet movie about prison");
        Movie movie2 = new Movie("March of the penguins","Morgan Freeman","Sweet movie about prison");
        MovieList movieList1 = new MovieList();
        movieList1.addMovie(movie);
        movieList1.addMovie(movie2);

        MovieHashTable movies = new MovieHashTable();
        movies.stringHash(movie);
        movies.addMovie(movie);



    }
}
