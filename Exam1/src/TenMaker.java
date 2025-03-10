import java.util.Scanner;

public class TenMaker {
    private static boolean makes10(int int1, int int2) {
        return int1 + int2 == 10;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the first number between 1 and 10:\n> ");
        int int1 = input.nextInt();
        input.nextLine();

        System.out.print("Please enter the second number between 1 and 10:\n> ");
        int int2 = input.nextInt();
        input.nextLine();

        if (makes10(int1, int2)) {
            System.out.println("\nYour numbers add up to 10.");

        } else {
            System.out.printf("Your numbers do not add up to 10: %d", int1 + int2);

        }
    }
}
