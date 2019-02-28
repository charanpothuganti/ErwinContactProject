/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erwin.demos.contactbookapp;

import com.erwin.Demos.contactbookapp.FileManipulation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mallick
 */
public class Main {
     FileManipulation f=new FileManipulation();
  
      public static Scanner s = new Scanner(System.in);
    
   enum Option{
       ADD_CONTACT,FIND_CONTACT,REMOVE_CONTACT,UPDATE_CONTACT,CONTACTS,TERMINATE;
   }
   
   

    public void header() {
        System.out.println("+-----------------------------------+");
        System.out.println("|        Welcome Customer           |");
        System.out.println("|        Erwin Contact book         |");
        System.out.println("+-----------------------------------+");
    }
 
    static public void runMenu() throws IOException, FileNotFoundException, ClassNotFoundException {
        int n=0;
   
        System.out.println("1) Add Contact");
        System.out.println("2) Find Contact");
        System.out.println("3) Remove Contact");
        System.out.println("4) Update Contact");
        System.out.println("5)  Contacts ");
        System.out.println("6) Terminate\n");
        System.out.println("\t\t\t\t\tPlease make a selection");
        
        try{
        n = s.nextInt();
        }catch(Exception e){
            System.out.println("please Entre valid option with numeric Input");
        
        }
        if(n>Option.values().length)
        {
            System.out.println("invalid option ");
            runMenu();
        }
       Option menu= Option.values()[n-1];
        while(true) {
        switch (menu) {
            case ADD_CONTACT:
                try {
                    Engine.createContact();
                } catch (Handler h) {
                    System.out.println("" + h.getWarning());
                }
                break;
            case FIND_CONTACT:
                System.out.println("1) Serch by number ");
                System.out.println("2) Serch by Name ");
                int i = s.nextInt();
                Engine.serach(i);
                break;
            case REMOVE_CONTACT:
                System.out.println("1)delete by number");
                System.out.println("2)delete by Name");
                int nd = s.nextInt();
                Engine.deletContact(nd);
                break;

            case UPDATE_CONTACT:
                System.out.println("1) Upadate by  number ");
                System.out.println("2) Update by  Name ");
                System.out.println("2) Update by Email ");

                int u = s.nextInt();
                Engine.upDate(u);
                break;
            case CONTACTS:
                Engine.viewContacts();
                break;
            case TERMINATE:
                FileManipulation.writeToFile();
                System.exit(0);

        }
        }
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        
          FileManipulation.readThroughFile();
        Main m = new Main();
        m.header();
        runMenu();
       

    }

}
