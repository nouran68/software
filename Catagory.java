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


public class Catagory implements Serializable {

    private Vector<catalogItem> items;
    private String name;
    private String description;

    /**
     *
     * @param items
     */
    public Catagory(Vector<catalogItem> items) {
        this.items = items;
    }
    /**
 *constructor for category
     * @param name  
     * @param description
 */
    public Catagory(String name, String description) {
        items = new Vector<catalogItem>();
        this.name = name;
        this.description = description;
    }
    /**
 *Function for adding item to category
     * @param item
 */
    public void addItem(catalogItem item) {
        items.add(item);
    }
    /**
 *Function for setting description
 */
    public void dispalyCatagory() {
        System.out.println("**********************Catagory Items**************************");
        for (int i = 0; i < items.size(); i++) {
            catalogItem item = items.get(i);
            item.dispayItem();
        }
        System.out.println("*************************************************************");
    }
    /**
 *Function for searching for category by name
     * @param name
 */
    public void serchByName(String name) {
        for (int i = 0; i < items.size(); i++) {
            catalogItem item = items.get(i);
            if (name.equals(item.name)) {
                item.dispayItem();
            }
        }
    }
    /**
 *Function for removing item from category
     * @param name
 */
    public void removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            catalogItem item = items.get(i);
            if (name.equals(item.name)) {
                items.remove(item);
            }
        }
    }
    /**
 *Function for setting description
     * @return 
 */
    public Vector<catalogItem> getItems() {
        return items;
    }
    /**
 *Function for setting items of category
     * @param items
 */
    public void setItems(Vector<catalogItem> items) {
        this.items = items;
    }
    /**
 *Function for getting name of category
     * @return name of category
 */
    public String getName() {
        return name;
    }
    /**
 *Function for name for category
     * @param name
 */
    public void setName(String name) {
        this.name = name;
    }
    /**
 *Function for setting description
     * @return description
 */
    public String getDescription() {
        return description;
    }
    /**
 *Function for setting description
     * @param description
 */
    public void setDescription(String description) {
        this.description = description;
    }

}
