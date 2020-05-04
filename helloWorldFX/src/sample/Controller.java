package sample;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author nipun
 */
public class Controller<La> implements Initializable {

    @FXML
    private Pane visible;
    private Object Node;

    public void Clicked(ActionEvent event) throws IOException {

        System.out.println("button clicked");
        Parent home_page_parent= FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene home_page_scene=new Scene(home_page_parent);
        Stage app_Stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_Stage.setScene(home_page_scene);
        app_Stage.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
