package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        String filename = "../person.ser";
        if(args.length > 0){
            filename = args[0];
        }
        Person person = new Person("Sandra", 22);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(person);
            out.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
