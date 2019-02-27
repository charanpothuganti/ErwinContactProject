
package com.erwin.demos.contactbookapp;


public class Handler extends Exception {


   String Warning;

    public Handler(String Warning) {
        this.Warning = Warning;
    }

    public String getWarning() {
        return Warning;
    }
   
}
