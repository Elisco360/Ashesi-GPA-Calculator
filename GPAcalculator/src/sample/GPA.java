package sample;

import java.math.*;
import java.util.ArrayList;

public class GPA {
    private ArrayList<Double> grades;
    private ArrayList<Double> creditHours;
    private Grade g;
    private Course c;

    public GPA(){
        this.grades = new ArrayList<>();
        this.creditHours = new ArrayList<>();
        this.g = new Grade();
        this.c = new Course();
    }

    public void studentGPA(String course, String grade){
        grades.add(g.studentGrade(grade));
        creditHours.add(c.studentCourse(course));
    }

    public double finalGPA(){
        ArrayList<Double> gradePoints = new ArrayList<>();;
        for(int i=0; i < creditHours.size(); i++){
            gradePoints.add(creditHours.get(i)*grades.get(i));
        }

        double totalCreditHours = 0.0;
        for(int j=0; j < creditHours.size(); j++){
            totalCreditHours+=creditHours.get(j);
        }

        double totalGradePoints = 0.0;
        for(int j=0; j < grades.size(); j++){
            totalGradePoints += gradePoints.get(j);
        }

        double gpa = (double)Math.round((totalGradePoints/totalCreditHours)*100)/100;
        return gpa;
    }
}
