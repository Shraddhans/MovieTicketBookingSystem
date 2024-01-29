import java.util.*;

public class MovieCatalog {
    Scanner sc = new Scanner(System.in);
    public Set<Movie> movies = new HashSet<>();

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) throws MovieAlreadyExistsException {
        if (movies.stream().anyMatch(existingMovie -> existingMovie.getTitle().equals(movie.getTitle()))) {
            throw new MovieAlreadyExistsException("Movie with same name already exists: ");
        } else {
            int movieID = generateRandomMovieID();
            movie.setMovieId(movieID);
            movies.add(movie);
            System.out.println("Movie added successfully");
        }
    }

    private int generateRandomMovieID() {
        Random random = new Random();
        return random.nextInt(1000);
    }

    public void removeMovie() {
        if (movies.isEmpty())
            System.out.println("Movie Not Added. ");
        else {
            System.out.println("Enter Movie ID to remove: ");
            int movieIDToRemove = sc.nextInt();
            movies.removeIf(movie -> movie.getMovieId() == movieIDToRemove);
            System.out.println("Movie Removed Successfully: ");
        }
    }

    public void displayAllMovie() {
        movies.stream()
                .findFirst()
                .ifPresentOrElse(movie -> movies.forEach(Movie::displayMovieDetails),
                        () -> System.out.println("No Movies Available! Please Add Movie By Selecting Option 1: ")
                );
    }

    public Movie findMovieById(int movieId) {
        return movies.stream()
                .filter(movie -> movie.getMovieId() == movieId)
                .findFirst()
                .orElse(null);
    }

}
