import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        // Scanner input = new Scanner(System.in);
        // String firstName = " ";
        // String lastName = " ";
        // ArrayList<Integer> scores = new ArrayList<>();
        // int size = 0;
        // boolean running = true;

        // System.out.println("Welcome to the Gradebook Manager!");

        // do {
        //     try {
        //         System.out.println("Would you like to add or remove a student?(Yes or No)");
        //         String response = input.nextLine();
        //         if (response.equalsIgnoreCase("Yes")) {
        //             System.out.println("What is the first name of your student?");
        //             firstName = input.nextLine();
        //             System.out.println("Thanks! What is the last name of your student?");
        //             lastName = input.nextLine();
        //             System.out.println("Thanks! How many scores are you adding for this student?(0 for none)");
        //         if (input.nextInt() == 0) {
        //             System.out.println("Would you like to add another student?(Yes or No)");
        //             if (response.equalsIgnoreCase("No")) {
        //                 System.out.println("Thank you for using the Gradebook Manager!");
        //                 running = false;
        //             }
        //         } else {

        //             for (int i = 0; i < size)
        //         }

            
        //     } else if (response.equalsIgnoreCase("No")) {
        //         System.out.println("Thank you for using the Gradebook Manager!");
        //         running = false;
        //     }
        // } while (running);
        //     } catch () {

        //     }
        ArrayList<Double> scores = new ArrayList<>();
        Student s1 = new Student("Shaurya", "Bansal", 123456789, scores);

        scores.add(87.0);
        scores.add(62.6);
        scores.add(64.9);
        scores.add(91.2);
        scores.add(93.2);

        System.out.println("Name: " + s1.getFirstName() + " " + s1.getLastName());
        System.out.println("Average: " + s1.getAverage());


    }
}
