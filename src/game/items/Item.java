/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.items;

import gameEngine.entities.Entity;
import gameEngine.entities.EntityBuilder;
import gameEngine.textures.ModelTexture;

/**
 *
 * @author swa
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

