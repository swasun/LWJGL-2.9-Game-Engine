package gameEngine.entities;

import static game.entities.AliveEntity.GRAVITY;
import gameEngine.models.TexturedModel;
import gameEngine.renderEngine.DisplayManager;
import gameEngine.terrains.Terrain;

import org.lwjgl.util.vector.Vector3f;

public class Entity {

    protected static final String ENTITIES_PATH = "entities/";
    protected static final float RUN_SPEED = 40;
    protected static final float TURN_SPEED = 160;
    public static final float GRAVITY = -50;
    protected static final float JUMP_POWER = 18;
    
    protected boolean isInAir = false;
    protected float currentSpeed = 0;
    protected float currentTurnSpeed = 0;
    protected float upwardsSpeed = 0;

    private TexturedModel model;
    private Vector3f position;
    private float rotX, rotY, rotZ;
    private float scale;
    private int textureIndex = 0;

    public Entity(EntityBuilder builder) {
        this.model = builder.getModel();
        this.position = builder.getPosition();
        this.rotX = builder.getRotX();
        this.rotY = builder.getRotY();
        this.rotZ = builder.getRotZ();
        this.scale = builder.getScale();
        this.textureIndex = builder.getTextureIndex();
    }

    public float getTextureXOffset() {
        int column = textureIndex % model.getTexture().getNumberOfRows();
        return (float) column / (float) model.getTexture().getNumberOfRows();
    }

    public float getTextureYOffset() {
        int row = textureIndex / model.getTexture().getNumberOfRows();
        return (float) row / (float) model.getTexture().getNumberOfRows();
    }

    public void increasePosition(float dx, float dy, float dz) {
        this.position.x += dx;
        this.position.y += dy;
        this.position.z += dz;
    }

    public void increaseRotation(float dx, float dy, float dz) {
        this.rotX += dx;
        this.rotY += dy;
        this.rotZ += dz;
    }

    public TexturedModel getModel() {
        return model;
    }

    public void setModel(TexturedModel model) {
        this.model = model;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public float getRotX() {
        return rotX;
    }

    public void setRotX(float rotX) {
        this.rotX = rotX;
    }

    public float getRotY() {
        return rotY;
    }

    public void setRotY(float rotY) {
        this.rotY = rotY;
    }

    public float getRotZ() {
        return rotZ;
    }

    public void setRotZ(float rotZ) {
        this.rotZ = rotZ;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public int getTextureIndex() {
        return textureIndex;
    }

    public int getGridX() {
        float x = this.getPosition().x;
        int gridX = 0;

        if (x > Terrain.SIZE) {
            while (x > Terrain.SIZE) {
                x = x - Terrain.SIZE;
                gridX++;
            }
        } else if (x < 0) {
            while (x < 0) {
                x = x + Terrain.SIZE;
                gridX--;
            }
        }

        return gridX;
    }

    public int getGridZ() {
        float z = this.getPosition().z;
        int gridZ = 0;

        if (z > Terrain.SIZE) {
            while (z > Terrain.SIZE) {
                z = z - Terrain.SIZE;
                gridZ++;
            }
        } else if (z < 0) {
            while (z < 0) {
                z = z + Terrain.SIZE;
                gridZ--;
            }
        }

        return gridZ;
    }

    public float getRelativeX() {
        float x = this.getPosition().x;

        if (x > Terrain.SIZE) {
            while (x > Terrain.SIZE) {
                x = x - Terrain.SIZE;
            }
        } else if (x < 0) {
            while (x < 0) {
                x = x + Terrain.SIZE;
            }
        }

        return x;
    }

    public float getRelativeZ() {
        float z = this.getPosition().z;

        if (z > Terrain.SIZE) {
            while (z > Terrain.SIZE) {
                z = z - Terrain.SIZE;
            }
        } else if (z < 0) {
            while (z < 0) {
                z = z + Terrain.SIZE;
            }
        }
        return z;
    }

    /*public void move() {
        this.move(this.currentTerrain);
    }*/
    public void move(Terrain terrain) {
        increaseRotation(0, currentTurnSpeed * DisplayManager.getFrameTimeSeconds(), 0);
        float distance = currentSpeed * DisplayManager.getFrameTimeSeconds();
        float dx = (float) (distance * Math.sin(Math.toRadians(getRotY())));
        float dz = (float) (distance * Math.cos(Math.toRadians(getRotY())));
        this.increasePosition(dx, 0, dz);
        upwardsSpeed += GRAVITY * DisplayManager.getFrameTimeSeconds();
        this.increasePosition(0, upwardsSpeed * DisplayManager.getFrameTimeSeconds(), 0);
        float terrainHeight = terrain.getHeightOfTerrain(getPosition().x, getPosition().z);
        if (this.getPosition().y < terrainHeight) {
            upwardsSpeed = 0;
            isInAir = false;
            this.getPosition().y = terrainHeight;
        }
    }
}
