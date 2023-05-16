/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toffeestore;

import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Order implements IOrder, Serializable {

    private int orderId;
    private String status;
    private String dateShipped;
    private String dateCreated;
    private Customer customer;
    private float totalPriced;
    private Vector<catalogItem> items;
    private ShoppingCart cart;
    private Payment payment;

    /**
     *
     * @param order
     */
    public void equal(Order order) {
        orderId = order.orderId;
        status = order.status;
        dateShipped = order.dateShipped;
        dateCreated = order.dateCreated;
        customer = order.customer;
        totalPriced = order.totalPriced;
        items = order.items;
        cart = order.cart;
        payment = order.payment;
    }

    Order() {
    }

    /**
     * Constructor for Order
     *
     * @param customer
     */

    Order(Customer customer) {
        this.customer = customer;
        items = new Vector<catalogItem>();
        Vector<catalogItem> v = customer.getCart().getCartItems();
        for (int i = 0; i < v.size(); i++) {
            items.add(v.get(i));
        }
        payment = new Cash(this);

    }

    /**
     * function for viewing Orders
     */

    @Override
    public void viewOrder() {
        System.out.println("OrderID: " + this.orderId);
        System.out.println("Date Created: " + this.dateCreated);
        System.out.println("Date Shipped: " + this.dateShipped);
        System.out.println("Order Status: " + this.getStatus());
        System.out.println();
        for (int i = 0; i < items.size(); i++) {
            catalogItem item = items.get(i);
            System.out.println("Product Name: " + item.name);
            System.out.println("Product ID: " + item.itemID);
            System.out.println("Product Brand: " + item.brand);
            System.out.println("Product Catagory: " + item.catagory);
            System.out.println("Product Price: " + item.getItemPrice());
            System.out.println("Product Quantity Demanded: " + item.getQuantityDemanded());
            System.out.println("Total Price: " + item.getPrice());
            System.out.println("---------------------------------------------------");

        }
    }

    /**
     * function for placing Order
     */

    @Override
    public void placeOrder() {
        System.out.println("**************************Placing Order**************************");
        orderId = customer.getOrders().size() + 1;
        //Set the date in which order created
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dateCreated = today.format(formatter);

        Scanner input = new Scanner(System.in);
        System.out.println("After How Many days do you wanna recieve your Order:");
        int numDays = input.nextInt();
        LocalDate futureDate = today.plusDays(numDays);
        dateShipped = futureDate.format(formatter);

        System.out.print("Choose Payment Method\n1- Credit Card\n2- Smart Wallet\n3- Cash On Delivery\n>>");
        int num = input.nextInt();
        if (num != 3) {
            System.out.println("These features not available");
            return;
        }
        payment.processMethod();
        totalPriced = calculateTotalPrice();
        status = "processing";

        System.out.println("*********Review Order**********");
        viewOrder();
        System.out.println("Total Price: " + totalPriced);
        System.out.print("Confirm Order\n1- Yes\n2- No\n>>");
        int n = input.nextInt();
        if (n == 1) {

            customer.getOrders().add(this);
//            customer.viewHistoryOrders();
            customer.getCart().getCartItems().clear();
            return;
        }
        UpdateQuantity(customer.getCart().getCartItems());
        System.out.println("Order has been Cancelleed");
        System.out.println("*******************************************************");
    }

    /**
     * function for calculating Total Price of Order
     *
     * @return sum
     */
    @Override
    public float calculateTotalPrice() {
        float sum = 0;
        for (int i = 0; i < items.size(); i++) {
            sum += items.get(i).getPrice();
        }
        return sum;
    }

    /**
     * function for ReOrdering
     *
     * @param customer
     */

    @Override
    public void reOrder(Customer customer) {
        customer.getOrders();
    }

    /**
     * function for setting status
     *
     * @param stat
     */

    @Override
    public void setStatus(String stat) {
        status = stat;
    }

    /**
     * function for getting Status of order
     * @return status
     */

    @Override
    public String getStatus() {
        return status;
    }

    /**
     * function for getting order items
     *
     * @return items
     */
    @Override
    public Vector<catalogItem> getOrderItems() {
        return items;
    }

    /**
     * function for updating quantity
     *
     * @param items
     */

    public void UpdateQuantity(Vector<catalogItem> items) {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).Quantity += items.get(i).getQuantityDemanded();
        }
    }

    /**
     * function for getting orderID
     *
     * @return orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * function for setting orderID
     *
     * @param orderId
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

}
