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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
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
    private GridPane grid;
    private Pane visible;
    private Object Node;
    @FXML
    private Label Forgot;
    @FXML
    private Label Create;
    private java.lang.Object Object;


    public void Clicked(ActionEvent event) throws IOException {

        System.out.println("button clicked");
        AnchorPane home_page_parent= FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene home_page_scene=new Scene(home_page_parent);
        Stage app_Stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_Stage.setScene(home_page_scene);
        app_Stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        Object forgot;
        Forgot.setOnMouseClicked(mouseEvent -> {
            System.out.println("button Clicked");

            try {
                AnchorPane home= FXMLLoader.load(getClass().getResource("forgot.fxml"));
                Scene home_page=new Scene(home);

                Stage app1_Stage=(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                app1_Stage.setScene(home_page);
                app1_Stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        Object create;
        Create.setOnMouseClicked(mouseEvent -> {
            System.out.println("button Clicked");

            try {
                AnchorPane home1= FXMLLoader.load(getClass().getResource("create.fxml"));
                Scene home_page1=new Scene(home1);

                Stage app2_Stage=(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                app2_Stage.setScene(home_page1);
                app2_Stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        });



    }
}
