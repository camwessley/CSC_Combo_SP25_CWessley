public class scratch {
    public static void main(String[] args) {
        int small = 4;
        int big = 1;
        int goal = 9;

        int bigKNeeded = goal - (big * 5);
        int smallKNeeded = goal - bigKNeeded;

        System.out.println(smallKNeeded);
        System.out.println(bigKNeeded);


    }
}