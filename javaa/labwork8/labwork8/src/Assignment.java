/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alper
 */
public class Assignment {
    private String assignment_name;
    private double percentage;
  
    public Assignment(String assignment_name, double percentage) {
        this.assignment_name = assignment_name;
        this.percentage = percentage;
      
    }

    public String getAssignment_name() {
        return assignment_name;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "Assignment{" + "assignment_name=" + assignment_name + ", percentage=" + percentage + '}';
    }

  

    
    
    
    
}
