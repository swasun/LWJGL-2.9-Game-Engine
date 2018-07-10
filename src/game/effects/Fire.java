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
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author Charly Lamothe
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
