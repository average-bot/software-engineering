package reciever;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sender.Description;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label titleLabel;

    @FXML
    private Label textLabel;

    @FXML
    private Button updateButton;

    @FXML
    void btnUpdateClicked(){
        Description description = getData();
        titleLabel.setText(description.getTitle());
        textLabel.setText(description.getText());
    }


    Description getData(){
        String filename = "../description.ser";
        Description description = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            description = (Description) in.readObject();
            System.out.println(description.getTitle() + " is " + description.getText());
            in.close();
        } catch(FileNotFoundException ex){
            System.out.println("File does not exist");
        } catch(IOException ex){
            ex.printStackTrace();
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return description;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnUpdateClicked();
    }
}
