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

package gameEngine.terrains;

import java.util.Random;

/**
 *
 * @author Charly Lamothe
 */
public class HeightsGenerator {

    private static final float AMPLITUDE = 20f;
    private static final int OCTAVES = 4;
    private static final float ROUGHNESS = 0.3f;

    private Random random = new Random();
    private int seed;
    private int xOffset = 0;
    private int zOffset = 0;
    private boolean isFlat = false;

    public HeightsGenerator(int seed) {
        this.seed = 1000000000;
    }

    //only works with POSITIVE gridX and gridZ values!
    public HeightsGenerator(int gridX, int gridZ, int vertexCount, int seed) {
        this.seed = seed;
        xOffset = gridX * (vertexCount - 1);
        zOffset = gridZ * (vertexCount - 1);
    }

    public float generateHeight(int x, int z) {
        if (!isFlat) {
            float total = 0;
            float d = (float) Math.pow(2, OCTAVES - 1);
            for (int i = 0; i < OCTAVES; i++) {
                float freq = (float) (Math.pow(2, i) / d);
                float amp = (float) Math.pow(ROUGHNESS, i) * AMPLITUDE;
                total += getInterpolatedNoise((x + xOffset) * freq, (z + zOffset) * freq) * amp;
            }
            return total;
        }
        return 1;
    }

    private float getInterpolatedNoise(float x, float z) {
        int intX = (int) x;
        int intZ = (int) z;
        float fracX = x - intX;
        float fracZ = z - intZ;

        float v1 = getSmoothNoise(intX, intZ);
        float v2 = getSmoothNoise(intX + 1, intZ);
        float v3 = getSmoothNoise(intX, intZ + 1);
        float v4 = getSmoothNoise(intX + 1, intZ + 1);
        float i1 = interpolate(v1, v2, fracX);
        float i2 = interpolate(v3, v4, fracX);
        return interpolate(i1, i2, fracZ);
    }

    private float interpolate(float a, float b, float blend) {
        double theta = blend * Math.PI;
        float f = (float) (1f - Math.cos(theta)) * 0.5f;
        return a * (1f - f) + b * f;
    }

    private float getSmoothNoise(int x, int z) {
        float corners = (getNoise(x - 1, z - 1) + getNoise(x + 1, z - 1) + getNoise(x - 1, z + 1)
                + getNoise(x + 1, z + 1)) / 16f;
        float sides = (getNoise(x - 1, z) + getNoise(x + 1, z) + getNoise(x, z - 1)
                + getNoise(x, z + 1)) / 8f;
        float center = getNoise(x, z) / 4f;
        return corners + sides + center;
    }

    private float getNoise(int x, int z) {
        random.setSeed(x * 49632 + z * 325176 + seed);
        return random.nextFloat() * 2f - 1f;
    }
}
