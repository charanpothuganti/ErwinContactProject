/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erwin.Demos.contactbookapp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mallick
 */
public class Test {

    static Scanner s = new Scanner(System.in);

    public static String validatingName() {
        {

            int okay = 0;
            System.out.println("entee name");
            String name = s.next();
            try {
                int n = Integer.parseInt(name);
            } catch (Exception e) {
                okay = 1;
            }
            if (okay == 1) {
                Pattern namePattern = Pattern.compile("[A-za-z]");
                Matcher matchName = namePattern.matcher(name);
                if (matchName.find()) {
                    return name;
                } else {

                    return "Not Valid";

                }
            }
            return "Not Valid";

        }
    }

    public static long validatingNumber() {
        long num = 0;
        System.out.println("enter numbe");
        try {
            num = s.nextLong();
        } catch (Exception e) {
            return 0;
        }
        if (Long.toString(num).length() == 0 || Long.toString(num).length() < 10) {
            return 0;
        } else {
            return num;
        }
    }

    public static String validatingEmail() {

        System.out.println("enter email");
        String email = s.next();
        Pattern emailPattern = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
        Matcher matchEmail = emailPattern.matcher(email);
        if (matchEmail.find()) {
            return email;
        }
        return "Not Valid";
    }
}
