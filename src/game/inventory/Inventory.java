/* 
 * The MIT License
 *
 * Copyright 2018 Charly Lamothe.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package game.inventory;

import game.items.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charly Lamothe
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
