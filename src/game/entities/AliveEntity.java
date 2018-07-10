/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entities;

import game.equipments.Equipment;
import game.gauges.Vitality;
import game.inventory.Inventory;
import gameEngine.entities.Entity;
import gameEngine.entities.EntityBuilder;

/**
 *
 * @author swa
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
