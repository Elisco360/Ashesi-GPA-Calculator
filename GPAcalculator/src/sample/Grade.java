package sample;

import java.util.HashMap;

public class Grade {
    private HashMap<String, Double> grade = new HashMap<String, Double>();

    public Grade(){
        grade.put("-", 0.0);
        grade.put("A+", 4.0);
        grade.put("A", 4.0);
        grade.put("B+", 3.5);
        grade.put("B", 3.0);
        grade.put("C+", 2.5);
        grade.put("C", 2.0);
        grade.put("D+", 1.5);
        grade.put("D", 1.0);
        grade.put("E", 0.5);
    }

    public double studentGrade(String letterGrade){
        return grade.get(letterGrade);
    }
}
