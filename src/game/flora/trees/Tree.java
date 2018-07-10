/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.flora.trees;

import gameEngine.entities.Entity;
import gameEngine.entities.EntityBuilder;
import gameEngine.models.TexturedModel;
import java.util.Random;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author swa
 */
public class Tree extends Entity {
    
    protected static final String TREE_PATH = ENTITIES_PATH + "flora/trees/";
    
    private static final float DEFAULT_SCALE = 5f;
    
    public Tree(EntityBuilder builder) {
        super(builder);
    }
    
    public Tree(TexturedModel texturedModel, Vector3f position, Random random) {
        super(new EntityBuilder(texturedModel, position, 0, random.nextFloat() * 360, 0, DEFAULT_SCALE));
    }
    
    public Tree(TexturedModel texturedModel, Vector3f position, Random random, int textureIndex) {
        super(new EntityBuilder(texturedModel, position, 0, random.nextFloat() * 360, 0, DEFAULT_SCALE, textureIndex));
    }
}
