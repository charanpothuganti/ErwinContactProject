/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erwin.Demos.dao;

import com.erwin.Demos.dbc.DataBaseConnection;
import com.erwin.demos.contactbookapp.Contact;
import com.erwin.demos.contactbookapp.Engine;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mallick
 */
public class DBoperation {

    public static boolean insertData(Contact c) throws ClassNotFoundException, SQLException, IOException {

        Connection con =  DataBaseConnection.getConnection();
        System.out.println(con);
        PreparedStatement pst = con.prepareStatement("insert into  contactbook values(?,?,?)");
        pst.setString(1, c.getName());
        pst.setLong(2, c.getPhnnum());
        pst.setString(3, c.getEmail());
        int i = pst.executeUpdate();
        if (i != 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void getData() throws SQLException, ClassNotFoundException, IOException {

        Connection con = DataBaseConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("select * from contactbook");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Contact c = new Contact();
            c.setName(rs.getString(1));
            c.setPhnnum(rs.getLong(2));
            c.setEmail(rs.getString(3));
            Engine.l.add(c);
        }
        if (!rs.next()) {
            System.out.println("no data");
        }
    }
       
    public static boolean deleteData(int i, String value) throws ClassNotFoundException, SQLException, IOException {
        Connection con = DataBaseConnection.getConnection();
        int d = 0;
        PreparedStatement pst = null;
        if (i == 1) {
            pst = con.prepareStatement("delete from contactbook where name=?");
            pst.setString(1, value);
            d = pst.executeUpdate();
        } else if (i == 2) {
            pst = con.prepareStatement("delete from contactbook where phonenumber=?");
            pst.setLong(1, Long.parseLong(value));
            d = pst.executeUpdate();
        }
        if (d != 0) {
            return true;
        }
        else
            return false;
       
         
         
         
         
         
    
        }

    public static void upDDb() {
        
    }
    }


