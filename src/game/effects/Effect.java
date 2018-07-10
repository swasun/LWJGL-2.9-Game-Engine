/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.effects;

import gameEngine.audio.Source;
import gameEngine.particles.ParticleSystem;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author swa
 */
public abstract class Effect {
    
    protected static final String EFFECTS_PATH = "effects/";
    
    protected ParticleSystem system;
    
    public ParticleSystem getSystem() {
        return system;
    }

    public void setSystem(ParticleSystem system) {
        this.system = system;
    }
    
    public void generate(Vector3f position) {
        this.system.generateParticles(position); 
    }
}
