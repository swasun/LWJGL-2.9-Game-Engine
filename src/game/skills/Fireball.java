/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.skills;

import game.effects.Fire;
import gameEngine.audio.Sound;

/**
 *
 * @author swa
 */
public class Fireball extends TestSkill {

    public Fireball() {
        this.effect = new Fire();
        this.sound = new Sound(AUDIO_SKILLS_PATH + "fireExplosion");
    }
}
