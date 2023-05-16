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


public class Customer extends User implements ICustomer,Serializable {

    private String password;
    private ShoppingCart cart;
    private Vector<Order> orders;
    private boolean loogedIn;
/**
 *constructor for setting customer data
 */
    Customer() {
        orders = new Vector<Order>();
        cart = new ShoppingCart();
        loogedIn = false;
    }
/**
 *Function for displaying customer data
 */
    @Override
    public void viewProfile() {
        System.out.println("************************Profile Padge*********************");
        System.out.println("Name: " + name);
        System.out.println("Email: " + Email);
        System.out.println("Password: ********");
        System.out.println("Mobile Number: " + phone);
        System.out.println("Address: " + address);
        System.out.println("Number Of Orders: " + orders.size());
        System.out.println("**********************************************************");

    }
/**
 *Function for getting orders that customer made
 * @return orders
 */
    public Vector<Order> getOrders() {
        return orders;
    }
/**
 *Function for placing order
 */
    public void PlaceOrder() {
        Order order = new Order(this);
        order.placeOrder();
    }
/**
 *Function for viewing details for customer's orders
 */
    @Override
    public void viewHistoryOrders() {
        System.out.println("**********************Customer History Padge***********************");
        for (int i = 0; i < orders.size(); i++) {
            Order order = new Order();
            order.equal(orders.get(i));
            order.viewOrder();
            System.out.println("Total Order Price: " + order.calculateTotalPrice());
        }
        System.out.println();
        System.out.println("******************************************************************");
    }

    /**
     *
     * @param c
     */
    @Override
    public void setLoogedIn(boolean c) {
        loogedIn = c;
    }
/**
 *Function for logging in for customer
 * token inputs are email and password
 */
    @Override
    public void Login() {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter email: ");
        Email = input.next();

        System.out.print("Enter password: ");
        password = input.next();
    }
/**
 *Function for registering for customer
 * token inputs are name ,email ,password ,phone ,email ,address 
 */
    @Override
    public void Register() {
        Database ds = new Database();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter user name: ");
        name = input.next();
        while (!ds.validateUsername(name)) {
            System.out.print("Enter correct name: ");
            name = input.next();
        }

        System.out.print("Enter password: ");
        password = input.next();
        while (!ds.validatePassword(password)) {
            System.out.println(password);
            System.out.print("Enter correct password: ");
            password = input.next();
        }

        System.out.print("Enter email: ");
        Email = input.next();
        while (!ds.validateEmail(Email)) {
            System.out.print("Enter correct Email: ");
            Email = input.next();
        }

        System.out.print("Enter address: ");
        address = input.next();

        System.out.print("Enter phone number: ");
        phone = input.next();
        while (!ds.validatePhoneNumber(phone)) {
            System.out.print("Enter correct phone number: ");
            phone = input.next();
        }

    }
    /**
 *Function for reordering past order using order id
 * @param id
 */
    public void reOrder(int id)
    {
        for(int i = 0;i<this.getOrders().size();i++)
        {
            Order order = new Order() ;
            order.equal(this.getOrders().get(i));
            if(id == order.getOrderId())
            {
                order.placeOrder();
                return;
            }
        }
        System.out.println("Wrong ID");
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }
/**
 *Function for getting status of logging in 
 * @return loogedIn
 */
    @Override
    public boolean getStatus() {
        return loogedIn;
    }
    /**
 *Function for getting shoppinCart
 * 
     * @return 
 */

    @Override
    public ShoppingCart getCart() {
        return cart;
    }
    /**
 *Function for getting copying two objects
 * 
     * @param obj
     * @return 
  
 */

    @Override
    public boolean equals(Customer obj) {
        this.Email = obj.Email;
        this.name = obj.name;
        this.address = obj.address;
        this.password = obj.password;
        this.phone = obj.phone;
        this.cart = obj.cart;
        this.orders = obj.orders;
        this.loogedIn = obj.loogedIn;
        return true;
    }

}
