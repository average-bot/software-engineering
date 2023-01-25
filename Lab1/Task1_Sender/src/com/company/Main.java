package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import javafx.scene.control.Label;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        String filename = "../label.ser";
        if(args.length > 0){
            filename = args[0];
        }
        Label helloLabel = new Label("hello world");
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);

            out.writeObject(helloLabel);
            out.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
