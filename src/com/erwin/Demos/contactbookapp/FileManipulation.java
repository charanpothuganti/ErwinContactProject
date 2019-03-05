package com.erwin.Demos.contactbookapp;

import com.erwin.demos.contactbookapp.Contact;
import com.erwin.demos.contactbookapp.Engine;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileManipulation {
   



    public static void writeToFile() throws FileNotFoundException, IOException {

        try {   
            ObjectOutputStream oos;
            try (FileOutputStream fos = new FileOutputStream(StoreAndLoadProperties.gettingProperties())) {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(Engine.l);
            }
oos.close();
            System.out.println(Engine.l);
        } catch (IOException h) {
            System.out.println("error occured");
        }
      

    }
    public static void readThroughFile() throws FileNotFoundException, IOException, ClassNotFoundException{
         
         
       
        FileInputStream fis=new FileInputStream(StoreAndLoadProperties.gettingProperties());
        ObjectInputStream ois=new ObjectInputStream(fis);
        Engine.l=(List<Contact>)ois.readObject();
        fis.close();
        ois.close();
    }

}
