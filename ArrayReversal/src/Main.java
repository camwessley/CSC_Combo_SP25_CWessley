import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array length: ");
        int[] arr = new int[Integer.parseInt(scanner.nextLine())];
        int count = 0;
        int input;

        System.out.println("Enter array values, or -1 to exit:");
        while (count < arr.length) {
            System.out.printf("#%d: ", count);
            input = Integer.parseInt(scanner.nextLine());
            if (input == -1) break;
            arr[count] = input;
            count++;
        }
        scanner.close();

        System.out.println("\nArray reversed:");
        for (int i = count - 1; i >= 0; i--) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
}