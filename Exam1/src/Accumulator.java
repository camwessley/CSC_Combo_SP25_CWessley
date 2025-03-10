import java.util.Scanner;

public class Accumulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int count = 0;
        while (true) {
            System.out.print("Enter a number to accumulate, or 0 to exit: ");

            int add = input.nextInt();
            input.nextLine();
            count = count + add;

            if (add == 0) {
                break;
            }

            System.out.println("Running total: " + count);
        }

        System.out.println("\nYour total is " + count);
    }
}
