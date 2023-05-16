/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toffeestore;

import java.io.Serializable;
import java.util.Vector;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PackagedItem extends catalogItem implements Serializable {

    int maxPackeges;
    private float pricePerPackege;
    float quantityDemanded = 1;
    String type = "packege";

      /**
     * Function for getting maxPages can be bought
     * @return maxPackeges
     */
    
    @Override
    public float getMaxItems(){
        return maxPackeges;
    } 
      /**
     * Function for getting quantityDemanded
     * @return quantityDemanded
     */
    @Override
    public float getQuantityDemanded() {
        return quantityDemanded;
    }
      /**
     * Function for getting itemPrice
     * @return pricePerPackege
     */
    @Override
    public float getItemPrice()
    {
        return pricePerPackege;
    }
      /**
     * Function for setting quantityDemanded
     * @param quantityDemanded
     */
    @Override
    public void setQuantityDemanded(float quantityDemanded) {
        this.quantityDemanded = quantityDemanded;
    }
      /**
     * Function for setting itemType
     * @return type
     */
        @Override
    public String itemType() {
        return type;
    }
  /**
     * Function for cancelling item by setting its quantity to zero
     */
    @Override
    public void cancel() {
        Quantity = 0;
    }

    /**
     *
     * @return
     */
    public float getPackegePrice() {
        return pricePerPackege;
    }
 /**
     * Function for getting item price
     * @return pricePerPackege* pricePerPackege
     */
    @Override
    public float getPrice() {
        return pricePerPackege * pricePerPackege;
    }
     /**
     * Function for creating item
     * Admin provide item information
     */

    @Override
    public void createItem() {
        Database d_base = new Database();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter item name: ");
        name = input.next();

        System.out.print("Enter item ID: ");
        itemID = input.next();

        System.out.print("Enter item Brand: ");
        brand = input.next();

        System.out.print("Enter Catagory name: ");
        catagory = input.next();

        //Entering and validating catagory
        while (!d_base.validateCatagory(catagory)) {
            System.out.print("Enter Correct Catagory name(eastern - western): ");
            catagory = input.next();
        }

        System.out.print("Enter item Describtion: ");
        describtion = input.next();  

        System.out.print("Enter Price Per Packege: ");
        pricePerPackege = input.nextFloat();

        System.out.print("Enter PackegedItem Quantity: ");
        Quantity = input.nextFloat();
        
        while(Quantity != Math.floor(Quantity)) {
            System.out.println("Invalid Input.You Must enter Intger Value");
            System.out.print("Enter PackegedItem Quantity: ");
            Quantity = input.nextFloat();
        }

        System.out.println("Enter Number of maxPackeges: ");
        maxPackeges = input.nextInt();
        while (maxPackeges > Quantity) {
            System.out.print("Illegel amount\nEnter Number of maxPackeges: ");
            maxPackeges = input.nextInt();
        }
    }
     /**
     * Function for displaying item info
     */
    @Override
    public void dispayItem() {
        System.out.println("name: " + name);
        System.out.println("itemId: " + itemID);
        System.out.println("brand: " + brand);
        System.out.println("catagory: " + catagory);
        System.out.println("Description: " + describtion);
        System.out.println("price: " + pricePerPackege);
       
    }
    
     /**
     * Function for updating item info
     */
    @Override
    public void updateItemInfo() {
        int choice = 1;
        Scanner input = new Scanner(System.in);
        while (choice != 7) {
            System.out.println("Choose the field to update:/n1- name/n2- brand/n3- catagory/n4- description/n5- Price Per Kilo/n6- Max Weight Allowed/n7-Exit");
            System.out.println("Enter you choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Updated Name: ");
                    name = input.next();
                    break;
                case 2:
                    System.out.print("Enter Updated brand: ");
                    brand = input.next();
                    break;
                case 3:
                    System.out.print("Enter Updated Catagory: ");
                    catagory = input.next();
                    break;
                case 4:
                    System.out.print("Enter Updated Description: ");
                    describtion = input.next();  
                    break;
                case 5:
                    System.out.print("Enter Updated Price Per Killo: ");
                    pricePerPackege = input.nextFloat();
                    break;
                case 6:
                    System.out.print("Enter Updated Number of maxPackeges: ");
                    maxPackeges = input.nextInt();
                    break;
                case 7:
                    break;

            }
        }
    }

}
