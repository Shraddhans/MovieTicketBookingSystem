import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager();
        MovieCatalog movieCatalog = new MovieCatalog();
        while (true) {
            System.out.println("1. Add Movie");
            System.out.println("2. Remove Movie");
            System.out.println("3. Display All Movies");
            System.out.println("4. Add User");
            System.out.println("5. Remove User");
            System.out.println("6. Display All Users");
            System.out.println("7. Book Movie");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Movie Title: ");
                    String title = sc.next();
                    System.out.println("Enter Movie Genre: ");
                    String genre = sc.next();
                    System.out.println("Enter Release Date (yyyy-MM-dd): ");
                    LocalDate releaseDate = LocalDate.parse(sc.next());
                    System.out.println("Enter Movie Duration in minutes: ");
                    int duration = sc.nextInt();
                    System.out.println("Enter Available Seats: ");
                    int availableSeats = sc.nextInt();
                    Movie newMovie = new Movie(title, genre, releaseDate, duration, availableSeats);
                    try {
                        movieCatalog.addMovie(newMovie);
                    } catch (MovieAlreadyExistsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    movieCatalog.removeMovie();
                    break;
                case 3:
                    movieCatalog.displayAllMovie();
                    break;
                case 4:
                    System.out.println("Enter User name: ");
                    String userName = sc.next();
                    System.out.println("Enter email id: ");
                    String email = sc.next();
                    User newUser = new User(userName, email);
                    try {
                        userManager.addUser(newUser);
                    } catch (UserAlreadyExistsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    userManager.removeUser();
                    break;
                case 6:
                    userManager.displayAllUser();
                    break;
                case 7:
                    Set<User> userID = userManager.getUsers();
                    Set<Movie> movieID = movieCatalog.getMovies();
                    if (userID.isEmpty() || movieID.isEmpty()) {
                        System.out.println("User Or Movie Not Added! Please Add User And Movie. ");
                    } else {
                        System.out.println("Enter User ID:");
                        int userId = sc.nextInt();
                        System.out.println("Enter Movie ID:");
                        int movieId = sc.nextInt();
                        System.out.println("Enter Number of Seats:");
                        int numSeats = sc.nextInt();
                        System.out.println("Enter date and time (yyyy-MM-dd HH:mm): ");
                        sc.nextLine();
                        String dateAndTime = sc.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        try {
                            LocalDateTime dateTime = LocalDateTime.parse(dateAndTime, formatter);
                        } catch (Exception e) {
                            System.out.println("Invalid date and time format. Please enter in the format 'yyyy-MM-dd HH:mm'.");
                        }
                        User user = userManager.findUserById(userId);
                        Movie movie = movieCatalog.findMovieById(movieId);
                        user.bookTicket(movie, numSeats, dateAndTime, user);
                    }
                    break;
                case 8:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

}