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
public class ControlsKeys {
    
    private Key foward;
    private Key backward;
    private Key turnLeft;
    private Key turnRight;
    private Key standingJump;

    public ControlsKeys() {
        this.foward = new Key("Forward", new Shortcut("Z", Keyboard.KEY_Z), new Shortcut("UpArrow", Keyboard.KEY_UP));
        this.backward = new Key("Backward", new Shortcut("S", Keyboard.KEY_S), new Shortcut("DownArrow", Keyboard.KEY_DOWN));
        this.turnLeft = new Key("Turn Left", new Shortcut("Q", Keyboard.KEY_Q), new Shortcut("LeftArrow", Keyboard.KEY_LEFT));
        this.turnRight = new Key("Turn Right", new Shortcut("D", Keyboard.KEY_D), new Shortcut("RightArrow", Keyboard.KEY_RIGHT));
        this.standingJump = new Key("Standing Jump", new Shortcut("Space", Keyboard.KEY_SPACE));
    }

    public Key getFoward() {
        return foward;
    }

    public void setFoward(Key foward) {
        this.foward = foward;
    }

    public Key getBackward() {
        return backward;
    }

    public void setBackward(Key backward) {
        this.backward = backward;
    }

    public Key getTurnLeft() {
        return turnLeft;
    }

    public void setTurnLeft(Key turnLeft) {
        this.turnLeft = turnLeft;
    }

    public Key getTurnRight() {
        return turnRight;
    }

    public void setTurnRight(Key turnRight) {
        this.turnRight = turnRight;
    }

    public Key getStandingJump() {
        return standingJump;
    }

    public void setStandingJump(Key standingJump) {
        this.standingJump = standingJump;
    }
}
