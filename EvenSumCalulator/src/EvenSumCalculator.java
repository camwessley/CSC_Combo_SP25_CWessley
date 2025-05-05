public class EvenSumCalculator {
    public static int calculateEvenSum(int limit) {
        int sum = 0;
        int i = 1;
        while (i <= limit) {
            if (i % 2 == 0) {
                sum += i;
            }
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int limit = 10;
        int result = calculateEvenSum(limit);
        System.out.println("The sum of even numbers up to " + limit + " is: " + result);
    }
}