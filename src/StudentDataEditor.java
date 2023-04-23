import java.io.*;
import java.util.Scanner;

public class StudentDataEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the user ID of the student to edit: ");
        String userId = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\swara\\IdeaProjects\\Student_database_management_sysem\\student_data.txt"));
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(userId)) {
                    found = true;
                    System.out.println("What data do you want to edit?");
                    System.out.println("1. Name");
                    System.out.println("2. Contact Information");
                    System.out.println("3. Address");
                    System.out.println("4. Admission Year");
                    System.out.println("5. Courses");
                    System.out.println("6. Attendance File");
                    System.out.println("7. Fee File");
                    System.out.println("8. Scholarship File");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character

                    String newData;
                    switch (choice) {
                        case 1:
                            System.out.print("Enter the new name: ");
                            newData = scanner.nextLine();
                            data[1] = newData;
                            break;
                        case 2:
                            System.out.print("Enter the new contact information: ");
                            newData = scanner.nextLine();
                            data[2] = newData;
                            break;
                        case 3:
                            System.out.print("Enter the new address: ");
                            newData = scanner.nextLine();
                            data[3] = newData;
                            break;
                        case 4:
                            System.out.print("Enter the new admission year: ");
                            newData = scanner.nextLine();
                            data[4] = newData;
                            break;
                        case 5:
                            System.out.print("Enter the new courses: ");
                            newData = scanner.nextLine();
                            data[5] = newData;
                            break;
                        case 6:
                            System.out.print("Enter the new attendance file: ");
                            newData = scanner.nextLine();
                            data[6] = newData;
                            break;
                        case 7:
                            System.out.print("Enter the new fee : ");
                            newData = scanner.nextLine();
                            data[7] = newData;
                            break;
                        case 8:
                            System.out.print("Enter the new scholarship file: ");
                            newData = scanner.nextLine();
                            data[8] = newData;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }

                    // write the updated data to the file
                    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\swara\\IdeaProjects\\Student_database_management_sysem\\student_data.txt", true));
                    writer.write(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8]);
                    writer.newLine();
                    writer.close();

                    System.out.println("Data updated successfully.");
                    break;
                }
            }
            reader.close();

            if (!found) {
                System.out.println("Student with user ID " + userId + " not found.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
