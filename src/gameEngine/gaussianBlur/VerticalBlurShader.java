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

package gameEngine.gaussianBlur;

import gameEngine.shaders.ShaderProgram;

public class VerticalBlurShader extends ShaderProgram {

    private static final String VERTEX_FILE = "src/gameEngine/gaussianBlur/verticalBlurVertex.txt";
    private static final String FRAGMENT_FILE = "src/gameEngine/gaussianBlur/blurFragment.txt";

    private int location_targetHeight;

    protected VerticalBlurShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    protected void loadTargetHeight(float height) {
        super.loadFloat(location_targetHeight, height);
    }

    @Override
    protected void getAllUniformLocations() {
        location_targetHeight = super.getUniformLocation("targetHeight");
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
}
