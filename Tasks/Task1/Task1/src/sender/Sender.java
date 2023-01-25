package sender;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Sender {
    public static void main(String[] args) {
        String filename = "../description.ser";
        if(args.length > 0){
            filename = args[0];
        }
        Description description = new Description("Mooh Pooh Rarr","Zoo");
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(description);
            out.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
