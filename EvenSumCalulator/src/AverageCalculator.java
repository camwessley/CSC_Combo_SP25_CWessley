
public class AverageCalculator {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        double average = calculateAverage(numbers);
        System.out.println("The average is: " + average);
    }

    public static double calculateAverage(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (double) sum / nums.length;
    }
}