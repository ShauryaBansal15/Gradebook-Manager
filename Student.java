import java.util.ArrayList;

public class Student implements StudentInterface {
    private String firstName;
    private String lastName;
    private final long studentID;
    private ArrayList<Integer> scores;

    public Student(String firstName, String lastName, long studentID, ArrayList<Integer> scores) {
        // Verifications of the basic student information
        verifyFirstName(firstName);
        verifyLastName(lastName);
        verifyStudentID(studentID);

        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.scores = new ArrayList<>(scores);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Integer> getScores() {
        return new ArrayList<>(scores);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    public double getAverage(ArrayList<Integer> scores) {
        int sum = 0;
        for (int s : scores) {
            sum += s;
        }

        double average = 0.0;
        average = sum / scores.size();

        return average;

    }
}
