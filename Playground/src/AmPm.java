import java.util.Scanner;

public class AmPm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 24-hour time: ");
        int time24Hr = input.nextInt();
        input.nextLine();

        int hour = time24Hr / 100;
        int minute = time24Hr % 100;

        while (time24Hr < 0 || hour > 23 || minute > 59) {
            System.out.print("Invalid time. Enter a correct 24-hour time (example: 1822, 0034): ");
            time24Hr = input.nextInt();
            input.nextLine();

            hour = time24Hr / 100;
            minute = time24Hr % 100;
        }

        String amPm;
        if (time24Hr < 1200) {
            amPm = "AM";
        } else {
            amPm = "PM";
            hour = hour - 12;
        }

        System.out.printf("%d:%d %s\n", hour, minute, amPm);
    }
}