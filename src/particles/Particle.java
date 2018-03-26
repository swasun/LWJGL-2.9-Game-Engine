package gameEngine.particles;

import gameEngine.entities.Camera;
import game.entities.Player;
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
        velocity.y += Player.GRAVITY * gravityEffect * DisplayManager.getFrameTimeSeconds();
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
