import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * 
 * This class allows a single User to manipulate and access students 
 * in the gradebook. There are multiple methods that allow the driver 
 * to run smoothly and effectively.
 * 
 * @author Shaurya Bansal 
 * @version 1/4/2026
 */


public class Driver {

    private static GradebookManager manager = new GradebookManager(); // Manager object that maniupulates students
    private static Scanner input = new Scanner(System.in); // Scanner for user input

    
    public static void main(String[] args) {

        // Welcome message 
        welcomeMessage();
        System.out.println("Select an option 0-10");


        // Main loop that runs the application
        boolean running = true; 
        while (running) {
            displayMenu();
            int selection = input.nextInt();

            switch(selection) {
                case 0: 
                    System.out.println("Save before exiting? (y or n): ");
                    input.nextLine();
                    if (input.nextLine().equalsIgnoreCase("y")) {
                        saveToFile();
                    }
                    System.out.println("Thank you for using the Gradebook Manager!");
                    running = false;
                    break;
                case 1: 
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    findStudentByID();
                    break;
                case 4:
                    findStudentByName();
                    break;
                case 5:
                    displayAllStudents();
                    break;
                case 6:
                    sortByName();
                    break;
                case 7:
                    sortByGrade();
                    break;
                case 8:
                    viewStatistics();
                    break;
                case 9:
                    saveToFile();
                    break;
                case 10:
                    loadFromFile();
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    
            }

            System.out.println();
        }

        input.close();

    }

    // Basic welcome message to welcome the User 
    private static void welcomeMessage() {
        System.out.println("Greetings User!");
        System.out.print("Please put down your full name on one line.");
        System.out.println();
        String fullName = input.nextLine();
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.println("Welcome, " + fullName + "!");
    }

    // Basic main menu that displays to the User via console
    private static void displayMenu() {
        System.out.println("=============== GRADEBOOK MANAGER ===============");
        System.out.println("1. Add a student");
        System.out.println("2. Remove a student");
        System.out.println("3. Find student by ID");
        System.out.println("4. Find student by name");
        System.out.println("5. Display all students");
        System.out.println("6. Sort students by name");
        System.out.println("7. Sort students by grade");
        System.out.println("8. View class statistics");
        System.out.println("9. Save to file");
        System.out.println("10. Load from file");
        System.out.println("0. Exit");
        System.out.println("=================================================");
    }

