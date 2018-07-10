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

package game.keymapping;

import org.lwjgl.input.Keyboard;

/**
 *
 * @author Charly Lamothe
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
