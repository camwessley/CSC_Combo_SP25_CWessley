import java.util.Scanner;

public class CheckString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first word to compare: ");
        String word1 = input.next();
        System.out.print("Enter second word to compare: ");
        String word2 = input.next();
        input.close();

        int diff = word1.compareTo(word2);

        if (diff > 0) {
            System.out.println("word 2 \"" + word2 + "\" is before word 1");

        } else if (diff < 0) {
            System.out.println("word 1 \"" + word1 + "\" is before word 2");

        } else {
            System.out.println("They are the same");
        }
        System.out.println("\nFull diff: " + diff);
    }
}
