import java.util.Random;
import java.util.Arrays;

public class ArraysFun {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] array = new int[8];

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(30)+70;
        }

        System.out.println(Arrays.toString(array));

        int seventies = 0;
        int eighties = 0;
        int nineties = 0;

        for (int i : array) {
            if (i >= 90) {
                nineties++;
            }
            else if  (i >= 80) {
                eighties++;
            }
            else {
                seventies++;
            }
        }

        System.out.printf("Seventies: %d%n Eighties: %d%n Nineties: %d%n", seventies, eighties, nineties);
    }
}
