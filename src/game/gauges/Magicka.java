/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gauges;

/**
 *
 * @author marjorie
 */
public class Magicka {
    
    private int value;
    private int maxValue;

    public Magicka(int value, int maxValue) {
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
