/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erwin.demos.contactbookapp;

/**
 *
 * @author Mallick
 */
public class Handler extends Exception {


   String Warning;

    public Handler(String Warning) {
        this.Warning = Warning;
    }

    public String getWarning() {
        return Warning;
    }
   
}
