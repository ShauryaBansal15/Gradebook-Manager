# Gradebook Manager

## Purpose
This project is a simple Java-based gradebook application designed to help a teacher or instructor manage student information and track grades in an organized way. It allows a user to add students, remove them, search for them, view class averages, sort students, and save or load data from a file.

## What This Application Does
The Gradebook Manager provides a basic command-line interface for managing a class roster. It is useful for:
- Keeping track of student names and IDs
- Recording and viewing student scores
- Finding individual students quickly
- Viewing overall class statistics
- Saving student data for later use

## Main Features
- Add a new student
- Remove an existing student
- Search by student ID
- Search by first and last name
- Display all students in the gradebook
- Sort students by name or average grade
- View class-level statistics
- Save data to a file
- Load saved data from a file

## Project Files
- Driver.java: Main program and console menu
- GradebookManager.java: Core logic for managing students
- Student.java: Student model and grade calculations
- StudentInterface.java: Validation and interface methods
- GradebookGUI.java: A basic graphical user interface version

## How to Use It
### Run the console version
1. Open a terminal in the project folder.
2. Compile the Java file:
   ```bash
   javac Driver.java
   ```
3. Run the program:
   ```bash
   java Driver
   ```
4. Follow the menu prompts to manage the gradebook.

### Optional GUI version
You can also try the graphical interface by running:
```bash
java GradebookGUI
```

## Notes
This project is a beginner-friendly Java application that demonstrates object-oriented programming, array-based data management, file input/output, and simple user interaction. It is ideal for learning how a small educational tool can be built in Java.

## Example Use Case
A teacher could use this application to keep a class list, track student performance, and quickly access student records during the school term.
