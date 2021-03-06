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
