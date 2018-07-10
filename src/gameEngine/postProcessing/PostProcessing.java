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

package gameEngine.postProcessing;

import gameEngine.bloom.BrightFilter;
import gameEngine.bloom.CombineFilter;
import gameEngine.gaussianBlur.HorizontalBlur;
import gameEngine.gaussianBlur.VerticalBlur;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import gameEngine.models.RawModel;
import gameEngine.renderEngine.Loader;
import org.lwjgl.opengl.Display;

public class PostProcessing {

    private static final float[] POSITIONS = {-1, 1, -1, -1, 1, 1, 1, -1};
    private static RawModel quad;
    private static ContrastChanger contrastChanger;
    private static BrightFilter brightFilter;
    private static HorizontalBlur hBlur;
    private static VerticalBlur vBlur;
    private static CombineFilter combineFilter;
    
    public static void init(Loader loader) {
        quad = loader.loadToVAO(POSITIONS, 2);
        contrastChanger = new ContrastChanger();
        brightFilter = new BrightFilter(Display.getWidth() / 2, Display.getHeight());
        hBlur = new HorizontalBlur(Display.getWidth() / 5, Display.getHeight() / 5);
        vBlur = new VerticalBlur(Display.getWidth() / 5, Display.getHeight() / 5);
        combineFilter = new CombineFilter();
    }

    public static void doPostProcessing(int colourTexture, int brightTexture) {
        start();
        contrastChanger.render(colourTexture);
        brightFilter.render(colourTexture);
        hBlur.render(brightTexture);
        vBlur.render(hBlur.getOutputTexture());
        combineFilter.render(colourTexture, vBlur.getOutputTexture());
        end();
    }

    public static void cleanUp() {
        contrastChanger.cleanUp();
        brightFilter.cleanUp();
        hBlur.cleanUp();
        vBlur.cleanUp();
        combineFilter.cleanUp();
    }

    private static void start() {
        GL30.glBindVertexArray(quad.getVaoID());
        GL20.glEnableVertexAttribArray(0);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
    }

    private static void end() {
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);
    }
}
