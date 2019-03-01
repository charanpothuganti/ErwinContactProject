/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erwin.Demos.dbc;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Mallick
 */
public class DBDetails {
    
    
    public static String url;
    public static String Driver;
    
    public static void getProperties() throws FileNotFoundException, IOException{
    FileInputStream fis=new FileInputStream("C:\\Users\\Mallick\\Documents\\NetBeansProjects\\Projects\\ContactBookDb\\src\\com\\erwin\\Demos\\info.properties");
    Properties p=new Properties();
    p.load(fis);
    url=p.getProperty("url");
    Driver=p.getProperty("driver");
      
    
    }
    
 
    
    
    
    
    
}
