import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        // initiate integer and string for eval
        int x = 2;
        String str = "fish";

        // check to see if x is equal to 2
        if (x == 2) {
            System.out.println("number is 2");
        }

        // print the string, its length, and the third (second from 0) character
        System.out.println("\nString: " + str + "\n" + "Length: " + str.length() + "\n" + "Char 2: " + str.charAt(2));

        // initiate class end minute and hour variables
        int minute = 45;
        int hour = 12;

        // print current time and the time at which class ends
        System.out.println("\nCurrent time is: " + LocalTime.now() + "\nClass ends at " + hour + ":" + minute);
    }
}