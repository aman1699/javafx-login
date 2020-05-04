package sample;



import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author nipun
 */
public class Controller<La> implements Initializable {

    @FXML
    private Pane visible;

    public void Clicked(ActionEvent event){
        System.out.println("button clicked");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
