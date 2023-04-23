import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdminPage_view_and_edit {
    public void viewStudent() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Admin Page!");

        // Ask the admin to enter the student's user id
        System.out.print("Enter student's user id: ");
        String userId = scanner.nextLine();

        // Read the student data from the file
        String line;
        boolean studentFound = false;
        BufferedReader reader = new BufferedReader(new FileReader("student_data.txt"));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].equals(userId)) {
                studentFound = true;
                System.out.println("Student's Details:");
                System.out.println("Name: " + parts[1]);
                System.out.println("Course: " + parts[2]);
                System.out.println("CGPA: " + parts[3]);
                System.out.println("Batch: " + parts[4]);
                System.out.println("Address: " + parts[5]);
                System.out.println("Contact Details: " + parts[6]);


                System.out.print("Do you want to edit the student's data? (y/n) ");
                String choice = scanner.nextLine().toLowerCase();

                if (choice.equals("y")) {
                    System.out.println("Enter the updated details:");

                    // Ask for updated student data
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Course: ");
                    String studentClass = scanner.nextLine();

                    System.out.print("CGPA: ");
                    String marks = scanner.nextLine();

                    System.out.print("Batch: ");
                    String timetable = scanner.nextLine();

                    System.out.print("Address: ");
                    String address = scanner.nextLine();

                    System.out.print("Contact Details: ");
                    String contactDetails = scanner.nextLine();

                    // Update the student data in the file
                    StringBuilder sb = new StringBuilder();
                    sb.append(userId).append(",")
                            .append(name).append(",")
                            .append(studentClass).append(",")
                            .append(marks).append(",")
                            .append(timetable).append(",")
                            .append(address).append(",")
                            .append(contactDetails);

                    String updatedData = sb.toString();
                    String fileContent = "";

                    BufferedReader fileReader = new BufferedReader(new FileReader("student_data.txt"));
                    while ((line = fileReader.readLine()) != null) {
                        String[] parts1 = line.split(",");
                        if (parts1[0].equals(userId)) {
                            fileContent += updatedData + "\n";
                        } else {
                            fileContent += line + "\n";
                        }
                    }

                    // Write the updated student data back to the file
                    FileWriter fileWriter = new FileWriter("student_data.txt");
                    fileWriter.write(fileContent);
                    fileWriter.close();

                    System.out.println("Student's data has been updated.");
                }
                else {
                    System.out.println("Student's data has not been updated.");
                }

                break;
            }
        }
        reader.close();

        if (!studentFound) {
            System.out.println("Student not found!");
        }
    }
}
