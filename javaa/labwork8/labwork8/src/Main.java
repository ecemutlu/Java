/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alper
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        CourseManagementSystem system = new CourseManagementSystem();
        addStudents(system);
        addInstructors(system);
        addCourses(system);
        system.assignCourses();
        System.out.println("");
        System.out.println("Professors are creating assignments for classes!");
        Thread.sleep(1000);
        system.createAssignments();
        System.out.println("");
        System.out.println("Professors are enrolling students to their classes!");
        Thread.sleep(1000);
        system.enrollStudents();
        System.out.println("");
        System.out.println("Course assignments are being posted!");
        Thread.sleep(1000);
        system.gradeStudents();
    }

    private static void addStudents(CourseManagementSystem system) {
        system.addStudent(new Student("Jacoby", "Brady"));
        system.addStudent(new Student("Malakai", "Campos"));
        system.addStudent(new Student("Lucian", "Boyer"));
        system.addStudent(new Student("Kellen", "Sloan"));
        system.addStudent(new Student("Giovanni", "Pierce"));
        system.addStudent(new Student("Nelson", "Fernandez"));
        system.addStudent(new Student("Rocco", "Trujillo"));
        system.addStudent(new Student("Nickolas", "Rios"));
        system.addStudent(new Student("Nathen", "Gutierrez"));
        system.addStudent(new Student("Keon", "Peck"));
        system.addStudent(new Student("Derick", "Kent"));
        system.addStudent(new Student("Nathanael", "Miles"));
        system.addStudent(new Student("Chase", "Hardy"));
        system.addStudent(new Student("Zechariah", "Nash"));
        system.addStudent(new Student("Bradley", "Ferguson"));
        system.addStudent(new Student("Konner", "Jones"));
        system.addStudent(new Student("Alessandro", "Crosby"));
        system.addStudent(new Student("Sam", "Mcintosh"));
        system.addStudent(new Student("Jaime", "Hall"));
        system.addStudent(new Student("Trevon", "Weeks"));
        system.addStudent(new Student("Carlie", "Ortiz"));
        system.addStudent(new Student("Alessandra", "Fitzgerald"));
        system.addStudent(new Student("Michaela", "Decker"));
        system.addStudent(new Student("Cindy", "Martin"));
        system.addStudent(new Student("Meghan", "Rich"));
        system.addStudent(new Student("Londyn", "Paul"));
        system.addStudent(new Student("Jasmin", "Castillo"));
        system.addStudent(new Student("Haylie", "English"));
        system.addStudent(new Student("Kaliyah", "Kramer"));
        system.addStudent(new Student("Alanna", "Burch"));
        system.addStudent(new Student("Eliza", "Conrad"));
        system.addStudent(new Student("Larissa", "Beck"));
    }

    private static void addInstructors(CourseManagementSystem system) {
        system.addInstructor(new Instructor("Edward", "Mueller"));
        system.addInstructor(new Instructor("Darryl", "Dunn"));
        system.addInstructor(new Instructor("Mariana", "Robbins"));

    }

    private static void addCourses(CourseManagementSystem system) {
        system.addCourse(new Course("CMP 100", "Introdution to Computer Engineering", 15));
        system.addCourse(new Course("CMP 101", "Discrete Mathematics", 10));
        system.addCourse(new Course("CMP 102", "Calculus", 12));
        system.addCourse(new Course("CMP 103", "Physics", 8));
        system.addCourse(new Course("CMP 104", "Programming I", 20));
        system.addCourse(new Course("CMP 105", "Data Structures", 10));
    }

}
