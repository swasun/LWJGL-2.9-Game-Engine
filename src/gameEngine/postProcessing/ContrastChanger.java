package gameEngine.postProcessing;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

/**
 *
 * @author Charly Lamothe
 */
public class ContrastChanger {
    
    private ImageRenderer renderer;
    private ContrastShader  shader;
    
    public ContrastChanger() {
        this.shader = new ContrastShader();
        this.renderer = new ImageRenderer();
    }
    
    public void render(int texture) {
        this.shader.start();
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture);
        this.renderer.renderQuad();
        this.shader.stop();
    }
    
    public void cleanUp() {
        this.renderer.cleanUp();
        this.shader.cleanUp();
    }
}
