import java.time.LocalDate;

public class Movie {
    private Integer movieId;
    private String title;
    private String genre;
    private LocalDate releaseDate;
    private Integer duration;
    private Integer availableSeats;

    public Movie(String title, String genre, LocalDate releaseDate, Integer duration, Integer availableSeats) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Movie otherMovie = (Movie) obj;
        return movieId == otherMovie.movieId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(movieId);
    }

    public boolean bookSeats(Integer numSeats) {
        if (availableSeats != null && availableSeats >= numSeats) {
            availableSeats -= numSeats;
            return true;
        } else {
            return false;
        }
    }

    public void displayMovieDetails() {
        System.out.println("========================");
        System.out.println("Movie Details ");
        System.out.println("========================");
        System.out.println();
        System.out.println("Movie ID: " + getMovieId());
        System.out.println("Title: " + getTitle());
        System.out.println("Genre: " + getGenre());
        System.out.println("Release Date: " + getReleaseDate());
        System.out.println("Duration: " + getDuration());
        System.out.println("Available seats: " + getAvailableSeats());
        System.out.println();
    }
}
