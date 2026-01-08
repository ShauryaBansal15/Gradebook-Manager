import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;


public class GradebookGUI extends JFrame {
    private GradebookManager manager;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JTextField firstNameField, lastNameField, idField, scoresField;
    private JButton addStudentButton, removeStudentButton, sortByNameButton, sortByIDButton;
    
    public GradebookGUI() {
        manager = new GradebookManager();

        setupFrame();
        setupTable();
        setupButtons();
        setupLayout();


        setVisible(true);
    }

    private void setupFrame() {
        setTitle("Gradebook Manager"); // Title of UI
        setSize(800, 600); // Size of the UI
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Disposes when tab is closed
        setLocationRelativeTo(null); // Centers on the screen
    }

    private void setupTable() {
        String[] columnNames = {"Student ID", "First Name", "Last Name", "Average"};


        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Makes cells non-editable
            }
        };

        studentTable = new JTable(tableModel);

        // Enables single row selection
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Wrap table in a scroll pane (make it scrollable)
        scrollPane = new JScrollPane(studentTable);

    }

    private void setupButtons() {

    }

    private void setupLayout() {
        //  Adding the scroll pane (which contains the table) to the center
        add(scrollPane, BorderLayout.CENTER);

    }

    private void addStudent() {

    }

    private void removeStudent() {

    }

    private void refreshTable() {
        // Clears existing rows
        tableModel.setRowCount(0);

        // Add each student as a row
        for (Student s : manager.getAllStudents()) {
            Object[] row = {
                s.getStudentID(),
                s.getFirstName(),
                s.getLastName(),
                String.format("%.2f", s.getAverage())
            };
            tableModel.addRow(row);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GradebookGUI();
        });
    }
}
