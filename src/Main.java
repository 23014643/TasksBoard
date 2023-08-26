import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Login loginSystem = new Login();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();
                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();
                String registrationResult = loginSystem.registerUser(username, password, firstName, lastName);
                System.out.println(registrationResult);
            } else if (choice.equals("2")) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                String loginResult = loginSystem.loginUser(username, password);
                System.out.println(loginResult);
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}