import java.util.ArrayList;
import java.util.Scanner;

public class CSclasses {

    public static void printCourse(Course course) {
        System.out.println(course.toString());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Course> courseList = new ArrayList<>();
        int numCourses;
        int courseType;
        String courseNumber;
        int numStudents;
        int maxStudents;
        int credits;

        System.out.print("Number of Courses:\n> ");
        numCourses = Integer.parseInt(input.nextLine());

        for (int i = 0; i < numCourses; i++) {
            System.out.print("Course Type:\n(1) Online Fully Remote\n(2) Real Time Remote\n(3) In Person\n> ");
            courseType = Integer.parseInt(input.nextLine());

            System.out.print("Course Number:\n> ");
            courseNumber = input.nextLine();

            System.out.print("Number of Students:\n> ");
            numStudents = Integer.parseInt(input.nextLine());

            System.out.print("Max Students:\n> ");
            maxStudents = Integer.parseInt(input.nextLine());

            System.out.print("Credits:\n> ");
            credits = Integer.parseInt(input.nextLine());

            switch (courseType) {
                case 1:
                    String courseContact;
                    System.out.print("Course Contact:\n> ");
                    courseContact = input.nextLine();

                    courseList.add(new OnlineCourse.FullRemoteCourse(courseNumber, numStudents, maxStudents, credits, courseContact));
                    break;

                case 2:
                    String zoomLink;
                    System.out.print("Zoom Link:\n> ");
                    zoomLink = input.nextLine();

                    courseList.add(new OnlineCourse.RealTimeRemoteCourse(courseNumber, numStudents, maxStudents, credits, zoomLink));
                    break;

                case 3:
                    String roomNumber;
                    System.out.print("Room Number:\n> ");
                    roomNumber = input.nextLine();

                    courseList.add(new InPersonCourse(courseNumber, numStudents, maxStudents, credits, roomNumber));
                    break;
            }

            System.out.println("Course added!\n");
        }

        for (Course course : courseList) {
            printCourse(course);
        }
    }
}