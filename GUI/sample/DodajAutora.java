package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DodajAutora {
    Connection connection;
    Statement statement;
    @FXML
    TextField imie;
    @FXML
    TextField nazwisko;
    @FXML
    Button button;

    @FXML
    public void initialize() throws SQLException {
        connection =
                DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB","sys as sysdba","Oradoc_db1");

        statement = connection.createStatement();

    }
    @FXML
    public void dodajCzytelnikaDoBazy() {

        String query = "INSERT INTO autorzy VALUES (autorzy_seq.nextval, '"+imie.getText()+"', '"+nazwisko.getText()+"')";
        try {
            statement.executeQuery(query);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void dispose(){
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }


}

