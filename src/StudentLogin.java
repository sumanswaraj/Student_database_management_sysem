import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class StudentLogin {
    private static final String LOGIN_FILE = "students.txt";
    private static final String DATA_FILE = "student_data.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Login Page");

        boolean isLoggedIn = false;

        // loop until the user successfully logs in or quits the program
        while (!isLoggedIn) {
            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            // check if the username and password are valid
            if (validateLogin(username, password)) {
                isLoggedIn = true;
                System.out.println("Login successful!");
                System.out.println(getStudentData(username)); // display the student's data
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
    }

    private static boolean validateLogin(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\swara\\IdeaProjects\\Student_database_management_sysem\\src\\students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading login file.");
            e.printStackTrace();
        }

        return false;
    }

    private static String getStudentData(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\swara\\IdeaProjects\\Student_database_management_sysem\\src\\student_data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(username)) {
                    return parts[1];
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading data file.");
            e.printStackTrace();
        }

        return "No data found for user " + username;
    }
}
