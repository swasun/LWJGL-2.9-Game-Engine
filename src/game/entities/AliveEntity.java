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

package game.entities;

import game.equipments.Equipment;
import game.gauges.Vitality;
import game.inventory.Inventory;
import gameEngine.entities.Entity;
import gameEngine.entities.EntityBuilder;

/**
 *
 * @author Charly Lamothe
 */
public abstract class AliveEntity extends Entity {
    
    protected Inventory inventory;
    protected Equipment equipment;
    
    protected Vitality lifePoints;
    protected boolean isAlive = true;

    public AliveEntity(EntityBuilder builder) {
        super(builder);
        this.inventory = new Inventory();
    }

    public Vitality getLifePoints() {
        return this.lifePoints;
    }
    
    public void setLifePoints(Vitality lifePoints) {
        if (lifePoints != null) {
            this.lifePoints = lifePoints;
        }
    }
    
    public void increaseLifePoint(int points) {
        if (!this.isAlive) {
            return;
        }
        
        this.isAlive = this.lifePoints.increase(points);
        if (!this.isAlive) {
            this.die();
        }
    }
    
    public void decreaseLifePoint(int points) {
        if (!this.isAlive) {
            return;
        }
        
        this.isAlive = this.lifePoints.decrease(points);
        if (!this.isAlive) {
            this.die();
        }
    }
    
    private void die() {
        if (this.isAlive) {
            return;
        }
        
        System.out.println("You are dead");
    }
}
