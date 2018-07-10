/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.inventory;

import game.items.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author swa
 */
public class Inventory {

    private List<Item> items;
    private int maxNumber = 20;

    public Inventory() {
        this.items = new ArrayList<>();
    }
    
    public Inventory(List<Item> items) {
        if (items.size() > this.maxNumber) {
            throw new IllegalArgumentException("items.size() > maxNumber");
        }
        
        this.items = items;
    }
    
    int getMaxNumber() {
        return this.maxNumber;
    }
    
    void setMaxNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("number <= 0");
        }
        
        this.maxNumber = number;
    }

    public void add(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item is null");
        }
        
        this.items.add(item);
    }
    
    public void add(List<Item> items) {
        for (Item item : items) {
            this.items.add(item);
        }
    }

    public void remove(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item is null");
        }
        
        this.items.remove(item);
    }
    
    public void remove(List<Item> items) {
        for (Item item : items) {
            this.items.remove(item);
        }
    }
}
