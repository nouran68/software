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


public class ShoppingCart implements IshoppingCart, Serializable {

    private Vector<catalogItem> items;

    /**
     * Function for setting ShoppingCart object
     */
    ShoppingCart() {
        items = new Vector<catalogItem>();
    }

    /**
     * Function for adding item to cart
     *
     * @param catalog
     */
    @Override
    public void addItem(Catalog catalog) {
        catalog.displayCatalog();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter item name to add to your Cart: ");
        String name = input.next();

        for (int i = 0; i < catalog.getItems().size(); i++) {
            catalogItem item = catalog.getItems().get(i);
            if (item.name.equals(name)) {
                System.out.println("Enter quantity: ");
                float amount = input.nextFloat();

                if (amount != Math.floor(amount) && "packege".equals(item.itemType())) {
                    System.out.println("Invalid Input.You Must enter Intger Value");
                    return;
                }
                if (amount > item.Quantity) {
                    System.out.println("Sorry We donnot have enough quantiy for your order.The available Quantity : " + item.getMaxItems());
                    return;
                }

                if (amount > item.getMaxItems()) {
                    System.out.println("the quantity demanded more than the allowed amount");
                }

                item.setQuantityDemanded(amount);
                item.Quantity -= amount;
                items.add(item);
                return;
            }
        }
        System.out.println("item doesnot Exist\n");

    }

    /**
     * Function for viewing items
     */

    @Override
    public void viewItems() {
        System.out.println("*****************Shopping Cart**********************");
        if (items.isEmpty()) {
            System.out.println("Your Shopping Cart is Empty\n");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            catalogItem item = items.get(i);
            item.dispayItem();
            System.out.println("Quantity Demanded: " + item.getQuantityDemanded());
            System.out.println("------------------------------");
        }
        System.out.println("*****************************************************");
    }

    /**
     * Function for removing item from cart
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
     * Function for getting cart items
     *
     * @return items
     */
    public Vector<catalogItem> getCartItems() {
        return items;
    }

    /**
     * Function for setting cart
     *
     * @param products
     */
    public void setCart(Vector<catalogItem> products) {
        items = products;
    }

    /**
     * Function for updating quantity
     *
     * @param item
     */
    @Override
    public void updeteQuantity(catalogItem item) {

    }

}
