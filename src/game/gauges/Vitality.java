/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gauges;

/**
 *
 * @author swa
 */
public abstract class Vitality {
    
    protected int value;
    protected int maxValue;
    
    protected Vitality(int value, int maxValue) {
        this.value = value;
        this.maxValue = maxValue;
    }
    
    public boolean increase(int points) {
        if (this.value == 0) {
            return false;
        }
        
        if (this.maxValue > 100 && points > 0) {
            if ((this.value + points) > this.maxValue) {
                this.value = this.maxValue;
            } else {
                this.value += points;
            }
        }
        
        return true;
    }
    
    public boolean decrease(int points) {
        if (this.value == 0) {
            return false;
        }
        
        if (points > 0) {
            if ((this.value - points) < 0) {
                this.value = 0;
                return false;
            }
            
            this.value -= points;
        }
        
        return true;
    }
}
