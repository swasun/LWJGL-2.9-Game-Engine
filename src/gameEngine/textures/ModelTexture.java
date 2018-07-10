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

public class ModelTexture {

    private int textureID;
    private int normalMap;
    private int specularMap;

    private float shineDamper = 1;
    private float reflectivity = 0;

    private boolean hasTransparency = false;
    private boolean useFakeLighting = false;
    private boolean hasSpecularMap = false;

    private int numberOfRows = 1;

    public ModelTexture(int texture) {
        this.textureID = texture;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }
    
    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNormalMap() {
        return normalMap;
    }

    public void setNormalMap(int normalMap) {
        this.normalMap = normalMap;
    }
    
    public int getSpecularMap() {
        return this.specularMap;
    }

    public void setExtraInfoMap(int specMap) {
        this.specularMap = specMap;
        this.hasSpecularMap = true;
    }

    public boolean isHasTransparency() {
        return hasTransparency;
    }

    public boolean isUseFakeLighting() {
        return useFakeLighting;
    }
    
    public boolean isHasSpecularMap() {
        return this.hasSpecularMap;
    }

    public void setUseFakeLighting(boolean useFakeLighting) {
        this.useFakeLighting = useFakeLighting;
    }

    public void setHasTransparency(boolean hasTransparency) {
        this.hasTransparency = hasTransparency;
    }

    public int getID() {
        return textureID;
    }

    public float getShineDamper() {
        return shineDamper;
    }

    public void setShineDamper(float shineDamper) {
        this.shineDamper = shineDamper;
    }

    public float getReflectivity() {
        return reflectivity;
    }

    public void setReflectivity(float reflectivity) {
        this.reflectivity = reflectivity;
    }
}
