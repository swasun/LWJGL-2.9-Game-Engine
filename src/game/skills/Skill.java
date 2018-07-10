/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.skills;

import game.effects.Effect;
import gameEngine.audio.Sound;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author swa
 * @TODO Animation instead of specified position in execute method
 */
public abstract class Skill {
    
    protected static final String AUDIO_SKILLS_PATH = "oldres/audio/skills/";
    
    protected String name;
    protected String description;
    protected Effect effect;
    protected Sound sound;
    
    public void execute(Vector3f position) {
        this.effect.generate(position);
        this.sound.play();
    }
    
    public void cleanUp() {
        this.sound.cleanUp();
    }
}
