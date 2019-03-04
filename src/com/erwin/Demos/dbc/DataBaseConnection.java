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


public class DataBaseConnection {
    
    
//    private static BasicDataSource dataSource;
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException{

       Connection con=null;
       try{
          DBDetails.getProperties();  
    } catch (IOException ex) {
          Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        Class.forName(DBDetails.Driver);
       con=DriverManager.getConnection(DBDetails.url,"sa","goanalytix@1");
  return con;
   
    }
  

   
  
    
    
    
    
    
    
    
    
    
    
}
