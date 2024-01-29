import java.util.*;

public class UserManager {
    Scanner sc = new Scanner(System.in);
    private Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) throws UserAlreadyExistsException {
        if (users.stream().anyMatch(existingUser -> existingUser.getEmail().equals(user.getEmail()))) {
            throw new UserAlreadyExistsException("User with email ID already exists: ");
        } else {
            int userID = generateRandomUserID();
            user.setUserID(userID);
            users.add(user);
            System.out.println("User added successfully: ");
        }
    }

    public int generateRandomUserID() {
        Random random = new Random();
        return random.nextInt(1000);
    }

    public void removeUser() {
        if (users.isEmpty()) {
            System.out.println("User not Added! ");
        } else {
            System.out.println("Enter User ID to remove: ");
            int userIDToRemove = sc.nextInt();
            users.removeIf(user -> user.getUserID() == userIDToRemove);
            System.out.println("User Removed Successfully! ");
        }
    }

    public void displayAllUser() {
        users.stream()
                .findFirst()
                .ifPresentOrElse(
                        user -> users.forEach(User::userDetails),
                        () -> System.out.println("No User available! Please Add User By Selecting Option 4. ")
                );
    }

    public User findUserById(int userId) {
        return users.stream()
                .filter(user -> user.getUserID() == userId)
                .findFirst()
                .orElse(null);
    }
}
