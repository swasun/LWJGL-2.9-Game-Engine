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
public class Lantern extends Entity {

    public Lantern(Loader loader, Vector3f position) {
        super(new EntityBuilder(Lantern.generateTexturedModel(loader), position, 0, new Random().nextFloat() * 360, 0, 1));
    }
    
    public Lantern(Loader loader, Vector3f position, Random random) {
        super(new EntityBuilder(Lantern.generateTexturedModel(loader), position, 0, random.nextFloat() * 360, 0, 1));
    }

    private static TexturedModel generateTexturedModel(Loader loader) {
        TexturedModel lantern = loader.loadTexturedModel(ENTITIES_PATH + "objects/lantern/lantern");
        lantern.getTexture().setHasTransparency(true);
        lantern.getTexture().setShineDamper(10);
        lantern.getTexture().setReflectivity(0.5f);
        lantern.getTexture().setExtraInfoMap(loader.loadGameTexture(ENTITIES_PATH + "objects/lantern/lanternS"));
        return lantern;
    }
}
