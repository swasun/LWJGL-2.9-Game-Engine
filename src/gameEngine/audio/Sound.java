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

/**
 *
 * @author Charly Lamothe
 */
public class Sound {
    
    private Source source = new Source();
    private int soundBuffer;

    public Sound(String soundPath) {
        this.soundBuffer = AudioMaster.loadSound(soundPath + ".wav");
    }

    public Source getSource() {
        return source;
    }

    public int getSoundBuffer() {
        return soundBuffer;
    }
    
    public boolean isPlaying() {
        return this.source.isPlaying();
    }
    
    public void play() {
        this.source.play(this.soundBuffer);
    }
    
    public void pause() {
        this.source.pause();
    }
    
    public void stop() {
        this.source.stop();
    }
    
    public void cleanUp() {
        this.source.delete();
    }
}
