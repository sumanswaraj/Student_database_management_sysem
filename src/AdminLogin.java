import java.util.Scanner;
import java.io.*;

public class AdminLogin {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        // Prompt the admin for login credentials
        System.out.print("Enter admin login id: ");
        String adminId = input.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = input.nextLine();

        // Check if the admin login credentials are valid
        if (isValidAdmin(adminId, adminPassword)) {
            System.out.println("Login successful!\n");

            // Prompt the admin to choose an option
            System.out.println("Choose an option:");
            System.out.println("1. View existing student data");
            System.out.println("2. Add new admission");
            System.out.println("3. View  student's Fee Details");


            int choice = input.nextInt();
            input.nextLine(); // consume the remaining new line character

            switch (choice) {
                case 1:
                    AdminPage_view_and_edit studentObject = new AdminPage_view_and_edit();
                    studentObject.viewStudent();
                    break;
                case 2:
                    new_Student newStudentObject = new new_Student();
                    newStudentObject.addStudent();
                    break;
                case 3:
                    StudentFee StudentFeeObject = new StudentFee();
                    StudentFeeObject.feeDetails();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } else {
            System.out.println("Invalid login credentials");
        }
    }

    // Method to check if the admin login credentials are valid
    public static boolean isValidAdmin(String adminId, String adminPassword) {
        try {
            // Read the admin data file
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\swara\\IdeaProjects\\Student_database_management_sysem\\src\\admin_data.txt"));
            String line = reader.readLine();

            // Loop through the file and check if the admin login credentials are valid
            while (line != null) {
                String[] tokens = line.split(",");
                if (tokens[0].equals(adminId) && tokens[1].equals(adminPassword)) {
                    reader.close();
                    return true;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return false;
    }
}

