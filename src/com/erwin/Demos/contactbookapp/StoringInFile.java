
package com.erwin.Demos.contactbookapp;

import com.erwin.demos.contactbookapp.Contact;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class StoringInFile {
    
   public static List<Contact> l=new CopyOnWriteArrayList<Contact>();
   
   
 public static void writeToFile() throws FileNotFoundException, IOException{
     
     
     
     try{
         
         File f = new File("C:\\Users\\twins\\Documents\\NetBeansProjects\\ErwinContactProject\\src\\com\\erwin\\Demos\\contactbookapp\\StorageForContacts.txt");
     FileOutputStream fos=new FileOutputStream(f);
     ObjectOutputStream oos=new ObjectOutputStream(fos);
     oos.writeObject(l);
     }catch(IOException h){
     }
     
         
     
    
}
  
  
  
  
    
    
    
  
    
    
}
