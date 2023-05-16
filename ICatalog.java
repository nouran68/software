/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package toffeestore;

import java.util.Vector;


public interface ICatalog {
    
    /**
     *
     */
    public void displayCatalog();

    /**
     *
     * @param name
     * @return
     */
    public catalogItem searchByName(String name);

    /**
     *
     * @param item
     */
    public void addItem(catalogItem item);

    /**
     *
     * @param id
     * @return
     */
    public catalogItem getByID(String id);

    /**
     *
     * @param name
     * @return
     */
    public catalogItem getByName(String name);

    /**
     *
     * @param name
     */
    public void removeItem(String name);

    /**
     *
     * @param name
     */
    public void updateItem(String name);

    /**
     *
     * @return
     */
    public Vector<catalogItem>getItems();

}
