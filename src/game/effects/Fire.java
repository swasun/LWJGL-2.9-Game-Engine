/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.effects;

import gameEngine.audio.AudioMaster;
import gameEngine.particles.ParticleSystem;
import gameEngine.particles.ParticleTexture;
import gameEngine.renderEngine.Loader;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author swa
 */
public class Fire extends Effect {

    public Fire() {
        this(new Loader());
    }
    
    public Fire(ParticleSystem fireSystem) {
        this.system = fireSystem;
    }
    
    public Fire(Loader loader) {
        ParticleTexture fireTexture = new ParticleTexture(loader.loadGameTexture(EFFECTS_PATH + "fire"), 8);
        fireTexture.setAdditive(true);
        super.system = new ParticleSystem(fireTexture);
        super.system.setPps(400);
        super.system.setAverageSpeed(10);
        super.system.setGravityComplient(0.1f);
        super.system.setAverageLifeLength(2);
        super.system.setAverageScale(5f);
        super.system.setDirection(new Vector3f(0, 2, 0), 0.1f);
        super.system.setLifeError(0.2f);
        super.system.setSpeedError(0.6f);
        super.system.setScaleError(1f);
        super.system.randomizeRotation();
    } 
}
