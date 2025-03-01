import java.util.Scanner;

public class Triangles {
    static void drawTriangle(int size, char fill) {
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(fill + " ");
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int triangleSize;
        char fillChar;
        boolean keepGoing = true;

        while (keepGoing) {

            System.out.print("Triangle size (0-50): ");
            triangleSize = input.nextInt();

            while (triangleSize < 1 || triangleSize > 50) {
                System.out.print("Invalid triangle size. Enter a number between 0 and 50: ");
                triangleSize = input.nextInt();
            }
            input.nextLine();

            System.out.print("Fill character: ");
            fillChar = input.next().charAt(0);

            System.out.println();
            drawTriangle(triangleSize, fillChar);

            System.out.print("\nDraw another triangle? (y/n): ");
            String response = input.next().toLowerCase();

            while (!response.equals("y") && !response.equals("n")) {
                System.out.print("Please enter 'y' or 'n': ");
                response = input.next().toLowerCase();
            }

            keepGoing = response.equals("y");
        }
        input.close();
    }
}