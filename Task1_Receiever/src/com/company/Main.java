package com.company;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String [] args){
        String filename = "../person.ser";
        if(args.length > 0) {
            filename = args[0];
        }
        Person person = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            person = (Person) in.readObject();
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
            in.close();
        } catch(IOException ex){
            ex.printStackTrace();
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
