/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erwin.Demos.contactbookapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Mallick
 */
public class StoreAndLoadProperties {

    public static void storingProperties() throws FileNotFoundException, IOException {

        FileOutputStream fos = new FileOutputStream("C:\\Users\\Mallick\\Documents\\NetBeansProjects\\Projects\\JavaProjects\\src\\com\\erwin\\Demos\\info.properties");
        Properties p = new Properties();
        p.setProperty("path", "demo.txt");
        p.store(fos, null);
        fos.close();

    }

    static String gettingProperties() throws FileNotFoundException, IOException {

        Properties p = new Properties();
        FileInputStream fisp = new FileInputStream("C:\\Users\\Mallick\\Documents\\NetBeansProjects\\Projects\\ContactBookDb\\src\\com\\erwin\\Demos\\info.properties");
        p.load(fisp);
        String path = p.getProperty("path");
        System.out.println(path);
        return path;
    }

}
