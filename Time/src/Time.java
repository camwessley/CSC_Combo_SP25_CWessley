public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    // Default constructor
    public Time() {this.hours = 0; this.minutes = 0; this.seconds = 0;}

    // Parameterized constructor
    public Time(int h, int m, int s) {this.hours = h; this.minutes = m; this.seconds = s;}

    public static void main(String[] args) {
        Time t1 = new Time();              // midnight
        Time t2 = new Time(17, 30, 0);     // 5:30 PM

        // add an hour onto t1, then print it in both formats
        t1.increment(3600);
        t1.print(true);
        t1.print(false);

        // add an hour and a half, and 30 seconds onto t2
        t2.increment(5430);

        // print t2 in both formats
        t2.print(true);
        t2.print(false);
    }

    // Method to increment time by a given number of seconds
    public void increment(int addSeconds) {
        int total = this.hours * 3600 + this.minutes * 60 + this.seconds;
        total += addSeconds;
        total %= 86400; // Ensure total is within one day
        if (total < 0) total += 86400; // Handle negative increments
        this.hours = total / 3600;
        this.minutes = (total % 3600) / 60;
        this.seconds = total % 60;
    }

    // Method to print time in military or AM/PM format
    public void print(boolean military) {
        if (military) {
            System.out.printf("%d:%02d:%02d\n", this.hours, this.minutes, this.seconds);
        } else {
            int twelveHour;
            String period;
            if (this.hours < 12) {
                period = "AM";
                twelveHour = (this.hours == 0) ? 12 : this.hours;
            } else {
                period = "PM";
                twelveHour = (this.hours == 12) ? 12 : this.hours - 12;
            }
            System.out.printf("%d:%02d:%02d %s\n", twelveHour, this.minutes, this.seconds, period);
        }
    }
}