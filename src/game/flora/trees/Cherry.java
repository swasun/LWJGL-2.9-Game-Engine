package game.flora.trees;

import gameEngine.models.TexturedModel;
import gameEngine.renderEngine.Loader;
import java.util.Random;
import org.lwjgl.util.vector.Vector3f;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author swa
 */
public class Cherry extends Tree {

    public Cherry(Loader loader, Vector3f position) {
        super(Cherry.generateTexturedModel(loader), position, new Random(), 3);
    }
    
    public Cherry(Loader loader, Vector3f position, Random random) {
        super(Cherry.generateTexturedModel(loader), position, random, 3);
    }
    
    private static TexturedModel generateTexturedModel(Loader loader) {
        TexturedModel cherry = loader.loadTexturedModel(TREE_PATH + "cherry/cherry");    
        cherry.getTexture().setHasTransparency(true);
        cherry.getTexture().setShineDamper(10);
        cherry.getTexture().setReflectivity(0.5f);
        cherry.getTexture().setExtraInfoMap(loader.loadGameTexture(TREE_PATH + "cherry/cherryS"));
        return cherry;
    }
}
