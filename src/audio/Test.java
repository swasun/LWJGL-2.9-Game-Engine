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
