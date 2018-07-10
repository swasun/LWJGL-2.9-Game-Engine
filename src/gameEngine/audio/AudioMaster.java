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

package gameEngine.audio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.util.WaveData;

/**
 *
 * @author Charly Lamothe
 */
public class AudioMaster {
    
    private static List<Integer> buffers = new ArrayList<Integer>();
    
    public static void init() {
        try {
            AL.create();
        } catch (LWJGLException ex) {
            Logger.getLogger(AudioMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setListenerData(float x, float y, float z) {
        AL10.alListener3f(AL10.AL_POSITION, x, y, z);
        AL10.alListener3f(AL10.AL_VELOCITY, 0, 0, 0);
    }
    
    public static int loadSound(String fileName) {
        int buffer = AL10.alGenBuffers();
        buffers.add(buffer);
        //WaveData waveFile = WaveData.create(fileName);
        WaveData waveFile = null;
        try {
            waveFile = WaveData.create(new BufferedInputStream(new FileInputStream(fileName)));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AudioMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        AL10.alBufferData(buffer, waveFile.format, waveFile.data, waveFile.samplerate);
        waveFile.dispose();
        return buffer;
    }
    
    public static void cleanUp() {
        for (int buffer : buffers) {
            AL10.alDeleteBuffers(buffer);
        }
        AL.destroy();
    }
}
