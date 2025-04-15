public class CourseInitials {
    private String courseName;
    private int numStudents;
    private int maxStudents;
    private String room;
    private double credits;

    public CourseInitials() {
        this.courseName = "";
        this.numStudents = 0;
        this.maxStudents = 0;
        this.room = "";
        this.credits = 0;
    }

    public String getCourseName() {return this.courseName;}

    public void setCourseName(String courseName) {this.courseName = courseName;}

    public int getNumStudents() {return this.numStudents;}

    public void setNumStudents(int numStudents) {this.numStudents = numStudents;}

    public int getMaxStudents() {return this.maxStudents;}

    public void setMaxStudents(int maxStudents) {this.maxStudents = maxStudents;}

    public String getRoom() {return this.room;}

    public void setRoom(String room) {this.room = room;}

    public double getCredits() {return this.credits;}

    public void setCredits(double credits) {this.credits = credits;}

    @Override
    public String toString() {
        return "CourseInitials{" +
                "courseName='" + courseName + '\'' +
                ", numStudents=" + numStudents +
                ", maxStudents=" + maxStudents +
                ", room='" + room + '\'' +
                ", credits=" + credits +
                '}';
    }
}