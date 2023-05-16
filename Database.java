/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toffeestore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Database {

    private Vector<Customer> customers;
    private Catalog catalog;
    private Vector<Catagory> catagories;
    private Vector<Admin> admins;

    /**
     *
     * @return
     */
    public Vector<Admin> getAdmins() {
        return admins;
    }

    /**
     *
     * @param admins
     */
    public void setAdmins(Vector<Admin> admins) {
        this.admins = admins;
    }
/**
 *constructor for initializing attributes
 */
    public Database() {
        catalog = new Catalog();
        customers = new Vector<Customer>();
        catagories = new Vector<Catagory>();
        admins = new Vector<Admin>();
        catagories.add(new Catagory("western", "Tasty and Good qualtiy"));
        catagories.add(new Catagory("eastrn", "Different flavours"));

        admins.add(new Admin("dodo49@gmail.com", "Dodo123@","Doaa"));
        loadCustomersIntoVector();
        

    }
/**
 *Function for storing data into file
 */
    public void loadCustomerIntoFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("customers.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (Customer customer : customers) {
                objectOut.writeObject(customer);
            }
            objectOut.close();
            fileOut.close();
            System.out.println("Objects have been written to myObjects.txt successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("catalog.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (catalogItem item : catalog.getItems()) {
                objectOut.writeObject(item);
            }
            objectOut.close();
            fileOut.close();
            System.out.println("Objects have been written to myObjects.txt successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
/**
 *Function for loading data from file into vector
 * the data is customers and catalog 
 */
    public void loadCustomersIntoVector() {

        try {
            FileInputStream fileIn = new FileInputStream("customers.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            while (true) {
                try {
                    Customer customer = (Customer) objectIn.readObject();
                    customers.add(customer);
                } catch (ClassNotFoundException e) {
                    // Reached the end of the file
                    break;
                }
            }

            objectIn.close();
            fileIn.close();

            // Display the objects in the vector
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } catch (IOException e) {

        }

        try {
            FileInputStream fileIn = new FileInputStream("catalog.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            while (true) {
                try {
                    catalogItem item = (catalogItem) objectIn.readObject();
                    catalog.getItems().add(item);
                } catch (ClassNotFoundException e) {
                    // Reached the end of the file
                    break;
                }
            }

            objectIn.close();
            fileIn.close();

            // Display the objects in the vector
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } catch (IOException e) {

        }

    }
/**
 *Function for validating user name
 * user name should contain characters or hyphens or underscores 
 * return matcher.matches()
     * @param name
     * @return 
 */
    public boolean validateUsername(String name) {
        String userNamePattern = "^[a-zA-Z_-]{3,16}$";
        Pattern pattern = Pattern.compile(userNamePattern);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
/**
 *Function for validating email
     * @param email
     * @return matcher.matches()
 */
    public boolean validateEmail(String email) {
        String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
 *function foe validating phone number must be 11 digits and begin with(011 or 011 or 015 or 012)
 * return matcher.matches()
     * @param phone
     * @return 
 */
    public boolean validatePhoneNumber(String phone) {
        String phonePattern = "^01[0125][0-9]{8}$";
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

/**
 *Function for validating password
 * must contain characters and digits its length must more than or equal 6 characters
 * and must contain special character
 * return matcher.matches()
     * @param password
     * @return 
 */
    public boolean validatePassword(String password) {
        String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
/**
 *Function for validating category name
 * category name must exist in the database
 * return matcher.matches()
     * @param name
     * @return 
 */
    public boolean validateCatagory(String name) {

        for (int i = 0; i < catagories.size(); i++) {
            Catagory catagory = catagories.get(i);
            if (name.equals(catagory.getName())) {
                return true;
            }
        }
        return false;
    }
/**
 *Function for adding customer
 * @param addedCustomer
 */
    public void addCustomer(Customer addedCustomer) {
        customers.add(addedCustomer);
    }
/**
 *Function for getting customer vector
 * @return customers
 */
    public Vector<Customer> getCustomers() {
        return customers;
    }
/**
 *Function for updating customer
 * @param customer
 */
    public void updateCusomerInfo(Customer customer) {

    }
/**
 *Function for getting catalog
 * @return catalog
 */
    public Catalog getCatalog() {
        return catalog;
    }
/**
 *Function for getting Catagories
 * @return categories
 */
    public Vector<Catagory> getCatagories() {
        return catagories;
    }
/**
 *Function for getting categories
 * @param catagories
 */
    public void setCatagories(Vector<Catagory> catagories) {
        this.catagories = catagories;
    }
/**
 *Function for checking that login data already exists in the data base for a customer
 * @param customer
     * @return 
 */
    public boolean validateLogin(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).Email.equals(customer.Email) && customers.get(i).getPassword().equals(customer.getPassword())) {
                customer.setLoogedIn(true);
                customer.equals(customers.get(i));
                return true;
            }
        }
        return false;
    }
/**
 *Function for checking that login data already exists in the data base for an admin
 * @param admin
     * @return 
 */
    public boolean validateLogin(Admin admin) {
        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).Email.equals(admin.Email) && admins.get(i).getPassword().equals(admin.getPassword())) {
                admin.setLoogedIn(true);
                admin.equals(admins.get(i));
                return true;
            }
        }
        return false;
    }
/**
 *Function for getting category object by name
 * @param name
 * @return category
 */
    public Catagory getCatagory(String name) {
        for (int i = 0; i < catagories.size(); i++) {
            Catagory catagory = catagories.get(i);
            if (name.equals(catagory.getName())) {
                return catagory;
            }
        }
        return null;

    }
}
