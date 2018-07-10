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

package game.items;

import gameEngine.entities.Entity;
import gameEngine.entities.EntityBuilder;
import gameEngine.textures.ModelTexture;

/**
 *
 * @author Charly Lamothe
 */
public class Item extends Entity {
    
    private int id;
    private String name;
    private int price;
    boolean isSalable = false;
    private ModelTexture picture;

    public Item(EntityBuilder builder, String name, ModelTexture picture) {
        super(builder);
        this.name = name;
        this.picture = picture;
    }
    
    public Item(EntityBuilder builder, String name, ModelTexture picture, int id) {
        super(builder);
        this.name = name;
        this.picture = picture;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelTexture getPicture() {
        return picture;
    }

    public void setPicture(ModelTexture picture) {
        this.picture = picture;
    }
    
    public int getPrice() {
        return price;
    }
    
    void setSalable(int price) {
        if (price > 0) {
            this.price = price;    
            this.isSalable = true;
        }
    }
    
    void setUnsalable() {
        this.isSalable = false;
    }
}

