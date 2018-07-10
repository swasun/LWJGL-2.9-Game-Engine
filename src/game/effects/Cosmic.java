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

package game.effects;
import gameEngine.audio.AudioMaster;
import gameEngine.particles.ParticleSystem;
import gameEngine.particles.ParticleTexture;
import gameEngine.renderEngine.Loader;

/**
 *
 * @author Charly Lamothe
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
