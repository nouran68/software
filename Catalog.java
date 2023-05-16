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


public class Catalog implements ICatalog, Serializable {

    private Vector<catalogItem> items;
    /**
 *constructor for initializing atributes
 */
    Catalog() {
        items = new Vector<catalogItem>();
    }
    /**
 *Function for getting item by name
 */
    @Override
    public void displayCatalog() {
        System.out.println("******************Catalog*********************");
        for (int i = 0; i < items.size(); i++) {
            catalogItem item = items.get(i);
            item.dispayItem();
            System.out.println("--------------------------------------");
        }
    }

    /**
     * Function for searching for item by name
     * @param name
     * @return item
     */
    @Override
    public catalogItem searchByName(String name) {

        for (int i = 0; i < items.size(); i++) {
            catalogItem item = items.get(i);
            if (name.equals(item.name)) {
                item.dispayItem();
                return item;
            }
        }
        return null;
    }

    /**
     * Function for adding item
     * @param item
     */
    @Override
    public void addItem(catalogItem item) {
        items.add(item);

    }
    /**
 *Function for getting item by name
     * @param id
     * @return item
 */
    @Override
    public catalogItem getByID(String id) {

        for (int i = 0; i < items.size(); i++) {
            catalogItem item = items.get(i);
            if (id.equals(item.itemID)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Function for getting item by name
     *
     * @param name
     * @return string
     */
    @Override
    public catalogItem getByName(String name) {

        for (int i = 0; i < items.size(); i++) {
            catalogItem item = items.get(i);
            if (name.equals(item.name)) {
                return item;
            }
        }
        return null;
    }

    /**
     *
     * @param name
     */
    @Override
    public void removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            catalogItem item = items.get(i);
            if (name.equals(item.name)) {
                items.remove(item);
            }
        }
    }

    /**
     * Function for getting item by name
     *
     * @param name
     */
    @Override
    public void updateItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            catalogItem item = items.get(i);
            if (name.equals(item.name)) {
                items.remove(item);
            }
        }

    }

    /**
     * Function for getting item by name
     *
     * @return items
     */
    @Override
    public Vector<catalogItem> getItems() {
        return items;
    }

}
