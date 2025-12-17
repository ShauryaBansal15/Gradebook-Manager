import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    private static GradebookManager manager = new GradebookManager();
    
    public static void main(String[] args) {


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

}
