import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the temperature in Fahrenheit: ");
        int fTemp = input.nextInt();
        int cTemp = (fTemp - 32) * 5 / 9;
        double kTemp = cTemp + 273.15;

        // for use if we want to normalize Kelvin value (https://stackoverflow.com/questions/2654839/rounding-a-double-to-turn-it-into-an-int-java)
        //int kTemp = (int) Math.round(cTemp + 273.15);
        //if (kTemp < 0) System.out.println("\nNegative Kelvin temperature; normalizing to 0"); kTemp = 0;

        System.out.println("Entered temperature " + fTemp + "F in:\nCelcius: " + cTemp + "C\nKelvin: " + kTemp + "K");
    }
}