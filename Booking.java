import java.util.Objects;

public class Booking {
    private int bookingID;
    private String dateAndTime;
    private Movie movieBooked;
    private User user;

    public Booking(int bookingID, String dateAndTime, Movie movieBooked, User user) {
        this.bookingID = bookingID;
        this.dateAndTime = dateAndTime;
        this.movieBooked = movieBooked;
        this.user = user;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Movie getMovieBooked() {
        return movieBooked;
    }

    public void setMovieBooked(Movie movieBooked) {
        this.movieBooked = movieBooked;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Booking otherBooking = (Booking) obj;
        return Objects.equals(getMovieBooked(), otherBooking.getMovieBooked()) &&
                Objects.equals(getUser(), otherBooking.getUser());
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getBookingID());
    }

    public void displayBookingDetails() {
        System.out.println("========================");
        System.out.println("Booking Details ");
        System.out.println("========================");
        System.out.println("Booking ID: " + getBookingID());
        System.out.println("Date and time: " + getDateAndTime());
        Movie bookedMovie = getMovieBooked();
        bookedMovie.displayMovieDetails();

    }


}
