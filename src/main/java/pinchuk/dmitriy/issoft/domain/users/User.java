package pinchuk.dmitriy.issoft.domain.users;

import java.util.UUID;

public abstract class User {

    private String id;
    private final String username;
    private String firstName;
    private String lastName;
    private int age;

    protected User(String username) {

        if(username == null) {
            throw new IllegalArgumentException("User cannot be without username");
        }

        this.id = UUID.randomUUID().toString();
        this.username = username;

    }

    protected User(String username, String firstName, String lastName) {

        if(username == null) {
            throw new IllegalArgumentException("User cannot be without username");
        }

        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
