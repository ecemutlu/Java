
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
public class Course {
    private String courseCode;
    private String courseName;
    private List<Assignment> assignments;
    private double totalPercentage;
    private List<Student> students;
    private int studentQuota;
    private List<StudentScore> studentScores;

    public Course(String courseCode, String courseName,int studentQuta) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.totalPercentage  = 0;
        this.studentQuota = studentQuta;
        this.assignments = new ArrayList<>();
        this.students = new ArrayList<>();
        this.studentScores = new ArrayList<>();
    }
    
    public boolean addAssignment(Assignment newAssignment){
       if(totalPercentage <= 1.0){
           if(totalPercentage + newAssignment.getPercentage() <= 1.0){
               this.assignments.add(newAssignment);
               this.totalPercentage += newAssignment.getPercentage();
               System.out.println("Assignment "+newAssignment.getAssignment_name()+" added with "
                       + newAssignment.getPercentage()*100+"% weight to the course "+this.courseCode+" "+this.courseName);
               return true;
           }
           else{
               return false;
           }
       }
       else{
           return false;
       }
    }
    
    public boolean addStudent(Student student){
        if(studentQuota > 0){
            String ANSI_GREEN = "\u001B[32m";

            this.students.add(student);
            student.enrollStudent(this.courseCode);
            this.studentQuota--;
            System.out.println(ANSI_GREEN+student.getStudentID()+" "+student.getName()+" "+student.getSurname()
            +" enrolled into the course :"+this.courseCode+" "+this.courseName);
            return true;
        }
        String ANSI_RED = "\u001B[31m";
         System.out.println(ANSI_RED+student.getStudentID()+" "+student.getName()+" "+student.getSurname()
            +" could not enroll into the course :"+this.courseCode+" "+this.courseName+" Semester Quota Full!");
        return false;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentQuota() {
        return studentQuota;
    }

    public List<StudentScore> getStudentScores() {
        return studentScores;
    }
    
    public void addStudentScore(StudentScore score){
        this.studentScores.add(score);
    }
    
   

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public double getTotalPercentage() {
        return totalPercentage;
    }

    @Override
    public String toString() {
        return "Course{" + "courseCode=" + courseCode + ", courseName=" + courseName + ", totalPercentage=" + totalPercentage + '}';
    }
    
    
    
    
    
}
