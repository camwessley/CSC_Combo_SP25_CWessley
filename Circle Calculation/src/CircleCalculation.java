import java.util.Scanner;

public class CircleCalculation {

    static double diameter(double radius) {
        return radius * 2;
    }

    static double area(double radius) {
        return Math.PI * radius * radius;
    }

    static double circumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the circle radius:\n> ");
        double radius = input.nextDouble();
        input.close();

        System.out.printf("Circle diameter: %.2f\nCircle area: %.2f\nCircle circumference: %.2f\n", diameter(radius), area(radius), circumference(radius));
    }
}