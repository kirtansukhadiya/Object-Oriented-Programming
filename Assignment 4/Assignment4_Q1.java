import java.util.Scanner;

class LetterGrade {
    protected double score;

    public LetterGrade() {
        this.score = 0;
    }

    public LetterGrade(double score) {
        this.score = score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public char getLetterGrade() {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else if (score >= 60) return 'D';
        else return 'F';
    }
}

class Essay extends LetterGrade {
    public Essay(double grammar, double spelling, double length, double content) {
        super(grammar + spelling + length + content);
    }
}

class PassFailExam extends LetterGrade {
    public PassFailExam(int totalQuestions, int missedQuestions) {
        double pointsEach = 100.0 / totalQuestions;
        double score = 100 - (missedQuestions * pointsEach);
        this.setScore(score);
    }

    @Override
    public char getLetterGrade() {
        return score >= 70 ? 'P' : 'F';
    }
}

class FinalExam extends LetterGrade {
    public FinalExam(int totalQuestions, int missedQuestions) {
        double pointsEach = 100.0 / totalQuestions;
        double score = 100 - (missedQuestions * pointsEach);
        this.setScore(score);
    }
}

class CourseGrades {
    private final LetterGrade[] grades;

    public CourseGrades() {
        grades = new LetterGrade[4];
    }

    public void setLab(LetterGrade lab) {
        grades[0] = lab;
    }

    public void setPassFailExam(PassFailExam exam) {
        grades[1] = exam;
    }

    public void setEssay(Essay essay) {
        grades[2] = essay;
    }

    public void setFinalExam(FinalExam finalExam) {
        grades[3] = finalExam;
    }

    public void printGrades() {
        System.out.println("\nCourse Grades:");
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] != null) {
                System.out.println("Assignment " + (i + 1) + " - Score: "
                        + String.format("%.2f", grades[i].getScore())
                        + ", Grade: " + grades[i].getLetterGrade());
            } else {
                System.out.println("Assignment " + (i + 1) + " - No grade assigned.");
            }
        }
    }
}

public class Assignment4_Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseGrades course = new CourseGrades();

        // Get Lab Score
        System.out.print("Enter the Lab Activity score (0-100): ");
        double labScore = scanner.nextDouble();
        course.setLab(new LetterGrade(labScore));

        // Get Pass/Fail Exam Details
        System.out.print("Enter total questions for the Pass/Fail exam: ");
        int totalPassFailQuestions = scanner.nextInt();
        System.out.print("Enter number of missed questions: ");
        int missedPassFail = scanner.nextInt();
        course.setPassFailExam(new PassFailExam(totalPassFailQuestions, missedPassFail));

        // Get Essay Scores
        System.out.print("Enter Grammar score (0-30): ");
        double grammar = scanner.nextDouble();
        System.out.print("Enter Spelling score (0-20): ");
        double spelling = scanner.nextDouble();
        System.out.print("Enter Length score (0-20): ");
        double length = scanner.nextDouble();
        System.out.print("Enter Content score (0-30): ");
        double content = scanner.nextDouble();
        course.setEssay(new Essay(grammar, spelling, length, content));

        // Get Final Exam Details
        System.out.print("Enter total questions for the Final Exam: ");
        int totalFinalQuestions = scanner.nextInt();
        System.out.print("Enter number of missed questions: ");
        int missedFinal = scanner.nextInt();
        course.setFinalExam(new FinalExam(totalFinalQuestions, missedFinal));

        // Print results
        course.printGrades();

        scanner.close();
    }
}
