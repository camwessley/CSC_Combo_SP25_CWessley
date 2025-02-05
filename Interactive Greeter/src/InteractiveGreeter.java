import java.util.Scanner;

public class InteractiveGreeter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("What is your name?\n> ");
        String name = input.nextLine();

        System.out.print("Where are you from?\n> ");
        String location = input.nextLine();

        System.out.print("How old are you in years?\n> ");
        int age = input.nextInt();
        // clear enter key from buffer
        input.nextLine();

        System.out.printf("Hello, %s from %s. You are %d years old.\n\n", name, location, age);

        System.out.print("What's something you like to do?\n> ");
        String hobby = input.nextLine();
        System.out.printf("That's great that you like to %s!\n\n", hobby);

        System.out.print("How much would you like to donate today?\n> ");
        double donation = input.nextDouble();
        input.nextLine();

        // I do not care to figure out StringBuilder right now
        System.out.println("Thank you for your donation of $" + donation + " today, " + name + "!");
    }
}