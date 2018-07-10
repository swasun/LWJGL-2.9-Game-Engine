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

package game.flora.trees;

import gameEngine.entities.Entity;
import gameEngine.entities.EntityBuilder;
import gameEngine.models.TexturedModel;
import java.util.Random;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author Charly Lamothe
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
