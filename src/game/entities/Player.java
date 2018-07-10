/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entities;

import game.keymapping.ActionbarKeys;
import game.keymapping.ControlsKeys;
import game.keymapping.Key;
import game.keymapping.WindowKeys;
import game.skills.CosmicBubbles;
import game.skills.Fireball;
import game.skills.TestSkill;
import gameEngine.entities.Entity;
import gameEngine.entities.EntityBuilder;
import gameEngine.terrains.Terrain;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author swa
 */
public class Player extends Character {

    private ActionbarKeys actionbarKeys;
    private ControlsKeys controlsKeys;
    private WindowKeys windowKeys;
    private Fireball fireball;
    private CosmicBubbles cosmicBubbles;
    
    public Player(Entity entity) {
        super(new EntityBuilder(entity.getModel(), entity.getPosition(), entity.getRotX(), entity.getRotY(), entity.getRotZ(), entity.getScale(), entity.getTextureIndex()));
        this.init();
    }
    
    public Player(EntityBuilder builder) {
        super(builder);
        this.init();
    }
    
    public void cleanUp() {
        this.fireball.cleanUp();
        this.cosmicBubbles.cleanUp();
    }
    
    public int getCurrentGridX() {
        float x = this.getPosition().x;
        int gridX = 0;

        if (x > Terrain.SIZE) {
            while (x > Terrain.SIZE) {
                x = x - Terrain.SIZE;
                gridX++;
            }
        } else if (x < 0) {
            while (x < 0) {
                x = x + Terrain.SIZE;
                gridX--;
            }
        }

        return gridX;
    }

    public int getCurrentGridZ() {
        float z = this.getPosition().z;
        int gridZ = 0;

        if (z > Terrain.SIZE) {
            while (z > Terrain.SIZE) {
                z = z - Terrain.SIZE;
                gridZ++;
            }
        } else if (z < 0) {
            while (z < 0) {
                z = z + Terrain.SIZE;
                gridZ--;
            }
        }

        return gridZ;
    }
    
    @Override
    public void move(Terrain terrain) {
        checkInputs();
        super.move(terrain);
    }
    
    private void init() {
        this.actionbarKeys = new ActionbarKeys();
        this.controlsKeys = new ControlsKeys();
        this.windowKeys = new WindowKeys();
        this.fireball = new Fireball();
        this.cosmicBubbles = new CosmicBubbles();
    }

    private void checkInputs() {
        //**********Action bar keys checking************************
        if (this.checkKeyDown(this.actionbarKeys.getQuickbar1())) {
            this.fireball.execute(this.getPosition());
        }
        
        if (this.checkKeyDown(this.actionbarKeys.getQuickbar2())) {
            this.cosmicBubbles.execute(this.getPosition());
        }
        
        //**********Controls keys checking************************
        if (this.checkKeyDown(this.controlsKeys.getFoward())) {
            this.currentSpeed = RUN_SPEED;
        } else if (this.checkKeyDown(this.controlsKeys.getBackward())) {
            this.currentSpeed = -RUN_SPEED;
        } else {
            this.currentSpeed = 0;
        }

        if (this.checkKeyDown(this.controlsKeys.getTurnRight())) {
            this.currentTurnSpeed = -TURN_SPEED;
        } else if (this.checkKeyDown(this.controlsKeys.getTurnLeft())) {
            this.currentTurnSpeed = TURN_SPEED;
        } else {
            this.currentTurnSpeed = 0;
        }

        if (this.checkKeyDown(this.controlsKeys.getStandingJump())) {
            jump();
        }
        
        //**********Windows keys checking************************
    }
    
    private boolean checkKeyDown(Key key) {
        return key.getMain() != null &&
               (Keyboard.isKeyDown(key.getMain().getValue()) &&
                Keyboard.isKeyDown(key.getMain().getValue2())) ||
               (key.getAlternative() != null &&
                Keyboard.isKeyDown(key.getAlternative().getValue()) &&
                Keyboard.isKeyDown(key.getAlternative().getValue2()));
    }
    
    private void jump() {
        if (!isInAir) {
            this.upwardsSpeed = JUMP_POWER;
            isInAir = true;
        }
    }
}
