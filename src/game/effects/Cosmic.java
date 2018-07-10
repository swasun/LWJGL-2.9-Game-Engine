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

/**
 *
 * @author swa
 */
public class Cosmic extends Effect {
    
    public Cosmic() {
        this(new Loader());
    }
    
    public Cosmic(ParticleSystem cosmicSystem) {
        this.system = cosmicSystem;
    }
    
    public Cosmic(Loader loader) {
        ParticleTexture cosmicTexture = new ParticleTexture(loader.loadGameTexture(EFFECTS_PATH + "cosmic"), 4);
        cosmicTexture.setAdditive(true);
        super.system = new ParticleSystem(cosmicTexture);
        super.system.setPps(155);
        super.system.setAverageSpeed(25);
        super.system.setGravityComplient(0.2f);
        super.system.setAverageLifeLength(2);
        super.system.setAverageScale(1f);
        super.system.randomizeRotation();
    }
}
