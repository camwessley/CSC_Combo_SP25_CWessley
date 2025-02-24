import java.util.Scanner;

public class PlayAgain {
    public static void main(String[] args) {
        System.out.println("Play again?");

        Scanner input = new Scanner(System.in);
        String ans = input.next();
        input.close();

        if (ans.equals("yes")) {
            System.out.println("Let's go!");
        } else {
            System.out.println("Goodbye.");
        }
    }
}
