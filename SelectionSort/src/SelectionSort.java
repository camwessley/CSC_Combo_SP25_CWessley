import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        fillArray(arr);
        printArray(arr);
        int index = findLow(arr, 0);
        System.out.printf("%d: %d", index, arr[index]);
    }

    private static int findLow(int[] arr, int index) {
        int low = index;

        for(int i = index; i < arr.length; ++i) {
            if (arr[i] < arr[low]) {
                low = i;
            }
        }

        return low;
    }

    private static void fillArray(int[] arr) {
        Random rand = new Random();

        for(int i = 0; i < arr.length; ++i) {
            arr[i] = rand.nextInt(10) + 1;
        }

    }

    private static void printArray(int[] arr) {
        for(int i : arr) {
            System.out.printf("|%d", i);
        }

        System.out.println("|");
    }
}