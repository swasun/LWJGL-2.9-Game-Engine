/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.skills;

import game.effects.Cosmic;
import gameEngine.audio.Sound;

/**
 *
 * @author swa
 */
public class CosmicBubbles extends TestSkill {

    public CosmicBubbles() {
        this.effect = new Cosmic();
        this.sound = new Sound(AUDIO_SKILLS_PATH + "cosmic");
    }
}
