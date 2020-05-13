package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Control1 implements Initializable {

    public TextField newUSer;
    public PasswordField Passw;
    @FXML
    private Label Create;

    public void anotherClicked(ActionEvent event) {

        System.out.println("button2 clicked");
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://mydb.ctmbums33jwn.ap-south-1.rds.amazonaws.com/postgres", "postgres", "postgres")) {
            System.out.println("Connected to PostgreSQL database!");
            String sql = "INSERT INTO logintemp (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            String user;
            String pass;
            user = newUSer.getText();
            pass = Passw.getText();
            statement.setString(1, user);
            statement.setString(2, pass);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }


        }
        catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
