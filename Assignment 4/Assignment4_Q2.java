import java.util.Scanner;

public class Assignment4_Q2 {
    // Interface definition
    public interface Analyzable {
        double getAverage();
        GradedActivity getHighest();
        GradedActivity getLowest();
    }

    // GradedActivity class
    public static class GradedActivity {
        private double score;

        public void setScore(double s) {
            score = s;
        }

        public double getScore() {
            return score;
        }

        public char getGrade() {
            if (score >= 90) return 'A';
            else if (score >= 80) return 'B';
            else if (score >= 70) return 'C';
            else if (score >= 60) return 'D';
            else return 'F';
        }
    }

    // CourseGrades class implementing Analyzable
    public static class CourseGrades implements Analyzable {
        private final GradedActivity[] grades;
        private static final int NUM_GRADES = 4;

        public CourseGrades() {
            grades = new GradedActivity[NUM_GRADES];
        }

        public void setLab(GradedActivity lab) {
            grades[0] = lab;
        }

        public void setPassFailExam(GradedActivity passFailExam) {
            grades[1] = passFailExam;
        }

        public void setEssay(GradedActivity essay) {
            grades[2] = essay;
        }

        public void setFinalExam(GradedActivity finalExam) {
            grades[3] = finalExam;
        }

        @Override
        public double getAverage() {
            double total = 0;
            for (GradedActivity g : grades) {
                if (g != null) {
                    total += g.getScore();
                }
            }
            return total / NUM_GRADES;
        }

        @Override
        public GradedActivity getHighest() {
            GradedActivity highest = grades[0];
            for (GradedActivity g : grades) {
                if (g != null && g.getScore() > highest.getScore()) {
                    highest = g;
                }
            }
            return highest;
        }

        @Override
        public GradedActivity getLowest() {
            GradedActivity lowest = grades[0];
            for (GradedActivity g : grades) {
                if (g != null && g.getScore() < lowest.getScore()) {
                    lowest = g;
                }
            }
            return lowest;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < grades.length; i++) {
                if (grades[i] != null) {
                    sb.append("Grade ").append(i + 1)
                            .append(": Score = ").append(grades[i].getScore())
                            .append(", Letter Grade = ").append(grades[i].getGrade())
                            .append("\n");
                }
            }
            return sb.toString();
        }
    }

    // Main method to take user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseGrades courseGrades = new CourseGrades();

        String[] gradeTypes = {"Lab", "Pass/Fail Exam", "Essay", "Final Exam"};

        for (int i = 0; i < gradeTypes.length; i++) {
            System.out.print("Enter score for " + gradeTypes[i] + ": ");
            double score = scanner.nextDouble();
            GradedActivity activity = new GradedActivity();
            activity.setScore(score);

            switch (i) {
                case 0 -> courseGrades.setLab(activity);
                case 1 -> courseGrades.setPassFailExam(activity);
                case 2 -> courseGrades.setEssay(activity);
                case 3 -> courseGrades.setFinalExam(activity);
            }
        }

        scanner.close();

        System.out.println("\n===== Course Grades =====");
        System.out.println(courseGrades);
        System.out.println("Average Score: " + courseGrades.getAverage());
        System.out.println("Highest Score: " + courseGrades.getHighest().getScore());
        System.out.println("Lowest Score: " + courseGrades.getLowest().getScore());
    }
}
