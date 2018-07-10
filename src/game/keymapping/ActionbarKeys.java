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
public class ActionbarKeys {
    
    private Key quickbar1;
    private Key quickbar2;
    private Key quickbar3;
    private Key quickbar4;
    private Key quickbar5;
    private Key quickbar6;
    private Key quickbar7;
    private Key quickbar8;
    private Key quickbar9;
    private Key quickbar10;

    public ActionbarKeys() {
        this.quickbar1 = new Key("Quickbar#1", new Shortcut("1", Keyboard.KEY_1));
        this.quickbar2 = new Key("Quickbar#2", new Shortcut("2", Keyboard.KEY_2));
        this.quickbar3 = new Key("Quickbar#3", new Shortcut("3", Keyboard.KEY_3));
        this.quickbar4 = new Key("Quickbar#4", new Shortcut("4", Keyboard.KEY_4));
        this.quickbar5 = new Key("Quickbar#5", new Shortcut("5", Keyboard.KEY_5));
        this.quickbar6 = new Key("Quickbar#6", new Shortcut("6", Keyboard.KEY_6));
        this.quickbar7 = new Key("Quickbar#7", new Shortcut("7", Keyboard.KEY_7));
        this.quickbar8 = new Key("Quickbar#8", new Shortcut("8", Keyboard.KEY_8));
        this.quickbar9 = new Key("Quickbar#9", new Shortcut("9", Keyboard.KEY_9));
        this.quickbar10 = new Key("Quickbar#10", new Shortcut("0", Keyboard.KEY_0));
    }

    public Key getQuickbar1() {
        return quickbar1;
    }

    public void setQuickbar1(Key quickbar1) {
        this.quickbar1 = quickbar1;
    }

    public Key getQuickbar2() {
        return quickbar2;
    }

    public void setQuickbar2(Key quickbar2) {
        this.quickbar2 = quickbar2;
    }

    public Key getQuickbar3() {
        return quickbar3;
    }

    public void setQuickbar3(Key quickbar3) {
        this.quickbar3 = quickbar3;
    }

    public Key getQuickbar4() {
        return quickbar4;
    }

    public void setQuickbar4(Key quickbar4) {
        this.quickbar4 = quickbar4;
    }

    public Key getQuickbar5() {
        return quickbar5;
    }

    public void setQuickbar5(Key quickbar5) {
        this.quickbar5 = quickbar5;
    }

    public Key getQuickbar6() {
        return quickbar6;
    }

    public void setQuickbar6(Key quickbar6) {
        this.quickbar6 = quickbar6;
    }

    public Key getQuickbar7() {
        return quickbar7;
    }

    public void setQuickbar7(Key quickbar7) {
        this.quickbar7 = quickbar7;
    }

    public Key getQuickbar8() {
        return quickbar8;
    }

    public void setQuickbar8(Key quickbar8) {
        this.quickbar8 = quickbar8;
    }

    public Key getQuickbar9() {
        return quickbar9;
    }

    public void setQuickbar9(Key quickbar9) {
        this.quickbar9 = quickbar9;
    }

    public Key getQuickbar10() {
        return quickbar10;
    }

    public void setQuickbar10(Key quickbar10) {
        this.quickbar10 = quickbar10;
    }
}
