import java.util.Scanner;

public class Main {
    private static void scream(String scream){
        System.out.println(scream.toUpperCase());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("What would you like to scream?\n> ");
        String screamThis = input.nextLine();
        scream(screamThis);
    }
}