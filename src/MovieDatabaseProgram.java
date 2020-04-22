import java.util.Scanner;

public class MovieDatabaseProgram {
    public static void main(String []args){
        MovieHashTable movies = new MovieHashTable();
        runProgram(movies);
    }

    public static void menu(){
        System.out.println("Welcome to the Movie Database");
        System.out.println("---------Make a Choice--------");
        System.out.println("Read database file (1)");
        System.out.println("Add a new movie (2)");
        System.out.println("Search for a movie by title(3)");
        System.out.println("Delete a movie (4)");
        System.out.println("Print Database (5)");
        System.out.println("Exit (-1)");
    }

    public static void runProgram(MovieHashTable movies){
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
            while (choice != -1){
            menu();
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter file name");
                    movies.readFile(scan2.nextLine());
                    break;
                case 2:
                    System.out.println("Enter movie title");
                    String movieTitle = scan2.nextLine();
                    System.out.println("Enter the lead actor/actress' name: ");
                    String lead = scan2.nextLine();
                    System.out.println("Enter a description: ");
                    String description = scan2.nextLine();
                    System.out.println("Enter the year the movie came out: ");
                    String year = scan2.nextLine();
                    movies.addMovie(new Movie(movieTitle,lead,description,year));
                    System.out.println("Movie added!");
                    break;
                case 3:
                    System.out.println("Enter the title of the movie you want to search");
                    String movieSearch = scan2.nextLine();
                    movies.searchMovieByTitle(movieSearch);
                    break;
                case 4:
                    System.out.println("Enter the name of the movie you want to delete");
                    String movieDelete = scan2.nextLine();
                    movies.deleteMovie(movieDelete);
                    break;
                case 5:
                    int i = 0;
                    for(MovieList movies432 : movies.getMovieDatabase()){
                        System.out.println(i++);
                        movies432.printList();
                        }
                    break;
            }
        }
    }


}
