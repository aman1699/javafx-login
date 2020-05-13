package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    public TextField userNam;
    public PasswordField Passwo;

    public void upClicked(ActionEvent event){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://mydb.ctmbums33jwn.ap-south-1.rds.amazonaws.com/postgres", "postgres", "postgres")) {
            System.out.println("Connected to PostgreSQL database!");
            String sql = "UPDATE logintemp SET password=?, username=?, WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            String user;
            String pass;
            user = userNam.getText();
            pass = Passwo.getText();
            statement.setString(1, user);
            statement.setString(2, pass);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
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
