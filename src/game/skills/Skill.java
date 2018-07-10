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

package game.skills;

import game.effects.Effect;
import gameEngine.audio.Sound;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author Charly Lamothe
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
