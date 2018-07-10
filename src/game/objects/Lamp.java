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
 * @author marjorie
 */
public class Lamp extends Entity {

    public Lamp(Loader loader, Vector3f position) {
        super(new EntityBuilder(Lamp.generateTexturedModel(loader), position, 0, new Random().nextFloat() * 360, 0, 1));
    }

    public Lamp(Loader loader, Vector3f position, Random random) {
        super(new EntityBuilder(Lamp.generateTexturedModel(loader), position, 0, random.nextFloat() * 360, 0, 1));
    }

    private static TexturedModel generateTexturedModel(Loader loader) {
        TexturedModel lamp = loader.loadTexturedModel(ENTITIES_PATH + "object/lamp/lamp");
        lamp.getTexture().setUseFakeLighting(true);
        
        return lamp;
    }
}