    // This method will allow the User to add a student to the gradebook
    private static void addStudent() {
        input.nextLine();
        System.out.println("\n--- Add Student ---");

        System.out.println("Enter first name: ");
        String firstName = input.nextLine();

        System.out.println("Enter last name: ");
        String lastName = input.nextLine();

        // Experimenting with generating random Student ID's
        long max = 999_999_999L;
        long min = 100_000_000L;

        Random random = new Random();
        long studentID = min + (long)(random.nextDouble() * (max - min));

        ArrayList<Double> scores = new ArrayList<>();
        System.out.println("Enter scores separated by spaces(or press Enter to skip): ");
        String scoresInput = input.nextLine();

        if (!scoresInput.trim().isEmpty()) {
            String[] scoreStrings = scoresInput.trim().split("\\s+");
            for (String score : scoreStrings) {
                try {
                    scores.add(Double.parseDouble(score));

                } catch (NumberFormatException e) {
                    System.out.println("Invalid score: " + score + " (skipped)");
                }
            }
        }

        // Try catch to see if student is valid
        try {
            Student student = new Student(firstName, lastName, studentID, scores);
            manager.addStudent(student);
            System.out.println("Student added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method that displays current Students and asks user which to remove from list
    private static void removeStudent() {
        System.out.println("\n--- Remove Student ---");
        System.out.println("Enter a Student ID: ");
        long studentID = input.nextLong();

        Student student = manager.findStudentbyID(studentID);
        if (student != null) {
            manager.removeStudent(student);
            System.out.println("Student removed: " + student.getFirstName() + " " + student.getLastName());
        } else {
            System.out.println("Student not found.");
        }
    }

    // This method searches for a Student based on input of ID
    private static void findStudentByID() {
        input.nextLine();

        if (manager.getTotalStudents() == 0) {
            System.out.println("There are no students in the gradebook.");
            for (int i = 0; i < 5; i++) {
                System.out.println();
            }
            return;
        }
        System.out.println("\n--- Search Student by ID ---");

        System.out.println("Enter a Student ID");
        long studentID = input.nextLong();

        Student student = manager.findStudentbyID(studentID);
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
        if (student != null) {
            System.out.println("Student found: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Student ID: " + student.getStudentID());
            System.out.println("Class Average: " + student.getAverage());
        } else {
            System.out.println("Student not found.");
        }
    }

    // This method searches for a Student based on input of first and last name
    private static void findStudentByName() {
        input.nextLine();

        if (manager.getTotalStudents() == 0) {
            System.out.println("There are no students in the gradebook.");
            for (int i = 0; i < 5; i++) {
                System.out.println();
            }
            return;
        }

        System.out.println("\n--- Search Student by Name ---");

        System.out.println("Enter a Student's first name: ");
        String firstName = input.nextLine();
        System.out.println("Enter Student last name: ");
        String lastName = input.nextLine();

        Student student = manager.findStudentByName(firstName, lastName);
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
        if (student != null) {
            System.out.println("Student found: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Student ID: " + student.getStudentID());
            System.out.println("Class Average: " + student.getAverage());
        } else {
            System.out.println("Student not found.");
        }
    }

    // This method displays all students inside the gradebook database
    private static void displayAllStudents() {
        System.out.println("\n--- All Students ---");
        ArrayList<Student> students = manager.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students currently in the gradebook.");
            return;
        }

        // This displays the students in the specific format
        System.out.printf("%-12s %-15s %-15s %-10s%n", "ID", "First Name", "Last Name", "Average");
        System.out.println("--------------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-12d %-15s %-15s %10.2f%n", 
            s.getStudentID(), s.getFirstName(), s.getLastName(), s.getAverage());
        }

    }

    // This method sorts the list of Students by their name and prints it to the console
    private static void sortByName() {
        ArrayList<Student> studentList = manager.getAllStudents();
        if (studentList.size() == 0) {
            System.out.println("There are no students available!");
        }

        manager.sortByFirstName();
        for (Student s : studentList) {
            System.out.println(s.getFirstName());
        }
    }

    // This method sorts the list of Students by their grade average and prints it to the console
    private static void sortByGrade() {
        ArrayList<Student> holder = manager.getAllStudents();
        if (holder.size() == 0) {
            System.out.println("There are no students available!");
        }

        manager.sortByGrade();
        for (Student s : holder) {
            System.out.println(s);
        }
    }

    // This method provides the user with class statistics 
    private static void viewStatistics() {
        System.out.println("\n--- Class Statistics ---");
        System.out.println("Total students: " + manager.getTotalStudents());
        System.out.println("Class average: " + String.format("%.2f", manager.getClassAverage()));

        Student topStudent = manager.getTopStudent();
        if (topStudent != null) {
            System.out.println("Top Student: " + topStudent.getFirstName() + " " + topStudent.getLastName() + 
        " (" + String.format("%.2f", topStudent.getAverage()) + ") ");

        }
    }

    // This method allows the user to save to any file of their liking
    private static void saveToFile() {
        input.nextLine();
        System.out.println("\n--- Save to File---");

        System.out.println("Enter file name (default: database.txt): ");
        String fileName = input.nextLine().trim();

        if (fileName.isEmpty()) {
            fileName = "Database.txt";
        }

        try {
            manager.saveToFile(fileName);
            System.out.println("Gradebook saved to " + fileName + ".");
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // This method can load data from a user input file
    private static void loadFromFile() {
        input.nextLine();
        System.out.println("\n--- Load from File ---");

        System.out.println("Enter file name (default: database.txt): ");
        String fileName = input.nextLine().trim();

        if (fileName.isEmpty()) {
            fileName = "database.txt";
        }

        manager.loadFromFile(fileName);
        System.out.println("Loaded " + manager.getTotalStudents() + " students.");

    }

}
