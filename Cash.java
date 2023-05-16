/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toffeestore;

import java.io.Serializable;
import java.util.Scanner;


public class Cash extends Payment implements Serializable {

    private String shippingAddress;
    Order order;

    /**
     * constructor for setting attributes
     * @param order
     */
    Cash(Order order) {
        this.order = order;
        order.setStatus("processing");
    }

    /**
     * Function for processing payment
     *
     */
    @Override
    public void processMethod() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the shipping address: ");
        shippingAddress = input.next();
    }

    /**
     * Function for getting verifying payment
     *
     *
     */
    @Override
    public void VerifyPayment() {
        order.setStatus("delivered");
    }

    /**
     * Function for getting cancelling orders
     *
     */
    @Override
    public void cancelOrder() {
        order.setStatus("cancelled");
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        shippingAddress = address;
    }

    /**
     * Function for getting shippingAdress
     *
     * @return shippingAddress
     */
    public String getAddress() {
        return shippingAddress;
    }

}
