public class MovieDatabaseProgram {
    public static void main(String []args){
        Movie movie = new Movie("Shaw Shank","Morgan Freeman","Sweet movie about prison");
        Movie movie2 = new Movie("March or the penguins","Morgan Freeman","Sweet movie about prison");
        MovieList movieList1 = new MovieList();
        movieList1.addMovie(movie);
        movieList1.addMovie(movie2);

        System.out.println(movieList1.head.getMovieTitle());
        System.out.println(movieList1.tail.getMovieTitle());
    }
}
