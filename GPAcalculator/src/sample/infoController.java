package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class infoController implements Initializable {
    @FXML private Hyperlink eli;
    @FXML private Hyperlink dave;
    @FXML private Hyperlink ashesi;
    Desktop d = Desktop.getDesktop();
    String eb = "https://www.linkedin.com/in/elijah-kwaku-adutwum-boateng-074733194/";
    String dq = "https://www.linkedin.com/in/david-quarshie-97ab91194/";
    String ash = "https://www.ashesi.edu.gh/academics/academic-registrar/grading-policies.html";

    public void handleEliClick() throws URISyntaxException, IOException {
        d.browse(new URI(eb));
    }
    public void handleDaveClick() throws URISyntaxException, IOException {
        d.browse(new URI(dq));
    }
    public void handleAshesiClick() throws URISyntaxException, IOException {
        d.browse(new URI(ash));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
