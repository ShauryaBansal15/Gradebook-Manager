import java.util.ArrayList;

public class Student implements StudentInterface {
    private String firstName;
    private String lastName;
    private final long studentID;
    private ArrayList<Double> scores;

    public Student(String firstName, String lastName, long studentID, ArrayList<Double> scores) {
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

    public long getStudentID() {
        return studentID;
    }

    public ArrayList<Double> getScores() {
        return new ArrayList<Double>(scores);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setScores(ArrayList<Double> scores) {
        this.scores = scores;
    }

    public double getAverage() {
        if (scores.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (double s : scores) {
            sum += s;
        }

        return sum / scores.size();

    }
}
