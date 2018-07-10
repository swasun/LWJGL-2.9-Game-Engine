/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entities;

import game.equipments.NPCEquipement;
import game.gauges.Vitality;
import gameEngine.entities.EntityBuilder;

/**
 *
 * @author marjorie
 */
public class NonPlayerCharacter extends AliveEntity {
    
    public NonPlayerCharacter(EntityBuilder builder, Vitality lifePoints) {
        super(builder);
        this.lifePoints = lifePoints;
        this.equipment = new NPCEquipement();
    }
}
