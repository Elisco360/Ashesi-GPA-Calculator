package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.*;

public class gpaController implements Initializable {
    @FXML private ComboBox<String> courseOne;
    @FXML private ComboBox<String> courseTwo;
    @FXML private ComboBox<String> courseThree;
    @FXML private ComboBox<String> courseFour;
    @FXML private ComboBox<String> courseFive;
    @FXML private ComboBox<String> courseSix;
    @FXML private TextField creditOne;
    @FXML private TextField creditTwo;
    @FXML private TextField creditThree;
    @FXML private TextField creditFour;
    @FXML private TextField creditFive;
    @FXML private TextField creditSix;
    @FXML private ComboBox<String> gradeOne;
    @FXML private ComboBox<String> gradeTwo;
    @FXML private ComboBox<String> gradeThree;
    @FXML private ComboBox<String> gradeFour;
    @FXML private ComboBox<String> gradeFive;
    @FXML private ComboBox<String> gradeSix;
    @FXML private TextField gpOne;
    @FXML private TextField gpTwo;
    @FXML private TextField gpThree;
    @FXML private TextField gpFour;
    @FXML private TextField gpFive;
    @FXML private TextField gpSix;
    @FXML private Text fgpa;
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
        creditOne. setText(Double.toString(c.studentCourse(c1)));
        userCourses.add(0, c1);
    }
    public void handleCourseTwo(){
        userCourses.remove(1);
        String c2 = courseTwo.getValue();
        if(userCourses.contains(c2)){
            alert();
        }
        creditTwo. setText(Double.toString(c.studentCourse(c2)));
        userCourses.add(1, c2);
    }
    public void handleCourseThree(){
        userCourses.remove(2);
        String c3 = courseThree.getValue();
        if(userCourses.contains(c3)){
            alert();
        }
        creditThree. setText(Double.toString(c.studentCourse(c3)));
        userCourses.add(2, c3);
    }
    public void handleCourseFour(){
        userCourses.remove(3);
        String c4 = courseFour.getValue();
        if(userCourses.contains(c4)){
            alert();
        }
        creditFour. setText(Double.toString(c.studentCourse(c4)));
        userCourses.add(3, c4);
    }
    public void handleCourseFive(){
        userCourses.remove(4);
        String c5 = courseFive.getValue();
        if(userCourses.contains(c5)){
            alert();
        }
        creditFive. setText(Double.toString(c.studentCourse(c5)));
    }
    public void handleCourseSix(){
        userCourses.remove(5);
        String c6 = courseSix.getValue();
        if(userCourses.contains(c6)){
            alert();
        }
        creditSix. setText(Double.toString(c.studentCourse(c6)));
        userCourses.add(5, c6);
    }

    public void handleGradeOne(){
        userGrades.remove(0);
        String g = gradeOne.getValue();
        gpOne.setText(Double.toString(gd.studentGrade(g)));
        userGrades.add(0, g);
    }
    public void handleGradeTwo(){
        userGrades.remove(1);
        String g = gradeTwo.getValue();
        gpTwo. setText(Double.toString(gd.studentGrade(g)));
        userGrades.add(1, g);
    }
    public void handleGradeThree(){
        userGrades.remove(2);
        String g = gradeThree.getValue();
        gpThree. setText(Double.toString(gd.studentGrade(g)));
        userGrades.add(2, g);
    }
    public void handleGradeFour(){
        userGrades.remove(3);
        String g = gradeFour.getValue();
        gpFour. setText(Double.toString(gd.studentGrade(g)));
        userGrades.add(3, g);
    }
    public void handleGradeFive(){
        userGrades.remove(4);
        String g = gradeFive.getValue();
        gpFive. setText(Double.toString(gd.studentGrade(g)));
        userGrades.add(4, g);
    }
    public void handleGradeSix(){
        userGrades.remove(5);
        String g = gradeSix.getValue();
        gpSix. setText(Double.toString(gd.studentGrade(g)));
        userGrades.add(5, g);
    }

    public void handleCalculateGPA(){
        for(int i=0; i < 6; i++){
            gpa.studentGPA(userCourses.get(i), userGrades.get(i));
        }
        double f = gpa.finalGPA();
        fgpa.setText(Double.toString(f));
        this.gpa = new GPA();
    }

    public void courseList(Set set){
        System.out.println(set);
        List<String> s = sortSet(set);
        System.out.println(s);
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
