import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter numerical grade:\n> ");
        int numGrade = input.nextInt();
        input.close();

        String letterGrade;

        if (numGrade < 60) {
            letterGrade = "F";
        } else if (numGrade < 67) {
            letterGrade = "D";
        } else if (numGrade < 69) {
            letterGrade = "D+";
        } else if (numGrade < 72) {
            letterGrade = "C-";
        } else if (numGrade < 77) {
            letterGrade = "C";
        } else if (numGrade < 79) {
            letterGrade = "C+";
        } else if (numGrade < 82) {
            letterGrade = "B-";
        } else if (numGrade < 87) {
            letterGrade = "B";
        } else if (numGrade < 89) {
            letterGrade = "B+";
        } else if (numGrade < 92) {
            letterGrade = "A-";
        } else {
            letterGrade = "A";
        }
        System.out.println("Your letter grade is: " + letterGrade);
    }
}