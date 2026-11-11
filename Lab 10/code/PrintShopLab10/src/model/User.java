package model;

/**
 * A Print Shop user (Lab 7). Student and StaffMember are not needed in Lab 10.
 */
public class User {
    private final String userId;
    private final String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
