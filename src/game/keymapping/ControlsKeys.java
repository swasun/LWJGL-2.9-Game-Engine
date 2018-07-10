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
