/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toffeestore;

import java.io.Serializable;


public abstract class Payment implements Serializable {

    private float amount;
    private String method;
    private String Status;

    /**
     *
     */
    public abstract void processMethod();

    /**
     *
     */
    public abstract void VerifyPayment();

    /**
     *
     */
    public abstract void cancelOrder();

    /**
     * function for getting amount
     *
     * @return amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * function for setting amount for payment
     *
     * @param amount
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /**
     * function for getting method
     *
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * function for setting Payment method
     *
     * @param method
     */

    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * function for getting Status
     *
     * @return Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * function for setting status
     *
     * @param Status
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

}
