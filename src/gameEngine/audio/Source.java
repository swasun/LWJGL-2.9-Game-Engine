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

/**
 *
 * @author Charly Lamothe
 */
public class Source {
    
    private int sourceId;
    
    public Source() {
        sourceId = AL10.alGenSources();
        setRolloffFactor(1);
        setReferenceDistance(6);
        setMaxDistance(15);
    }

    public void setRolloffFactor(float rolloffFactor) {
        AL10.alSourcef(sourceId, AL10.AL_ROLLOFF_FACTOR, rolloffFactor);
    }

    public void setReferenceDistance(float referenceDistance) {
        AL10.alSourcef(sourceId, AL10.AL_REFERENCE_DISTANCE, referenceDistance);
    }

    public void setMaxDistance(float maxDistance) {
        AL10.alSourcef(sourceId, AL10.AL_MAX_DISTANCE, maxDistance);
    }
    
    public void setVelocity(float x, float y, float z) {
        AL10.alSource3f(sourceId, AL10.AL_VELOCITY, x, y, z);
    }
    
    public void setLooping(boolean loop) {
        AL10.alSourcei(sourceId, AL10.AL_LOOPING, loop ? AL10.AL_TRUE : AL10.AL_FALSE);
    }
    
    public boolean isPlaying() {
        return AL10.alGetSourcei(sourceId, AL10.AL_SOURCE_STATE) == AL10.AL_PLAYING;
    }
    
    public void setVolume(float volume) {
        AL10.alSourcef(sourceId, AL10.AL_GAIN, volume);
    }
    
    public void setPitch(float pitch) {
        AL10.alSourcef(sourceId, AL10.AL_PITCH, pitch);
    }
    
    public void setPosition(float x, float y, float z) {
        AL10.alSource3f(sourceId, AL10.AL_POSITION, x, y, z);
    }
    
    public void play(int buffer) {
        this.stop();
        AL10.alSourcei(sourceId, AL10.AL_BUFFER, buffer);
        this.continuePlaying();
    }
    
    public void pause() {
        AL10.alSourcePause(sourceId);
    }
    
    public void continuePlaying() {
        AL10.alSourcePlay(sourceId);
    }
    
    public void stop() {
        AL10.alSourceStop(sourceId);
    }   
    
    public void delete() {
        this.stop();
        AL10.alDeleteSources(sourceId);
    }
}
