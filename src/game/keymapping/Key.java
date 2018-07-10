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
public class Key {

    String name;
    Shortcut main;
    Shortcut alternative;

    public Key(String name, Shortcut main) {
        this.name = name;
        this.main = main;
    }

    public Key(String name, Shortcut main, Shortcut alternative) {
        this.name = name;
        this.main = main;
        this.alternative = alternative;
    }

    public String getName() {
        return name;
    }

    public Shortcut getMain() {
        return main;
    }

    public void setMain(Shortcut main) {
        this.main = main;
    }

    public Shortcut getAlternative() {
        return alternative;
    }

    public void setAlternative(Shortcut alternative) {
        this.alternative = alternative;
    }
}
