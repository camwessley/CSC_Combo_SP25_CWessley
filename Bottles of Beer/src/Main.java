import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Starting bottles: ");
        int startingBottles = input.nextInt();
        input.close();

        for (int i = startingBottles; i >= 0; i--) {
            if (i == 0) {
                System.out.printf("%d bottles of beer on the wall, %d bottles of beer.\nGo to the store and buy some more, %d bottles of beer on the wall.\n\n", i, i, startingBottles);
                break;
            }
            System.out.printf("%d bottles of beer on the wall, %d bottles of beer.\nTake one down and pass it around, %d bottles of beer on the wall.\n\n", i, i, i - 1);
        }
    }
}