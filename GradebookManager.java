import java.util.ArrayList;

public class GradebookManager {
    private ArrayList<Student> students = new ArrayList<>();
    

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    
}
