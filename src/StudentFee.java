import java.util.*;
import java.io.*;

public class StudentFee {
    public void feeDetails() {
        Scanner scanner = new Scanner(System.in);
        String studentId = "";
        String line = "";
        String fileName = "C:\\Users\\swara\\IdeaProjects\\Student_database_management_sysem\\student_data.txt";
        String tempFile = "temp.txt";
        boolean found = false;

        // Get student ID from user
        System.out.print("Enter student ID: ");
        studentId = scanner.nextLine();

        try {
            File file = new File(fileName);
            File temp = new File(tempFile);
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

            // Loop through student data file
            while ((line = br.readLine()) != null) {
                String[] studentInfo = line.split(",");

                // If student ID matches, show current fee and scholarship information
                if (studentInfo[0].equals(studentId)) {
                    System.out.println("Current fee information for student " + studentId + ":");
                    System.out.println("Total fee: " + studentInfo[7]);
                    System.out.println("Amount paid: " + studentInfo[8]);
                    System.out.println("Due amount: " + (Double.parseDouble(studentInfo[7]) - (Double.parseDouble(studentInfo[8]) + Double.parseDouble(studentInfo[10]))));
                    System.out.println("Current scholarship: " + studentInfo[10]);

                    // Ask admin if they want to update fee or scholarship information
                    System.out.println("\nDo you want to update fee or scholarship information? (y/n)");
                    String choice = scanner.nextLine();

                    // If yes, ask for new information and update in temp file
                    if (choice.equalsIgnoreCase("y")) {
                        found = true;
                        System.out.println("\nEnter new fee information:");
                        System.out.print("Total fee: ");
                        String totalFee = scanner.nextLine();
                        System.out.print("Amount paid: ");
                        String amountPaid = scanner.nextLine();

                        System.out.println("\nEnter new scholarship information:");
                        System.out.print("Scholarship name: ");
                        String scholarshipName = scanner.nextLine();
                        System.out.print("Scholarship amount: ");
                        String scholarshipAmount = scanner.nextLine();

                        line = studentInfo[0] + "," + studentInfo[1] + "," + studentInfo[2] + "," + studentInfo[3] + "," + studentInfo[4] + "," + studentInfo[5] +  "," + studentInfo[6] + "," + studentInfo[7] + "," + totalFee + "," + amountPaid + "," + scholarshipName + "," + scholarshipAmount;
                    }
                }
                // Write student information to temp file
                bw.write(line);
                bw.newLine();
            }

            bw.close();
            br.close();

            // Delete original file and rename temp file
            if (found) {
                file.delete();
                temp.renameTo(new File(fileName));
                System.out.println("Fee and scholarship information for student " + studentId + " updated successfully.");
            } else {
                System.out.println("Welcome user.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
