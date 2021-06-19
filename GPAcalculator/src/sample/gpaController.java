package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;

public class gpaController implements Initializable {
    @FXML private ComboBox<String> courseOne;
    @FXML private ComboBox<String> courseTwo;
    @FXML private ComboBox<String> courseThree;
    @FXML private ComboBox<String> courseFour;
    @FXML private ComboBox<String> courseFive;
    @FXML private ComboBox<String> courseSix;
    @FXML private ComboBox<String> gradeOne;
    @FXML private ComboBox<String> gradeTwo;
    @FXML private ComboBox<String> gradeThree;
    @FXML private ComboBox<String> gradeFour;
    @FXML private ComboBox<String> gradeFive;
    @FXML private ComboBox<String> gradeSix;
    @FXML private Arc pie;
    @FXML private Text fGpa = new Text("0.0");
    @FXML private Group gpaDoctor;

    Course c = new Course();
    Grade gd = new Grade();
    GPA gpa = new GPA();
    Set keys = c.course.keySet();
    ArrayList<String> userCourses = new ArrayList<>(6);
    ArrayList<String> userGrades = new ArrayList<>(6);
    ObservableList<String> courseNames = FXCollections.observableArrayList();
    ObservableList<String> letterGrades = FXCollections.observableArrayList("-","A+","A","B+","B","C+","C","D+","D","E");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courseList(keys);
        courseOne.setItems(courseNames);
        courseTwo.setItems(courseNames);
        courseThree.setItems(courseNames);
        courseFour.setItems(courseNames);
        courseFive.setItems(courseNames);
        courseSix.setItems(courseNames);
        gradeOne.setItems(letterGrades);
        gradeTwo.setItems(letterGrades);
        gradeThree.setItems(letterGrades);
        gradeFour.setItems(letterGrades);
        gradeFive.setItems(letterGrades);
        gradeSix.setItems(letterGrades);
        for(int i=0; i < 6; i++){
            userCourses.add(i, "-");
            userGrades.add(i, "-");
        }
    }

    public void handleCourseOne(){
        userCourses.remove(0);
        String c1 = courseOne.getValue();
        if(userCourses.contains(c1)){
          alert();
        }
        userCourses.add(0, c1);
    }
    public void handleCourseTwo(){
        userCourses.remove(1);
        String c2 = courseTwo.getValue();
        if(userCourses.contains(c2)){
            alert();
        }
        userCourses.add(1, c2);
    }
    public void handleCourseThree(){
        userCourses.remove(2);
        String c3 = courseThree.getValue();
        if(userCourses.contains(c3)){
            alert();
        }
        userCourses.add(2, c3);
    }
    public void handleCourseFour(){
        userCourses.remove(3);
        String c4 = courseFour.getValue();
        if(userCourses.contains(c4)){
            alert();
        }
        userCourses.add(3, c4);
    }
    public void handleCourseFive(){
        userCourses.remove(4);
        String c5 = courseFive.getValue();
        if(userCourses.contains(c5)){
            alert();
        }
        userCourses.add(4, c5);
    }
    public void handleCourseSix(){
        userCourses.remove(5);
        String c6 = courseSix.getValue();
        if(userCourses.contains(c6)){
            alert();
        }
        userCourses.add(5, c6);
    }

    public void handleGradeOne(){
        userGrades.remove(0);
        String g = gradeOne.getValue();
        userGrades.add(0, g);
    }
    public void handleGradeTwo(){
        userGrades.remove(1);
        String g = gradeTwo.getValue();
        userGrades.add(1, g);
    }
    public void handleGradeThree(){
        userGrades.remove(2);
        String g = gradeThree.getValue();
        userGrades.add(2, g);
    }
    public void handleGradeFour(){
        userGrades.remove(3);
        String g = gradeFour.getValue();
        userGrades.add(3, g);
    }
    public void handleGradeFive(){
        userGrades.remove(4);
        String g = gradeFive.getValue();
        userGrades.add(4, g);
    }
    public void handleGradeSix(){
        userGrades.remove(5);
        String g = gradeSix.getValue();
        userGrades.add(5, g);
    }

    public void handleCalculateGPA(){
        for(int i=0; i < 6; i++){
            gpa.studentGPA(userCourses.get(i), userGrades.get(i));
        }
        double f = gpa.finalGPA();
        fGpa.setText(Double.toString(f));
        //double v
        this.gpa = new GPA();
        drawPie((f/4.0)*360);
    }

    public void drawPie(double v){
        if(v >= 0 && v < 2.5){
            pie.setFill(Paint.valueOf(String.valueOf(Color.color(1,0,0))));
        }else if (v >= 2.5 && v < 3.5){
            pie.setFill(Paint.valueOf(String.valueOf(Color.color(1,1,0))));
        }else if (v >= 3.5){
            pie.setFill(Paint.valueOf(String.valueOf(Color.color(0,1,0))));
        }
        pie.setLength(v);
    }

    public void courseList(Set set){
        List<String> s = sortSet(set);
        courseNames.addAll(s);
    }

    public List<String> sortSet(Set set){
        ArrayList<String> list = new ArrayList<>(set);
        int count = list.size();
        for (int i = 0; i < count; i++)
        {
            for (int j = i + 1; j < count; j++) {
                if (list.get(i).compareTo(list.get(j))>0)
                {
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    private void alert(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Repeated Choice");
        a.setHeaderText("This course has been selected");
        a.setContentText("You can choose to proceed with this selection.\nIt would not affect the functionality of the program.");
        a.showAndWait();
    }
}
