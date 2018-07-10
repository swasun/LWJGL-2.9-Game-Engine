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

package gameEngine.bloom;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import gameEngine.postProcessing.ImageRenderer;

public class CombineFilter {

    private ImageRenderer renderer;
    private CombineShader shader;

    public CombineFilter() {
        shader = new CombineShader();
        shader.start();
        shader.connectTextureUnits();
        shader.stop();
        renderer = new ImageRenderer();
    }

    public void render(int colourTexture, int highlightTexture) {
        shader.start();
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, colourTexture);
        GL13.glActiveTexture(GL13.GL_TEXTURE1);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, highlightTexture);
        renderer.renderQuad();
        shader.stop();
    }

    public void cleanUp() {
        renderer.cleanUp();
        shader.cleanUp();
    }
}
