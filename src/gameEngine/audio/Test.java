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

import org.lwjgl.openal.AL10;
import org.lwjgl.openal.AL11;

/**
 *
 * @author Charly Lamothe
 */
public class Test {
    
    public static void main(String[] args) throws InterruptedException {
        AudioMaster.init();
        AudioMaster.setListenerData(0, 0, 0);
        AL10.alDistanceModel(AL11.AL_LINEAR_DISTANCE);
        
        int buffer = AudioMaster.loadSound("src/gameEngine/audio/bounce.wav");
        Source source = new Source();
        source.setLooping(true);
        source.play(buffer);
        
        source.setPosition(0, 0, 0);
        float xPos = 0;
        
        char c = ' ';
        while (c != 'q') {
            xPos -= 0.03f;
            source.setPosition(xPos, 0, 0);
            System.out.println(xPos);
            Thread.sleep(10);
        }
        
        source.delete();
        AudioMaster.cleanUp();
    }
}
