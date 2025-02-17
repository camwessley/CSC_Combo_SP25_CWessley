import java.util.Scanner;

public class IoPractice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many people are here in the classroom?\n>");

        int numInClass = input.nextInt();
        System.out.println("There are " + numInClass + " people in the classroom. 3 times the number of people in the classroom is " + numInClass * 3 + "\n");

        System.out.print("What is your first name?\n>");
        String fName = input.next();

        System.out.print("What is your last name?\n>");
        String lName = input.next();

        System.out.println("Your full name: " + fName + " " + lName);

    }
}