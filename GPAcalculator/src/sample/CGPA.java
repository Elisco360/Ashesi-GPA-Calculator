package sample;

import java.util.ArrayList;

public class CGPA {

    public double cAverages(ArrayList<Double> averages){
        int numberOfSemesters = averages.size();
        double avg = 0.0;
        int sems = 0;
        for(int i=0; i < numberOfSemesters; i++){
            if(averages.get(i) != 0.0){ avg+=averages.get(i); sems++; }
        }
        double f = avg/sems;
        if(f != 4.0 && sems > 1){f = f+0.01;}
        f = (double) Math.round((f)*100)/100;
        System.out.println(f);
        return f;
    }

}
