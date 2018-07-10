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
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author swa
 */
public class Barrel extends Entity {

    public Barrel(Loader loader, Vector3f position) {
        super(new EntityBuilder(Barrel.generateTexturedModel(loader), position, 0, 0, 0, 1));
    }

    private static TexturedModel generateTexturedModel(Loader loader) {
        TexturedModel barrel = loader.loadNormalMappedTexturedModel(ENTITIES_PATH + "objects/barrel/barrel");
        barrel.getTexture().setShineDamper(10);
        barrel.getTexture().setReflectivity(0.5f);
        barrel.getTexture().setExtraInfoMap(loader.loadGameTexture(ENTITIES_PATH + "objects/barrel/barrelS"));
        
        return barrel;
    }
}
