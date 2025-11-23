import java.util.ArrayList;

public class GradebookManager {
    private ArrayList<Student> students = new ArrayList<>();
    

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(87);
        scores.add(62);
        scores.add(64);
        scores.add(91);
        scores.add(93);
        Student s1 = new Student("Shaurya", "Bansal", 123456789, scores);
        System.out.println(s1.getFirstName() + " " + s1.getLastName());
        System.out.println("Average: " + s1.getAverage(scores));
    }

    
}
