/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.objects;

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
public class Boulder extends Entity {
    
    public Boulder(Loader loader, Vector3f position) {
        super(new EntityBuilder(Boulder.generateTexturedModel(loader), position, 0, 0, 0, 1));
    }
    
    public Boulder(Loader loader, Vector3f position, Random random) {
        //random.nextFloat() * 360, 0, 0, 0.5f + random.nextFloat())));
        super(new EntityBuilder(Boulder.generateTexturedModel(loader), position, random.nextFloat() * 360, 0, 0, 0.5f + random.nextFloat()));
    }

    private static TexturedModel generateTexturedModel(Loader loader) {
        TexturedModel barrel = loader.loadNormalMappedTexturedModel(ENTITIES_PATH + "objects/boulder/boulder");
        barrel.getTexture().setShineDamper(10);
        barrel.getTexture().setReflectivity(0.5f);
        
        return barrel;
    }
}
