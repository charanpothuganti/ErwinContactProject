/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erwin.demos.patterns;

import java.util.Scanner;

/**
 *
 * @author Mallick
 */
public class Pattern2 {
    
     public static void main(String[] args){
        System.out.print("enter n valuekk ");
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if((i+j)>n+1)
                {
                     System.out.print("_");
                }
                else
                     System.out.print("*");
            }
              System.out.println(" ");
        }
        }
    
}
