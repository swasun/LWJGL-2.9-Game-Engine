/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.keymapping;

/**
 *
 * @author marjorie
 */
public class Shortcut {
    
    private String name;
    private int value;
    private int value2;

    public Shortcut(String name, int value) {
        this.name = name;
        this.value = value;
        this.value2 = value;
    }
    
    public Shortcut(String name, int value, int value2) {
        this.name = name;
        this.value = value;
        this.value2 = value2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }
}
