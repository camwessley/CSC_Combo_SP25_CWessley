import java.util.Scanner;

public class Divider {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number:\n> ");
        double firstNum = input.nextDouble();
        input.nextLine();

        System.out.print("Enter the second number to divide by:\n> ");
        double secondNum = input.nextDouble();
        input.nextLine();

        if (secondNum == 0) {
            System.out.print("Cannot divide by zero\nEnter the second number to divide by:\n> ");
            secondNum = input.nextDouble();
            input.nextLine();
        }

        double answer = firstNum / secondNum;

        System.out.printf("Answer is: %.2f", answer);
    }
}