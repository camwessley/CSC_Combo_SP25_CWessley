public class OnlineCourse extends Course {
    public static class FullRemoteCourse extends Course {
        private String courseContact;

        public FullRemoteCourse(String courseNumber, int numStudents, int maxStudents, int credits, String courseContact) {
            super(courseNumber, numStudents, maxStudents, credits);
            this.courseContact = courseContact;
        }

        public String getCourseContact() {
            return courseContact;
        }

        public void setCourseContact(String courseContact) {
            this.courseContact = courseContact;
        }

        @Override
        public String toString() {
            return String.format("""
                    %s
                    Course Contact: %s
                    """, super.toString(), courseContact);
        }
    }

    public static class RealTimeRemoteCourse extends Course {
        private String zoomLink;

        public RealTimeRemoteCourse(String courseNumber, int numStudents, int maxStudents, int credits, String zoomLink) {
            super(courseNumber, numStudents, maxStudents, credits);
            this.zoomLink = zoomLink;
        }

        public String getZoomLink() {
            return zoomLink;
        }

        public void setZoomLink(String zoomLink) {
            this.zoomLink = zoomLink;
        }

        @Override
        public String toString() {
            return String.format("""
                    %s
                    Zoom Link: %s
                    """, super.toString(), zoomLink);
        }
    }
}
