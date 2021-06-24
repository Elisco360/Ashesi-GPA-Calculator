package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static java.lang.Double.parseDouble;

public class cgpaController implements Initializable {
    @FXML private ComboBox<String> semE1;
    @FXML private ComboBox<String> semE2;
    @FXML private ComboBox<String> semE3;
    @FXML private ComboBox<String> semE4;
    @FXML private ComboBox<String> semE5;
    @FXML private ComboBox<String> semE6;
    @FXML private ComboBox<String> semE7;
    @FXML private ComboBox<String> semE8;
    @FXML private TextField semGpa1;
    @FXML private TextField semGpa2;
    @FXML private TextField semGpa3;
    @FXML private TextField semGpa4;
    @FXML private TextField semGpa5;
    @FXML private TextField semGpa6;
    @FXML private TextField semGpa7;
    @FXML private TextField semGpa8;
    @FXML private Text cAvg;
    CGPA cgpa = new CGPA();
    private ArrayList<Double> avgs = new ArrayList<>(8);
    ArrayList<String> userSems = new ArrayList<>(8);
    ObservableList<String> semesters = FXCollections.observableArrayList("1st Year - Semester One","1st Year - Semester Two",
                                                                                "2nd Year - Semester One","2nd Year - Semester Two",
                                                                                "3rd Year - Semester One","3rd Year - Semester Two",
                                                                                "4th Year - Semester One","4th Year - Semester Two");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        semE1.setItems(semesters);
        semE2.setItems(semesters);
        semE3.setItems(semesters);
        semE4.setItems(semesters);
        semE5.setItems(semesters);
        semE6.setItems(semesters);
        semE7.setItems(semesters);
        semE8.setItems(semesters);
        for(int i=0; i <= 8; i++){
            avgs.add(i, 0.0);
            userSems.add(i, "-");
        }
    }

    public void handleEnterGPA1(){
        avgs.remove(0);
        String sgpa = semGpa1.getText();
        if(sgpa.equals("")){ sgpa = "0.0"; }
        avgs.add(0, parseDouble(sgpa));
    }
    public void handleEnterGPA2(){
        avgs.remove(1);
        String sgpa = semGpa2.getText();
        if(sgpa.equals("")){ sgpa = "0.0"; }
        avgs.add(1, parseDouble(sgpa));
    }
    public void handleEnterGPA3(){
        avgs.remove(2);
        String sgpa = semGpa3.getText();
        if(sgpa.equals("")){ sgpa = "0.0"; }
        avgs.add(2, parseDouble(sgpa));
    }
    public void handleEnterGPA4(){
        avgs.remove(3);
        String sgpa = semGpa4.getText();
        if(sgpa.equals("")){ sgpa = "0.0"; }
        avgs.add(3, parseDouble(sgpa));
    }
    public void handleEnterGPA5(){
        avgs.remove(4);
        String sgpa = semGpa5.getText();
        if(sgpa.equals("")){ sgpa = "0.0"; }
        avgs.add(4, parseDouble(sgpa));
    }
    public void handleEnterGPA6(){
        avgs.remove(5);
        String sgpa = semGpa6.getText();
        if(sgpa.equals("")){ sgpa = "0.0"; }
        avgs.add(5, parseDouble(sgpa));
    }
    public void handleEnterGPA7(){
        avgs.remove(6);
        String sgpa = semGpa7.getText();
        if(sgpa.equals("")){ sgpa = "0.0"; }
        avgs.add(6, parseDouble(sgpa));
    }
    public void handleEnterGPA8(){
        avgs.remove(7);
        String sgpa = semGpa8.getText();
        if(sgpa.equals("")){ sgpa = "0.0"; }
        avgs.add(7, parseDouble(sgpa));
    }

    public void handleCalculateCGPA(){
        double t = cgpa.cAverages(avgs);
        cAvg.setText(Double.toString(t));
        this.cgpa = new CGPA();
    }

    public void handleSemOne(){
        userSems.remove(0);
        String c2 = semE1.getValue();
        if(userSems.contains(c2)){
            alert();
        }
        userSems.add(0, c2);
    }
    public void handleSemTwo(){
        userSems.remove(1);
        String c2 = semE2.getValue();
        if(userSems.contains(c2)){
            alert();
        }
        userSems.add(1, c2);
    }
    public void handleSemThree(){
        userSems.remove(2);
        String c3 = semE3.getValue();
        if(userSems.contains(c3)){
            alert();
        }
        userSems.add(2, c3);
         
    }
    public void handleSemFour(){
        userSems.remove(3);
        String c4 = semE4.getValue();
        if(userSems.contains(c4)){
            alert();
        }
        userSems.add(3, c4);
    }
    public void handleSemFive(){
        userSems.remove(4);
        String c5 = semE5.getValue();
        if(userSems.contains(c5)){
            alert();
        }
        userSems.add(4, c5);
    }
    public void handleSemSix(){
        userSems.remove(5);
        String c6 = semE6.getValue();
        if(userSems.contains(c6)){
            alert();
        }
        userSems.add(5, c6);
    }
    public void handleSemSeven(){
        userSems.remove(6);
        String c6 = semE7.getValue();
        if(userSems.contains(c6)){
            alert();
        }
        userSems.add(6, c6);
    }
    public void handleSemEight(){
        userSems.remove(7);
        String c6 = semE8.getValue();
        if(userSems.contains(c6)){
            alert();
        }
        userSems.add(7, c6);
    }

    private void alert(){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Repeated Choice");
        a.setHeaderText("This semester has been selected");
        a.setContentText("You can choose to proceed with this selection.\nIt would not affect the functionality of the program.");
        a.showAndWait();
    }
}
