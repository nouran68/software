/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toffeestore;

import java.io.Serializable;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Admin extends User implements Serializable {

    private String password;
    private boolean loogedIn = false;

    /**
     *
     */
    public Admin() {
    }
/**
 *Constructor for setting admin attributes
 * @param email
 * @param password
 * @param name
 */
    public Admin(String email, String password,String name) {
        this.Email = email;
        this.password = password;
        this.name = name;
    }
/**
 *function for setting logged in 
 * @param c
 */
    public void setLoogedIn(boolean c) {
        loogedIn = c;
    }
/**
 *function for getting status
 * @return loggedIn
 */
    public boolean getStatus() {
        return loogedIn;
    }
/**
 *function for getting password for admin
 * @return password
 */
    public String getPassword() {
        return password;
    }

/**
 *function for logging in for admin
 */
    public void Login() {
        System.out.println("you can use this email : dodo49@gmail.com, Passwrd: Dodo123@");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter email: ");
        Email = input.next();

        System.out.print("Enter password: ");
        password = input.next();

    }
/**
 *function for adding looseItem
 * @param item
 */
    public void addLooseItem(looseItem item) {
        System.out.println("****************************Create Item**************************");
        item.createItem();
        System.out.println("****************************************************************");
    }
/**
 *function for adding packegedItem
 * @param item
 * 
 */
    public void addPackegedItem(PackagedItem item) {
        System.out.println("****************************Create Item**************************");
        item.createItem();
        System.out.println("****************************************************************");
    }
/**
 *function for cancelling items
 * @param catalog
 */
    public void cancelItem(Catalog catalog) {
        System.out.println("*******************Cancel Item*********************************");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter item name to delete: ");
        String name = input.next();
        catalog.removeItem(name);
        System.out.println("**************************************************************");
    }
/**
 *function for suspending customer
 * @param customers
 */
    public void suspendCustomer(Vector<Customer> customers) {
        System.out.println("*******************Susped Customer******************************");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter username to suspend: ");
        String name = input.next();
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (name.equals(customer.name));
            {
                customers.remove(customer);
            }
        }
        System.out.println("*****************************************************************");
    }

    /**
     *
     * @param obj
     * @return
     */
    public boolean equals(Admin obj) {
        this.Email = obj.Email;
        this.name = obj.name;
        this.address = obj.address;
        this.password = obj.password;
        this.phone = obj.phone;
        this.loogedIn = obj.loogedIn;
        return true;
    }

    /**
     *
     */
    @Override
    /**
 *function for viewing profile
 */
    public void viewProfile() {
        System.out.println("************************Profile Padge*********************");
        System.out.println("Name: " + name);
        System.out.println("Email: " + Email);
        System.out.println("Password: ********");
        System.out.println("Mobile Number: " + phone);
        System.out.println("Address: " + address);
        System.out.println("**********************************************************");
    }

    /**
     *
     */
    @Override
    public void Register() {}
}
