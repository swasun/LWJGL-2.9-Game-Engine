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

package gameEngine.textures;

import gameEngine.renderEngine.Loader;

public class TerrainTexturePack {

    private TerrainTexture backgroundTexture;
    private TerrainTexture rTexture;
    private TerrainTexture gTexture;
    private TerrainTexture bTexture;

    public TerrainTexturePack(TerrainTexture backgroundTexture, TerrainTexture rTexture,
            TerrainTexture gTexture, TerrainTexture bTexture) {
        this.backgroundTexture = backgroundTexture;
        this.rTexture = rTexture;
        this.gTexture = gTexture;
        this.bTexture = bTexture;
    }

    public TerrainTexturePack(Loader loader, String backgroundTexture, String rTexture,
            String gTexture, String bTexture) {
        this.backgroundTexture = new TerrainTexture(loader.loadGameTexture(backgroundTexture));
        this.rTexture = new TerrainTexture(loader.loadGameTexture(rTexture));
        this.gTexture = new TerrainTexture(loader.loadGameTexture(gTexture));
        this.bTexture = new TerrainTexture(loader.loadGameTexture(bTexture));
    }

    public TerrainTexture getBackgroundTexture() {
        return backgroundTexture;
    }

    public TerrainTexture getrTexture() {
        return rTexture;
    }

    public TerrainTexture getgTexture() {
        return gTexture;
    }

    public TerrainTexture getbTexture() {
        return bTexture;
    }
}
