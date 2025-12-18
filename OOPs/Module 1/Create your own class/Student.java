// Student class to store and manage student information
public class Student {
    // Step 1: Declare private variables for studentId, name, grade, and isActive
    // Hint: Use appropriate data types (String, String, double, boolean)
    private String studentId;
    private String name;
    private double grade;
    private boolean isActive;

    // Step 2: Create getter methods for each variable
    // Hint: Use the format: public returnType getVariableName()

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setStudentId(String studentId) {
        // validate name not empty or null
        if (studentId != null && !studentId.trim().isEmpty()) {
            this.studentId = studentId;
        } else {
            System.out.println("student id must be not null or empty");
            this.studentId = "unknown";
        }
    }

    public void setName(String name) {
        // validate name not empty or null
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Name must be not null or empty");
            this.name = "unknown";
        }
    }

    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else {
            System.out.println("Grade must be between range 0-100.");
            this.grade = 0.0;
        }

    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Step 3: Create setter methods for each variable
    // Hint: Use the format: public void setVariableName(parameter)
    // Add simple validation:
    // - For grade: Ensure it is between 0 and 100
    // - For studentId: No special validation needed
    // - For name: No special validation needed
    // - For isActive: No special validation needed


    // Step 4: Create a method to display student details
    // Hint: Use System.out.println() to print all student information
    // Format should include ID, name, grade, and status (Active/Inactive)
    public void displayStudentDetail() {
        System.out.println("Student information detail is: ");
        System.out.println("Student ID is: " + this.studentId);
        System.out.println("Student name is: " + this.name);
        System.out.println("Student grade is: " + this.grade);
        System.out.println("Student status is: " + this.isActive);
    }

    // Step 5: Create a method that returns a letter grade based on the numeric grade
    // Hint: A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: below 60
    public void displayGradeLetter() {
        if (this.grade >= 90 && this.grade <= 100)
            System.out.println("Grade A");
        else if (this.grade >= 80 && this.grade <= 89)
            System.out.println("Grade B");
        else if (this.grade >= 70 && this.grade <= 79)
            System.out.println("Grade C");
        else if (this.grade >= 60 && this.grade <= 69)
            System.out.println("Grade D");
        else
            System.out.println("Grade F");
    }

    // Step 6: Create a method to check if the student is passing (grade >= 60)
    // Hint: Return a boolean value
    public boolean isPassed() {
        return this.grade >= 60;
    }
}
