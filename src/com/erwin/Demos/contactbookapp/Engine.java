package com.erwin.demos.contactbookapp;

import com.erwin.Demos.contactbookapp.Test;
import com.erwin.Demos.dao.DBoperation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Engine {

    static Scanner s = Main.s;
    public static List<Contact> l = new CopyOnWriteArrayList<Contact>();

    public static void createContact() throws Handler, IOException, FileNotFoundException, ClassNotFoundException, SQLException {

        try {
            int cn;
            do {
                Contact c = new Contact();
                String validName = Test.validatingName();
                if (!validName.equalsIgnoreCase("Not Valid")) {
                    c.setName(validName);
                } else {
                    throw new Handler("Only characters are allowed");
                }
                Long phnNumber = Test.validatingNumber();
                if (phnNumber == 0) {
                    throw new Handler("Enter Only numeric values with exact length of 10");
                } else {
                    c.setPhnnum(phnNumber);
                }
                String email = Test.validatingEmail();
                if (!email.equalsIgnoreCase("Not Valid")) {
                    c.setEmail(email);
                } else {
                    throw new Handler("Please enter Valid email formate myEmail371@***.com");
                }
                boolean b = DBoperation.insertData(c);
                if (b) {
                    System.out.println("Succ");
                } else {
                    System.out.println("fail");
                }
                l.add(c);
                System.out.println("Contact saved successfully");
                System.out.println("if you want to continue press 1 or press 0");
                cn = s.nextInt();
            } while (cn == 1);
            Main.runMenu();
        } catch (Handler e) {
            System.out.println(e.getWarning());
            createContact();
        }
    }

    public static void serach(int i) {
        int cn = 0;
        try {
            do {

                if (i == 1) {
                    System.out.println("enter number");
                    long num = s.nextLong();
                    List<Contact> r = l.stream().filter(p -> p.getPhnnum() == num).collect(Collectors.toList());
                    System.out.println(r);
                    Main.runMenu();
                } else if (i == 2) {
                    System.out.println("enter name");
                    String name = s.next();
                    List<Contact> rr = l.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
                    System.out.println(rr);
                    System.out.println("if you want to continue press 1 or press 0");
                    cn = s.nextInt();
                } else {

                }
            } while (cn == 1);
            Main.runMenu();
        } catch (Exception e) {
            System.out.println("check your input and give");
            serach(i);
        }

    }

    public static void deletContact(int i) {
        int cn = 0;
        try {
            do {
                if (i == 2) {
                    System.out.println("enter number of contact to be delete");
                    long num = s.nextLong();
                    l.stream().filter(p -> p.getPhnnum() == num).forEach(c -> {
                        l.remove(c);
                    });
                    System.out.println("do you want to delete permenantly 1)yes 2)No");
                    int yes = s.nextInt();
                    if (yes == 1) {
                        try {
                            boolean b = DBoperation.deleteData(2, Long.toString(num));
                            if (b) {
                                System.out.println("deleted from datdabase");
                            } else {
                                System.out.println("Error");
                            }
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        System.out.println("deleted temparaly");
                    }

                    System.out.println("want to continue press 1 or press 0");
                    cn = s.nextInt();
                } else {
                    System.out.println("enter Name to be delete ");
                    String name = s.next();

                    l.stream().filter(p -> p.getName().equalsIgnoreCase(name)).forEach(c -> {
                        l.remove(c);
                        System.out.println("do you want to delete permenantly 1)yes 2)No");
                        int yes = s.nextInt();
                        if (yes == 1) {
                            try {
                                boolean b = DBoperation.deleteData(2, name);
                                if (b) {
                                    System.out.println("deleted from datdabase");
                                } else {
                                    System.out.println("Error");
                                }
                            } catch (ClassNotFoundException | SQLException | IOException ex) {
                                Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            System.out.println("deleted temparaly");
                        }
                    });
                    System.out.println("want to continue press 1 or press 0");
                    cn = s.nextInt();
                }
            } while (cn == 1);

            Main.runMenu();
        } catch (Exception e) {

            System.out.println("\"\\t\\t\\t\\t\\t\\tcheck your input and give");
            deletContact(i);

        }

    }

    public static void upDate(int i) {

        try {
            if (i == 1) {
                System.out.println("enter number of the contact  to be update");
                long num = s.nextLong();
                List<Contact> lc = l.stream().filter(p -> p.getPhnnum() == num).collect(Collectors.toList());
                System.out.print(" and what do you want to update 1)number 2)name 3) Email");
                int u = s.nextInt();
                if (u == 1) {
                    System.out.println("enter number");
                    long unum = s.nextLong();
                    DBoperation.upDDb(lc.get(0), Long.toString(unum), 1);
                    l.stream().filter(p -> p.getPhnnum() == num).forEach(c -> c.setPhnnum(unum));
                    System.out.println("\t\t\t\t\t\tContact Upadte sucssefully");
                    Main.runMenu();
                }
                if (u == 2) {
                    System.out.println("enter Name");
                    String uname = s.next();
                    DBoperation.upDDb(lc.get(0), uname, 2);
                    l.stream().filter(p -> p.getPhnnum() == num).forEach(c -> c.setName(uname));

                    System.out.println("Contact Upadte sucssefully");
                    Main.runMenu();
                }
                if (u == 3) {
                    System.out.println("enter Email");
                    String uemail = s.next();
                    DBoperation.upDDb(lc.get(0), uemail, 3);
                    l.stream().filter(p -> p.getPhnnum() == num).forEach(c -> c.setEmail(uemail));
                    System.out.println("Contact Upadte sucssefully");
                    Main.runMenu();
                }

            } else if (i == 2) {
                System.out.println("enter Name of the contact to be update");
                String name = s.next();
                List<Contact> cl = l.stream().filter(p -> (p.getName() == null ? name == null : p.getName().equals(name))).collect(Collectors.toList());
                System.out.println(cl.get(0));
                System.out.print(" and what do you want to update 1)number 2)name 3) Email");
                int u = s.nextInt();
                if (u == 1) {
                    System.out.println("enter number");
                    long unum = s.nextLong();
                    DBoperation.upDDb(cl.get(0), Long.toString(unum), 1);
                    l.stream().filter(p -> p.getName().equals(name)).forEach(c -> c.setPhnnum(unum));
                    System.out.println("Contact Upadte sucssefully");
                    Main.runMenu();
                }
                if (u == 2) {
                    System.out.println("enter Name");
                    String uname = s.next();                
                    DBoperation.upDDb(cl.get(0), uname, 2);
                        System.out.println(uname+"  name is");
                    l.stream().filter(p -> p.getName().equals(name)).forEach(c -> c.setName(uname));
                    System.out.println("Contact Upadte sucssefully");
                    Main.runMenu();
                }
                if (u == 3) {
                    System.out.println("enter Email");
                    String uemail = s.next();
                    DBoperation.upDDb(cl.get(0), uemail, 3);
                    l.stream().filter(p -> p.getName().equals(name)).forEach(c -> c.setEmail(uemail));
                    System.out.println("Contact Upadte sucssefully");
                    Main.runMenu();
                }
            }
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(  e.getStackTrace());
            upDate(i);
        }

    }

    public static void viewContacts() throws IOException, FileNotFoundException, ClassNotFoundException {
        if (l.isEmpty()) {
            System.out.println("No_____Contacts !");

        } else {
            l.stream().forEach(e -> System.out.println(e.getName() + " " + e.getPhnnum() + " " + e.getEmail()));
        }
        Main.runMenu();

    }

}
