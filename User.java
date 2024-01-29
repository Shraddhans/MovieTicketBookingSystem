import java.util.*;

public class User {
    private int userID;
    private String userName;
    private String email;
    private Set<Booking> bookedMovies;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
        this.bookedMovies = new HashSet<Booking>();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Booking> getBookedMovies() {
        return bookedMovies;
    }

    public void setBookedMovies(Set<Booking> bookedMovies) {
        this.bookedMovies = bookedMovies;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getUserID());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User otherUser = (User) obj;
        return getUserID() == otherUser.getUserID();
    }

    public void bookTicket(Movie movie, int numberOfSeats, String dateAndTime, User user) {
        boolean enoughSeatsAvailable = movie.bookSeats(numberOfSeats);
        if (enoughSeatsAvailable) {
            int bookingID = generateBookingID();
            Booking bookings = new Booking(bookingID, dateAndTime, movie, user);
            bookedMovies.add(bookings);
            System.out.println("Booking successful! ");
        } else {
            System.out.println("Sorry, not enough seats available for booking.");
        }
    }

    public int generateBookingID() {
        Random random = new Random();
        return random.nextInt(1000);
    }

    public void userDetails() {
        System.out.println("========================");
        System.out.println("User Details ");
        System.out.println("========================");
        System.out.println("User ID: " + getUserID());
        System.out.println("User name: " + getUserName());
        System.out.println("Email: " + getEmail());
        if (bookedMovies != null && !bookedMovies.isEmpty()) {
            bookedMovies.forEach(Booking::displayBookingDetails);
        } else {
            System.out.println("Booked Movie: No Booking for this User ");
        }
        System.out.println();
    }
}
