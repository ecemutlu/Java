
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alper
 */
public class Student extends User {

    private int StudentID;
    private static int STUDENT_COUNTER = 1;
    private List<String> enrolledCourses;

    public Student(String name, String surname) {
        super(name, surname);
        this.StudentID = STUDENT_COUNTER;
        STUDENT_COUNTER++;
        this.enrolledCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return StudentID;
    }

    public void enrollStudent(String courseID) {
        this.enrolledCourses.add(courseID);
    }
    
    
    public StudentScore solveAssignment(Assignment a){
        int randomScore = new Random().nextInt(0,101);
        System.out.println(this.StudentID+" "+this.getName()+" "
                +this.getSurname()+" got "+randomScore+" from "+a.getAssignment_name()+" Assignment");
        return new StudentScore(this, a, randomScore);
    }
    

    @Override
    public String toString() {
        return "Student{" + "StudentID=" + StudentID + '}' + super.toString();
    }

}
