/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erwin.Demos.dbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mallick
 */
public class DataBaseConnection {
    
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection con=null;
        try {
            DBDetails.getProperties();
        } catch (IOException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(DBDetails.Driver);
        com.microsoft.sqlserver.jdbc.SQLServerDriver s;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Cantact_Table","sa","goanalytix@1");
        return con;
        
        
        
    }
   
        
        

   
  
    
    
    
    
    
    
    
    
    
    
}
