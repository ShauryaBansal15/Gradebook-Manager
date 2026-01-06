import javax.swing.*;

public class GradebookGUI extends JFrame {
    private GradebookManager manager;
    private JTable studentTable;
    private JTextField firstNameField, lastNameField, idField, scoresField;
    private JButton addStudentButton, removeStudentButton, sortByNameButton, sortByIDButton;
    
    public GradebookGUI() {
        manager = new GradebookManager();

        setupFrame();

        setVisible(true);
    }

    private void setupFrame() {
        setTitle("Gradebook Manager"); // Title of UI
        setSize(800, 600); // Size of the UI
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Disposes when tab is closed
        setLocationRelativeTo(null); // Centers on the screen
    }

    private void setupComponents() {

    }

    private void setupLayout() {

    }

    private void addStudent() {

    }

    private void removeStudent() {

    }

    private void refreshTable() {
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GradebookGUI();
        });
    }
}
