import java.util.ArrayList;
import java.util.List;

public class Login {
    private List<User> users;

    public  Login(){
        users = new ArrayList<>();
    }
    public boolean checkUserName(String username){
        return username.contains("_") && username.length() <= 5;
    }
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*")
                && password.matches(".*\\d.*") && password.matches(".*[^\\w\\d].*");
    }
    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure it contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure it meets complexity requirements.";
        }

        User newUser = new User(username, password, firstName, lastName);
        users.add(newUser);
        return "User registered successfully.";
    }
    public String loginUser(String username, String password) {
        for (User user : users) {
            if (user.userName.equals(username) && user.password.equals(password)) {
                return "Welcome " + user.firstName + " " + user.lastName + "! It is great to see you again.";
            }
        }
        return "Username or password incorrect, please try again.";
    }
}
