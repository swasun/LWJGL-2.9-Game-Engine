/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.flora.ferns;

import gameEngine.entities.Entity;
import gameEngine.entities.EntityBuilder;
import gameEngine.models.TexturedModel;
import gameEngine.renderEngine.Loader;
import java.util.Random;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author swa
 */
public class Fern extends Entity {
    
    protected static final String FERNS_PATH = ENTITIES_PATH + "flora/ferns/";
    
    private static final float DEFAULT_SCALE = 0.9f;
    
    public Fern(EntityBuilder builder) {
        super(builder);
    }
    
    public Fern(Loader loader, Vector3f position, Random random) {
        super(new EntityBuilder(Fern.generateTexturedModel(loader), position, 0, random.nextFloat() * 360, 0, DEFAULT_SCALE, 3));
    }
    
    public Fern(Loader loader, Vector3f position, Random random, int textureIndex) {
        super(new EntityBuilder(Fern.generateTexturedModel(loader), position, 0, random.nextFloat() * 360, 0, DEFAULT_SCALE, textureIndex));
    }
    
    private static TexturedModel generateTexturedModel(Loader loader) {
        TexturedModel fern = loader.loadTexturedModel(FERNS_PATH + "fern", 2);
        fern.getTexture().setHasTransparency(true);
        return fern;
    }
}
