import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GradebookManager {
    private ArrayList<Student> students = new ArrayList<>();
    

    // Finds a student by ID by searching through each student in 
    public Student findStudentbyID(long studentID) {
        // Traversing each student in the list
        for (Student s : students) {
            // Utilizes method of Student class to find match with ID paramter 
            if (s.getStudentID() == studentID) {
                return s;
            }
        }
        // If no results found, the method returns null
        return null;
    }

    // Finds a student by full name 
    public Student findStudentByName(String firstName, String lastName) {
        // Traversing each student in the list
        for (int i = 0; i < students.size(); i++) {
            // Utilizes method of Student class to match paramters of the method
            if (students.get(i).getFirstName().equalsIgnoreCase(firstName) 
                && students.get(i).getLastName().equalsIgnoreCase(lastName)) {
                // Returns the student of the ArrayList 
                return students.get(i);
            }
        }
        // Returning null of no student is found
        return null;
    }

    // Adds student to the ArrayList of students
    public void addStudent(Student s) {
        students.add(s);
    }

    // Removes a specific student from the ArrayList of students
    public void removeStudent(Student s) {
        students.remove(s);
    }

    // Returns all the students in the ArrayList
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    // Sorts students in-place by first name (this is case-insensitive)
    public void sortByFirstName() {
        Collections.sort(students, Comparator.comparing(Student::getFirstName, String.CASE_INSENSITIVE_ORDER));
    }

    // Sorts students in-place by their average score, highest is first
    public void sortByGrade() {
        Collections.sort(students, Comparator.comparing(Student::getAverage).reversed());
    }

    // Returns class average for each student in the class list 
    public double getClassAverage() {
        double totalScores = 0.0;
        int scoreCount = 0;

        // Traversing each student in the list
        for (Student s : students) {
            for (double score : s.getScores()) {
                totalScores += score;
                scoreCount++;
            }
        }

        if (scoreCount == 0) {
            return 0.0;
        }

        return totalScores / scoreCount;
    }

    // Returns the top student based on highest score in class 
    public Student getTopStudent() {
        if (students.isEmpty()) {
            return null;
        }

        Student topStudent = students.get(0);
        double highestAverage = topStudent.getAverage();

        // Traversing each student in the list
        for (Student s : students) {
            double currentAverage = s.getAverage();
            if (currentAverage > highestAverage) {
                highestAverage = currentAverage;
                topStudent = s;
            }
        }

        return topStudent;
    }

    // Gets the total amount of students from the ArrayList of students
    public int getTotalStudents() {
        int counter = 0;
        // Traversing each student in the list
        for (int i = 0; i < students.size(); i++) {
            counter++;
        }
        return counter;
    }
    
    // Prints out all the students from the ArrayList
    public void printAllStudents() {
        System.out.println(students);
    }

}
