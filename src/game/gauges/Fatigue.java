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

package game.gauges;

/**
 *
 * @author Charly Lamothe
 */
public class Fatigue {
    
    private int value;
    private int maxValue;

    public Fatigue(int value, int maxValue) {
        if (value > 0 && maxValue > value) {
            this.value = value;
            this.maxValue = maxValue;
        }
    }
    
    public void increase(int points) {
        if (this.maxValue > 100 && points > 0) {
            if ((this.value + points) > this.maxValue) {
                this.value = this.maxValue;
            } else {
                this.value += points;
            }
        }
    }
    
    public void decrease(int points) {
        if (points > 0) {
            if ((this.value - points) < 0) {
                this.value = 0;
            } else {
                this.value -= points;
            }
        }
    }
}
