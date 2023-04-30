/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alper
 */
public class StudentScore {
    
    private Student student;
    private Assignment assignment;
    private int Score;

    public StudentScore(Student student, Assignment assignment, int Score) {
        this.student = student;
        this.assignment = assignment;
        this.Score = Score;
    }

    public Student getStudent() {
        return student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public int getScore() {
        return Score;
    }

    @Override
    public String toString() {
        return "StudentScore{" + "student=" + student + ", assignment=" + assignment + ", Score=" + Score + '}';
    }
    
    
    
    
}
