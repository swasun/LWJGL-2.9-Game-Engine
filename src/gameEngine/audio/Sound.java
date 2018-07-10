/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameEngine.audio;

/**
 *
 * @author swa
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
