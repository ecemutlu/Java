
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alper
 */
public class Instructor extends User {

    private List<Course> coursesTaught;

    public Instructor(String name, String surname) {
        super(name, surname);
        this.coursesTaught = new ArrayList<>();
    }

    public void addCourse(Course course) {
        this.coursesTaught.add(course);
    }

    public boolean createAssignment(String assignmentName, double percentage, String courseCode) {
        int resultIndex = findCouseIndex(courseCode);
        if (resultIndex != -1) {
            Course c = this.coursesTaught.get(resultIndex);
            System.out.println("Professor "+this.getSurname()+" prepared an assignment for the course "
                    + ""+c.getCourseCode()+" "+c.getCourseName()+" named :"+assignmentName);
            boolean res = c.addAssignment(new Assignment(assignmentName, percentage));
            return res;
        }
        return false;
    }

    public boolean enrollStudent(Student student, String courseCode) {
        int resultIndex = findCouseIndex(courseCode);
        if (resultIndex != -1) {
            Course c = this.coursesTaught.get(resultIndex);
            System.out.println("Professor "+this.getSurname()+" is enrolling student "
            +student.getStudentID()+" "+student.getName()+" "+student.getSurname()+" to the course "
            +c.getCourseCode()+" "+c.getCourseName());
            boolean res = c.addStudent(student);
            return res;
        }
        return false;
    }
    
    public void giveAssignment(String courseCode, int assignmentInd) throws InterruptedException{
        int resultIndex = findCouseIndex(courseCode);
        if (resultIndex != -1) {
            Course c = this.coursesTaught.get(resultIndex);
            System.out.println("Professor "+this.getSurname()+" Posted Assignment "+c.getAssignments().get(assignmentInd)
                    .getAssignment_name()+" on the course "+c.getCourseCode()+" "+c.getCourseName()+" for students to solve!");
            System.out.println("");
            Thread.sleep(1000);
            for (int i = 0; i < c.getStudents().size(); i++) {
                Student next = c.getStudents().get(i);
                StudentScore score = next.solveAssignment(c.getAssignments().get(assignmentInd));
                c.addStudentScore(score);
            }
        }
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }
    

    private int findCouseIndex(String courseCode) {
        int resultIndex = -1;
        for (int i = 0; i < this.coursesTaught.size(); i++) {
            if (coursesTaught.get(i).getCourseCode().equalsIgnoreCase(courseCode)) {
                resultIndex = i;
                return resultIndex;
            }
        }
        return resultIndex;
    }

}
