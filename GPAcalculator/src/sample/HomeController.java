package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML private BorderPane mainPane;

    @FXML
    public void handleGPAClick(ActionEvent e){
        FxmlLoader ldr = new FxmlLoader();
        Pane view = ldr.getPage("gpa.fxml");
        mainPane.setCenter(view);
    }

    @FXML
    public void handleCGPAClick(ActionEvent e){
        FxmlLoader ldr = new FxmlLoader();
        Pane view = ldr.getPage("cgpa.fxml");
        mainPane.setCenter(view);
    }

    @FXML
    public void handleInfoClick(ActionEvent e){
        FxmlLoader ldr = new FxmlLoader();
        Pane view = ldr.getPage("info.fxml");
        mainPane.setCenter(view);
    }

    @FXML
    public void handleDocClick(ActionEvent e){
        FxmlLoader ldr = new FxmlLoader();
        Pane view = ldr.getPage("doc.fxml");
        mainPane.setCenter(view);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
