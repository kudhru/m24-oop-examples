package practiceproblems;

//=== SINGLETON ===
class SystemLogManager {
 private static SystemLogManager instance;
 private SystemLogManager() {}
 public static synchronized SystemLogManager getInstance() {
     if (instance == null) { instance = new SystemLogManager(); }
     return instance;
 }
 public void log(String message) {
     System.out.println("[LOG] " + message);
 }
}

//=== FACTORY ===
interface Course { void enroll(); }
class UndergradCourse implements Course {
 public void enroll() { 
     System.out.println("Enrolling UG student."); 
     SystemLogManager.getInstance().log("UG Enrollment event."); // Factory uses Singleton
 }
}
class GraduateCourse implements Course { public void enroll() { System.out.println("Enrolling Grad student."); } }

class CourseFactory {
 public Course createCourse(String type) {
     if ("UG".equalsIgnoreCase(type)) return new UndergradCourse();
     if ("Grad".equalsIgnoreCase(type)) return new GraduateCourse();
     return null;
 }
}

interface TimetableBuilder {}

//=== BUILDER (Timetable Construction) ===
class Timetable { /* Complex object */ }
class FallTimetableBuilder implements TimetableBuilder { /* ... */ }
//Client/Director uses the builder to assemble valid timetables step-by-step
