import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


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
        return students.size(); // Much simpler rather than iterating through the list
        // int counter = 0;
        // // Traversing each student in the list
        // for (int i = 0; i < students.size(); i++) {
        //     counter++;
        // }
        // return counter;
    }
    
    // Prints out all the students from the ArrayList
    public void printAllStudents() {
        System.out.println(students);
    }

    // Writes student objects to a file in a specific format
    public void saveToFile(String fileName) throws IOException {
        File f = new File(fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f));){
            for (Student s : students) {

                // Format of File: FirstName, LastName, ID, Scores(1|2|3|4)
                String holder = " ";
                for (int i = 0; i < s.getScores().size(); i++) {
                    holder += Double.toString(s.getScores().get(i)) + " | ";
                }
                writer.write(s.getFirstName() + ", " + s.getLastName() + ", " 
                + s.getStudentID() + ", " + "Scores: " + holder);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // Reads student data from a file 
    public void loadFromFile(String fileName) {
        File f = new File(fileName);

        if (!f.exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(f));) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Separates each part into the array based on Student info format 
                String[] parts = line.split(",");

                if (parts.length < 3) continue; // This will skip any invalid lines when reading

                String firstName = parts[0].trim();
                String lastName = parts[1].trim();
                long studentID = Long.parseLong(parts[2].trim());

                //. Getting each score from the third element of parts 
                // This ArrayList is added as the scores of a student
                ArrayList<Double> scoresList = new ArrayList<>();
                if (parts.length > 3 && !parts[3].isEmpty()) {
                    String scoresStr = parts[3].replace("Scores: ", "").trim();
                    String[] scores =  scoresStr.split("\\|");
                    for (String score : scores) {
                        String trimmed = score.trim();
                        if (!trimmed.isEmpty()) {
                            scoresList.add(Double.parseDouble(trimmed));
                        }
                    }
                }

                students.add(new Student(firstName, lastName, studentID, scoresList));
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
