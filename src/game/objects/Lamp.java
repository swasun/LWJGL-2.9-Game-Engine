/* 
 * The MIT License
 *
 * Copyright 2018 Charly Lamothe.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
 * @author Charly Lamothe
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
