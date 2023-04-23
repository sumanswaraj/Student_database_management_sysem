import java.io.*;

public class new_Student {
    public void addStudent(){
     final String STUDENT_DATA_FILE = "student_data.txt";


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileWriter fileWriter = new FileWriter(STUDENT_DATA_FILE, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            System.out.println("Enter the student details:");
            System.out.print("Name: ");
            String name = reader.readLine();
            System.out.print("User ID: ");
            String userId = reader.readLine();
            // Check if the user ID is already present in the file
            if (isUserIdPresent(userId)) {
                System.out.println("User ID already exists. Please enter a unique user ID.");
                return;
            }
            System.out.print("COURSE: ");
            String COURSE = reader.readLine();
            System.out.print("CGPA: ");
            String CGPA = reader.readLine();
            System.out.print("BATCH: ");
            String BATCH = reader.readLine();
            System.out.print("Address: ");
            String address = reader.readLine();
            System.out.print("Contact Number: ");
            String contactNumber = reader.readLine();
            // Create the new student record
            String studentRecord = userId + "," + name + "," + COURSE + ","+ CGPA + ","+ BATCH +"," + address + "," + contactNumber;
            // Append the new student record to the file
            writer.newLine();
            writer.write(studentRecord);
            writer.close();
            System.out.println("New student added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to check if the user ID is already present in the student data file
    private static boolean isUserIdPresent(String userId) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\swara\\IdeaProjects\\Student_database_management_sysem\\student_data.txt"));
        String line = reader.readLine();
        while (line != null) {
            String[] fields = line.split(",");
            if (fields[0].equals(userId)) {
                reader.close();
                return true;
            }
            line = reader.readLine();
        }
        reader.close();
        return false;
    }
}
