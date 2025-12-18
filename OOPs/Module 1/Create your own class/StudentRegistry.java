// StudentRegistry class to test the Student class
public class StudentRegistry {
    public static void main(String[] args) {
        // Step 1: Create two instances of the Student class
        Student firstStudent = new Student();
        Student secondStudent = new Student();


        // Step 2: Use setter methods to set values for all attributes of first student
        // Example values: ID "S001", name "John Doe", grade 85.5, active true
        firstStudent.setStudentId("S001");
        firstStudent.setName("John Doe");
        firstStudent.setGrade(85.5);
        firstStudent.setActive(true);


        // Step 3: Set values for second student
        // Example values: ID "S002", name "Jane Smith", grade 92.0, active true
        secondStudent.setStudentId("S002");
        secondStudent.setName("Jane Smith");
        secondStudent.setGrade(92.0);
        secondStudent.setActive(true);

        // Step 4: Display details of both students
        System.out.println("Detail information of both students.");
        firstStudent.displayStudentDetail();
        secondStudent.displayStudentDetail();

        // Step 5: Compare the grades of the two students and print who has the higher grade
        // Hint: Create a separate method for this comparison
        compareGrade(firstStudent, secondStudent);

        // Step 6: Test the letter grade method for both students
        firstStudent.displayGradeLetter();
        secondStudent.displayGradeLetter();

        // Step 7: Test the passing status method for both students
        System.out.println(firstStudent.getName() + " is passing the exam: " + firstStudent.isPassed());
        System.out.println(secondStudent.getName() + " is passing the exam: " + secondStudent.isPassed());

        // Step 8: Change one student to inactive and display the updated information
        firstStudent.setActive(false);
        secondStudent.setActive(false);
        firstStudent.displayStudentDetail();
        secondStudent.displayStudentDetail();
    }

    private static void compareGrade(Student firstStudent, Student secondStudent) {
        if (firstStudent.getGrade() > secondStudent.getGrade())
            System.out.println(firstStudent.getName() + " has the higher grade than " + secondStudent.getName());
        else
            System.out.println(secondStudent.getName() + " has the higher grade than " + firstStudent.getName());
    }

    // Step 9: Create a static method to compare two students' grades and return the student with the higher grade
    // Hint: Take two Student objects as parameters
}
