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
 * @version 12/19/2025
 */


public class Driver {

    private static GradebookManager manager = new GradebookManager();
    private static Scanner input = new Scanner(System.in);
    private static String username;

    
    public static void main(String[] args) {

        welcomeMessage();

        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
        System.out.println("Select an option 0-10");

        boolean running = true; 
        while (running) {
            displayMenu();
        int selection = input.nextInt();

        switch(selection) {
            case 0: 
                running = false;
                System.out.println("Thank you for using the Gradebook Manager!");
                break;
            case 1: 
                addStudent();
            case 2:
            case 3:
            case 4:
            case 5:
                displayAllStudents();
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
        }

        }

    }

    // Basic welcome message to welcome the User 
    private static void welcomeMessage() {
        System.out.println("Greetings User!");
        System.out.print("Please put down your full name on one line.");
        username = input.nextLine();
        System.out.println("Welcome " + username + "!");
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
        System.out.println("========================================");
    }

    // This method will allow the User to add a student to the gradebook
    private static void addStudent() {
        System.out.println("Enter first name:");
        String firstName = input.nextLine();

        System.out.println("Enter last name");
        String lastName = input.nextLine();

        // Experimenting with generating random Student ID's
        long max = 100_000_000_000L;
        long min = 100_000_000L;

        Random random = new Random();

        long studentID = min + (long)(random.nextDouble() * (max - min));

        ArrayList<Double> scores = new ArrayList<>();
        System.out.println("Enter scores of the student(click enter if " + 
        "no scores need to be added):");

        while (input.hasNextDouble()) {
            scores.add(input.nextDouble());
        }

        // Try catch to see if student is valid
        try {
            Student student = new Student(firstName, lastName, studentID, scores);
            manager.addStudent(student);
            System.out.println("Student added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e);
        }
    }

    private static void removeStudent() {
        System.out.println();
    }

    private static void findStudentByID() {

    }

    private static void findStudentByName() {

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

    private static void sortByName() {

    }

    private static void sortByGrade() {

    }

    private static void viewStatistics() {
        
    }

}
