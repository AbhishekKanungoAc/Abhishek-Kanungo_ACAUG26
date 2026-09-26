package endModule;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Enum for Grade
enum Grade {
    DISTINCTION,
    FIRST_CLASS,
    SECOND_CLASS,
    PASS,
    FAIL
}

// Custom Exception
class InvalidInputException extends Exception {

    public InvalidInputException(String message) {
        super(message);
    }
}

// Result class
class Result {

    private static int nextId = 1;

    private int studentId;
    private String studentName;
    private String subjectName;
    private int marks;
    private Grade grade;
    private LocalDate examDate;

    public Result(String studentName, String subjectName,
                  int marks, LocalDate examDate)
            throws InvalidInputException {

        if (studentName == null || studentName.trim().isEmpty()) {
            throw new InvalidInputException("Student name cannot be empty");
        }

        if (subjectName == null || subjectName.trim().isEmpty()) {
            throw new InvalidInputException("Subject name cannot be empty");
        }

        if (marks < 0 || marks > 100) {
            throw new InvalidInputException("Marks must be between 0 and 100");
        }

        this.studentId = nextId++;
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.marks = marks;
        this.grade = calculateGrade(marks);
        this.examDate = examDate;
    }

    // Automatically calculate grade
    private Grade calculateGrade(int marks) {

        if (marks >= 75) {
            return Grade.DISTINCTION;
        } else if (marks >= 60) {
            return Grade.FIRST_CLASS;
        } else if (marks >= 50) {
            return Grade.SECOND_CLASS;
        } else if (marks >= 40) {
            return Grade.PASS;
        } else {
            return Grade.FAIL;
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getMarks() {
        return marks;
    }

    public Grade getGrade() {
        return grade;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    @Override
    public String toString() {

        return "ID: " + studentId
                + ", Name: " + studentName
                + ", Subject: " + subjectName
                + ", Marks: " + marks
                + ", Grade: " + grade
                + ", Exam Date: " + examDate;
    }
}

// Main class
public class StudentResultManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Result> results = new ArrayList<>();

        while (true) {

            System.out.println("\n===== STUDENT RESULT MANAGEMENT =====");
            System.out.println("1. Add Result");
            System.out.println("2. Display Results by Grade");
            System.out.println("3. Average Marks by Subject");
            System.out.println("4. Find Top Scorer");
            System.out.println("5. Display All Results Sorted by Marks");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter student name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter subject name: ");
                        String subject = sc.nextLine();

                        System.out.print("Enter marks: ");
                        int marks = sc.nextInt();

                        Result result = new Result(
                                name,
                                subject,
                                marks,
                                LocalDate.now()
                        );

                        results.add(result);

                        System.out.println("Result added successfully.");
                        System.out.println(result);

                        break;

                    case 2:

                        System.out.print(
                                "Enter grade (DISTINCTION/FIRST_CLASS/SECOND_CLASS/PASS/FAIL): "
                        );

                        String gradeInput = sc.nextLine();

                        Grade grade = Grade.valueOf(
                                gradeInput.toUpperCase()
                        );

                        // Predicate for grade
                        Predicate<Result> byGrade =
                                r -> r.getGrade() == grade;

                        System.out.println("\nResults:");

                        results.stream()
                                .filter(byGrade)
                                .forEach(System.out::println);

                        break;

                    case 3:

                        System.out.print("Enter subject name: ");
                        String subjectName = sc.nextLine();

                        // Predicate for subject
                        Predicate<Result> bySubject =
                                r -> r.getSubjectName()
                                        .equalsIgnoreCase(subjectName);

                        double average = results.stream()
                                .filter(bySubject)
                                .mapToInt(Result::getMarks)
                                .average()
                                .orElse(0.0);

                        System.out.println(
                                "Average Marks = " + average
                        );

                        break;

                    case 4:

                        Optional<Result> topScorer =
                                results.stream()
                                        .max(
                                            Comparator.comparingInt(
                                                Result::getMarks
                                            )
                                        );

                        System.out.println(
                                topScorer
                                .map(r -> "Top Scorer: " + r)
                                .orElse("No results available")
                        );

                        break;

                    case 5:

                        System.out.println(
                                "\nResults sorted by marks (descending):"
                        );

                        results.stream()
                                .sorted(
                                    Comparator.comparingInt(
                                        Result::getMarks
                                    ).reversed()
                                )
                                .forEach(System.out::println);

                        break;

                    case 6:

                        System.out.println("Program ended.");
                        sc.close();
                        return;

                    default:

                        System.out.println("Invalid choice.");
                }

            } catch (InvalidInputException e) {

                System.out.println(e.getMessage());

            } catch (IllegalArgumentException e) {

                System.out.println("Invalid input.");
            }
        }
    }
}

