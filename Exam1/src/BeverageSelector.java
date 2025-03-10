import java.util.Scanner;

public class BeverageSelector {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Choose a beverage:\n(1) Water\n(2) Coke\n(3) Coffee\n> ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            System.out.print("You bought a water.");

        } else if (choice == 2) {
            System.out.print("You bought a Coke.");

        } else {
            System.out.print("You bought a coffee.");

        }
    }
}
