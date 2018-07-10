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

package gameEngine.particles;

import gameEngine.entities.Camera;
import gameEngine.entities.Entity;
import gameEngine.renderEngine.DisplayManager;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author Charly Lamothe
 */
public class Particle {
   
    private Vector3f position;
    private Vector3f velocity;
    private float gravityEffect;
    private float lifeLength;
    private float rotation;
    private float scale;
    
    private float elapsedTime = 0;
    
    private ParticleTexture texture;
    
    private Vector2f texOffset1 = new Vector2f();
    private Vector2f texOffset2 = new Vector2f();
    private float blend;
    private float distance;
    
    private Vector3f reusableChange = new Vector3f();
    
    private boolean alive = false;
    
    public Particle() {
        
    }
    
    public void setActive(ParticleTexture texture, Vector3f position, Vector3f velocity,
                          float gravityEffect, float lifeLength, float rotation, float scale) {
        this.alive = true;
        this.position = position;
        this.velocity = velocity;
        this.gravityEffect = gravityEffect;
        this.lifeLength = lifeLength;
        this.rotation = rotation;
        this.scale = scale;
        this.texture = texture;
        ParticleMaster.addParticle(this);
    }

    public ParticleTexture getTexture() {
        return texture;
    }

    public Vector3f getPosition() {
        return position;
    }

    public float getRotation() {
        return rotation;
    }

    public float getScale() {
        return scale;
    }

    public Vector2f getTexOffset1() {
        return texOffset1;
    }

    public Vector2f getTexOffset2() {
        return texOffset2;
    }

    public float getBlend() {
        return blend;
    }

    public float getDistance() {
        return distance;
    }
    
    public boolean isAlive() {
        return alive;
    }
    
    protected boolean update(Camera camera) {
        velocity.y += Entity.GRAVITY * gravityEffect * DisplayManager.getFrameTimeSeconds();
        reusableChange.set(velocity);
        reusableChange.scale(DisplayManager.getFrameTimeSeconds());
        Vector3f.add(reusableChange, position, position);
        updateTextureCoordsInfo();
        distance += Vector3f.sub(camera.getPosition(), position, null).lengthSquared();
        elapsedTime += DisplayManager.getFrameTimeSeconds();
        return elapsedTime < lifeLength;
    }
    
    private void updateTextureCoordsInfo() {
        float lifeFactor = elapsedTime / lifeLength;
        int stageCount = texture.getNumberOfRows() * texture.getNumberOfRows();
        float atlasProgression = lifeFactor * stageCount;
        int index1 = (int) Math.floor(atlasProgression);
        int index2 = index1 < stageCount - 1 ? index1 + 1 : index1;
        this.blend = atlasProgression % 1;
        setTextureOffset(texOffset1, index1);
        setTextureOffset(texOffset2, index2);
    }
    
    private void setTextureOffset(Vector2f offset, int index) {
        int column = index % texture.getNumberOfRows();
        int row = index / texture.getNumberOfRows();
        offset.x = (float) column / texture.getNumberOfRows();
        offset.y = (float) row / texture.getNumberOfRows();
    }
}
