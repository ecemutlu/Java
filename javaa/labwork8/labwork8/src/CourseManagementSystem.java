
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alper
 */
public class CourseManagementSystem {

    private List<Student> students;
    private List<Instructor> instructors;
    private List<Course> courses;

    public CourseManagementSystem() {
        this.courses = new ArrayList<>();
        this.instructors = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addInstructor(Instructor instructor) {
        this.instructors.add(instructor);
    }

    public void addCourse(Course c) {
        this.courses.add(c);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void assignCourses() throws InterruptedException {
        Random random = new Random();
        System.out.println("Assigning courses to Professors!");
        Thread.sleep(1000);
        if (!courses.isEmpty() && !instructors.isEmpty()) {
            for (Course course : courses) {
                Instructor next = instructors.get(random.nextInt(instructors.size()));
                next.addCourse(course);
                System.out.println("Course "+course.getCourseCode()
                        +" "+course.getCourseName()+" will be taught by Professor "+next.getSurname()+" this semester!");
                System.out.println("--------------------------------------------------------------------");
                Thread.sleep(250);
            }
        }
    }

    public void createAssignments() throws InterruptedException {
        for (Instructor instructor : instructors) {
            List<Course> coursesTaught = instructor.getCoursesTaught();
            for (Course course : coursesTaught) {
                String courseCode = course.getCourseCode();
                instructor.createAssignment("Homework", 0.15, courseCode);
                instructor.createAssignment("Midterm", 0.35, courseCode);
                instructor.createAssignment("Quiz", 0.1, courseCode);
                instructor.createAssignment("Final", 0.4, courseCode);
                
                   
                System.out.println("-------------------------------------------------------------");
            }
             Thread.sleep(500);
                
        }
    }

    public void enrollStudents() throws InterruptedException {
        Random random = new Random();
        for (Instructor instructor : instructors) {
            List<Course> coursesTaught = instructor.getCoursesTaught();
            for (Course course : coursesTaught) {
                String courseCode = course.getCourseCode();
                for (Student student : students) {
                    boolean shouldTake = random.nextBoolean();
                    if (shouldTake) {
                        instructor.enrollStudent(student, courseCode);
                        System.out.println("----------------------------------------");
                    }
                }
            }
            Thread.sleep(1000);
        }
    }

    public void gradeStudents() throws InterruptedException {
        for (Instructor instructor : instructors) {
            List<Course> coursesTaught = instructor.getCoursesTaught();
            for (Course course : coursesTaught) {
                String courseCode = course.getCourseCode();
                for (int i = 0; i < course.getAssignments().size(); i++) {
                    instructor.giveAssignment(courseCode, i);
                    System.out.println("----------------------------------------");
                }
            }
        }
    }

    public void printCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }
    
    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    public void printInstructors() {
        for (Instructor instructor : instructors) {
            System.out.println(instructor);
        }
    }

}
