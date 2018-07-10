/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.flora.trees;

import gameEngine.models.TexturedModel;
import gameEngine.renderEngine.Loader;
import java.util.Random;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author swa
 */
public class Pine extends Tree {
    
    public Pine(Loader loader, Vector3f position) {
        super(Pine.generateTexturedModel(loader), position, new Random());
        super.setScale(1f);
    }
    
    public Pine(Loader loader, Vector3f position, Random random) {
        super(Pine.generateTexturedModel(loader), position, random);
        super.setScale(1f);
    }
    
    private static TexturedModel generateTexturedModel(Loader loader) {
        TexturedModel pine = loader.loadTexturedModel(TREE_PATH + "pine/pine");
        pine.getTexture().setHasTransparency(true);
        return pine;
    }
}
