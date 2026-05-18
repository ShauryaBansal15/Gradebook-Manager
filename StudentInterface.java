import java.util.ArrayList;

public interface StudentInterface {

    // Allows user to get the first name 
    String getFirstName();

    // Allows user to get the last name
    String getLastName();

    // Allows user to get the scores of the student
    ArrayList<Double> getScores();

    // Allows user to edit the first name of a student
    public void setFirstName(String firstName);

    // Allows user to edit the last name of a student
    public void setLastName(String lastName);

    default boolean verifyFirstName(String firstName) throws IllegalArgumentException {

        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name must contain letters!");
        }

        for (int i = 0; i < firstName.length(); i++) {
            char c = firstName.charAt(i);
            int ascii = (int) c;
                    
            if (ascii < 64) {
                throw new IllegalArgumentException("Invalid name letters!");
            } else if (ascii > 90 && ascii < 97) {
                throw new IllegalArgumentException("Invalid characters for first name!");
            } else if (ascii > 122) {
                throw new IllegalArgumentException("Invalid characters for first name!");
            }
        }

        return true;
    }

    default boolean verifyLastName(String lastName) throws IllegalArgumentException {

        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name must contain letters!");
        }

        for (int i = 0; i < lastName.length(); i++) {
            char c = lastName.charAt(i);
            int ascii = (int) c;
                    
            if (ascii < 64) {
                throw new IllegalArgumentException("Invalid name letters!");
            } else if (ascii > 90 && ascii < 97) {
                throw new IllegalArgumentException("Invalid characters for last name!");
            } else if (ascii > 122) {
                throw new IllegalArgumentException("Invalid characters for last name!");
            }
        }

        return true;
    }

    default boolean verifyStudentID(long studentID) {
        String ID = Long.toString(studentID);

        if (studentID <= 0) {
            throw new IllegalArgumentException("Invalid ID! ID has to be positive!");
        }

        if (ID.length() != 9) {
            throw new IllegalArgumentException("Invalid ID! ID has to be 9 digits long");
        }
        // Not needed since ID is already numbers
        /*
        for (int i = 0; i < ID.length(); i++) {
            char c = ID.charAt(i);
            int ascii = (int) c;
            if (ascii < 48 || ascii > 57) {
                throw new IllegalArgumentException("Invalid ID! ID must only be numbers!");
            }
        }
        */
        
        return true;
    }
    
    default boolean verifyScores(ArrayList<Double> scores) {
        if (scores == null) {
            throw new IllegalArgumentException("Scores cannot be null!");
        }
        return true;
    }
}
