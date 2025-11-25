import java.util.ArrayList;
import java.util.Collections;

public class GradebookManager {
    private ArrayList<Student> students = new ArrayList<>();
    

    // Finds a student by ID 
    public Student findStudentbyID(long studentID) {
        for (Student s : students) {
            if (s.getStudentID() == studentID) {
                return s;
            }
        }
        return null;
    }

    // Finds a student by name 
    public Student findStudentByName(String firstName, String lastName) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName() == firstName && students.get(i).getLastName() == lastName) {
                return students.get(i);
            }
        }
        // Returning null of no student is found
        return null;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public void sortByFirstName() {
        ArrayList<String> sortedName = new ArrayList<>();
        for (Student s : students) {
            sortedName.add(s.getFirstName());
        }
        Collections.sort(sortedName);
    }

    public void sortByGrade() {

    }

    // Returns class average for each student in the class list 
    public double getClassAverage() {
        int totalScores = 0;
        int scoreCount = 0;

        for (Student s : students) {
            for (double score : s.getScores()) {
                totalScores += score;
                scoreCount++;
            }
        }

        if (scoreCount == 0) {
            return 0.0;
        }

        return (double) totalScores / scoreCount;
    }

    // Returns the top student based on highest score in class 
    public Student getTopStudent() {
        if (students.isEmpty()) {
            return null;
        }

        Student topStudent = students.get(0);
        double highestAverage = topStudent.getAverage();

        for (Student s : students) {
            double currentAverage = s.getAverage();
            if (currentAverage > highestAverage) {
                highestAverage = currentAverage;
                topStudent = s;
            }
        }

        return topStudent;
    }

    public int getTotalStudents() {
        int counter = 0;
        for (int i = 0; i < students.size(); i++) {
            counter++;
        }
        return counter;
    }
    
    public void printAllStudents() {
        System.out.println(students);
    }

}
