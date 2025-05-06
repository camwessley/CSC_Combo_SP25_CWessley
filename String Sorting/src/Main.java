import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many strings to enter?\n> ");
        String[] strings = new String[Integer.parseInt(input.nextLine())];
        boolean rev = false;

        for (int i = 0; i < strings.length; i++) {
            System.out.printf("Enter string #%d:\n> ", i + 1);
            strings[i] = input.nextLine();
        }

        System.out.print("Reverse order (y/n)?\n> ");
        if (input.nextLine().equals("y")) {
            rev = true;
        }

        bubbleSortAlphabetic(strings, rev);
        for (String string : strings) {
            System.out.print(string + " ");
        }
        System.out.println();

        input.close();
    }

    public static void bubbleSortAlphabetic(String[] strings, Boolean rev) {
        int n = strings.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (rev) {
                    if (strings[j].compareTo(strings[j + 1]) < 0) {
                        String temp = strings[j];
                        strings[j] = strings[j + 1];
                        strings[j + 1] = temp;
                    }
                } else {
                    if (strings[j].compareTo(strings[j + 1]) > 0) {
                        String temp = strings[j];
                        strings[j] = strings[j + 1];
                        strings[j + 1] = temp;
                    }
                }
            }
        }
    }
}
