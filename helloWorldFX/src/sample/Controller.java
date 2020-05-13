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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.util.Duration;

public class Controller<La> implements Initializable {

    public TextField loginUser;
    public PasswordField loginPassword;
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
        AnchorPane home_page_parent= FXMLLoader.load(getClass().getResource("Homepage.fxml"));
        Scene home_page_scene=new Scene(home_page_parent);
        Stage app_Stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        String user;
        String pass;
        user = loginUser.getText();
        pass = loginPassword.getText();
        if(checkLogin(user,pass)){
            app_Stage.setScene(home_page_scene);
            app_Stage.show();
        }
    }

    public boolean checkLogin(String id, String pass){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://mydb.ctmbums33jwn.ap-south-1.rds.amazonaws.com/postgres", "postgres", "postgres")) {
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT username,password FROM logintemp where username='avashish'");
            while (resultSet.next()) {
//                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("username"), resultSet.getString("password"));
                if(resultSet.getString("password").equals(pass)){
                    return true;
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
            return false;
        }
        return false;
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
