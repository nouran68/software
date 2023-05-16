/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toffeestore;

import java.io.Serializable;

public abstract class User implements Serializable {

    /**
     *
     */
    protected String name;

    /**
     *
     */
    protected String Email;

    /**
     *
     */
    protected String phone;

    /**
     *
     */
    protected String address;

    /**
     *
     */
    public abstract void Register();

    /**
     *
     */
    public abstract void Login();

    /**
     *
     */
    public abstract void viewProfile();

    /**
     * function for getting name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * function for getting email
     *
     * @return Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * function for getting phonrNumber
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * function for getting address
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

}
