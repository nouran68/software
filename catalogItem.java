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


public abstract class catalogItem implements Serializable {

    /**
     *
     */
    protected String itemID;

    /**
     *
     */
    protected String name;

    /**
     *
     */
    protected String catagory;

    /**
     *
     */
    protected String brand;

    /**
     *
     */
    protected String describtion;

    /**
     *
     */
    protected float price;

    /**
     *
     */
    protected float discount;

    /**
     *
     */
    protected float Quantity;

    /**
     *
     */
    public abstract void updateItemInfo();

    /**
     *
     */
    public abstract void cancel();

    /**
     *
     */
    public abstract void createItem();

    /**
     *
     */
    public abstract void dispayItem();

    /**
     *
     * @return
     */
    public abstract float getPrice();

    /**
     *
     * @return
     */
    public abstract float getQuantityDemanded();

    /**
     *
     * @param quantityDemanded
     */
    public abstract void setQuantityDemanded(float quantityDemanded);

    /**
     *
     * @return
     */
    public abstract String itemType();

    /**
     *
     * @return
     */
    public abstract float getMaxItems();

    /**
     * function for getting category
     *
     * @return category
     */
    public String getCatagory() {
        return catagory;
    }

    /**
     * function for getting item Price
     *
     * @return price
     */

    public float getItemPrice() {
        return price;
    }

    /**
     * function for getting itemID
     *
     * @return itemID
     */
    public String getItemID() {
        return itemID;
    }
    /**
 *function for getting item name
 * 
     * @return name
 */
    public String getItemName() {
        return name;
    }

    /**
     * function for getting brand
     *
     * @return brand
     */
    public String getBrand() {
        return brand;
    }
    /**
 *function for getting description
 * 
     * @return description
 */
    public String getDescription() {
        return describtion;
    }
    /**
 *function for setting quantity
 * 
     * @param amount
 */
    public void setQuantity(float amount) {
        Quantity = amount;
    }

}
