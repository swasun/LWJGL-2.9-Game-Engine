/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.keymapping;

import org.lwjgl.input.Keyboard;

/**
 *
 * @author marjorie
 */
public class WindowKeys {
    
    private Key action;
    private Key profile;
    private Key inventory;
    private Key skills;
    private Key quests;
    private Key worldMap;
    private Key friendsList;
    private Key legion;
    private Key systemMenu;

    public WindowKeys() {
        this.action = new Key("Action", new Shortcut("C", Keyboard.KEY_C));
        this.profile = new Key("Profile", new Shortcut("P", Keyboard.KEY_P));
        this.inventory = new Key("Inventory", new Shortcut("I", Keyboard.KEY_I));
        this.skills = new Key("Skills", new Shortcut("K", Keyboard.KEY_K));
        this.quests = new Key("Quests", new Shortcut("J", Keyboard.KEY_J));
        this.worldMap = new Key("World Map", new Shortcut("M", Keyboard.KEY_M));
        this.friendsList = new Key("Friends List", new Shortcut("V", Keyboard.KEY_V));
        this.legion = new Key("Legion", new Shortcut("L", Keyboard.KEY_L));
        this.systemMenu = new Key("System Menu", new Shortcut("O", Keyboard.KEY_O));
    }

    public Key getAction() {
        return action;
    }

    public void setAction(Key action) {
        this.action = action;
    }

    public Key getProfile() {
        return profile;
    }

    public void setProfile(Key profile) {
        this.profile = profile;
    }

    public Key getInventory() {
        return inventory;
    }

    public void setInventory(Key inventory) {
        this.inventory = inventory;
    }

    public Key getSkills() {
        return skills;
    }

    public void setSkills(Key skills) {
        this.skills = skills;
    }

    public Key getQuests() {
        return quests;
    }

    public void setQuests(Key quests) {
        this.quests = quests;
    }

    public Key getWorldMap() {
        return worldMap;
    }

    public void setWorldMap(Key worldMap) {
        this.worldMap = worldMap;
    }

    public Key getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(Key friendsList) {
        this.friendsList = friendsList;
    }

    public Key getLegion() {
        return legion;
    }

    public void setLegion(Key legion) {
        this.legion = legion;
    }

    public Key getSystemMenu() {
        return systemMenu;
    }

    public void setSystemMenu(Key systemMenu) {
        this.systemMenu = systemMenu;
    }
}
