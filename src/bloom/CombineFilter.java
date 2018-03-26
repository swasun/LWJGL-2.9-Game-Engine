package gameEngine.bloom;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import gameEngine.postProcessing.ImageRenderer;

public class CombineFilter {

    private ImageRenderer renderer;
    private CombineShader shader;

    public CombineFilter() {
        shader = new CombineShader();
        shader.start();
        shader.connectTextureUnits();
        shader.stop();
        renderer = new ImageRenderer();
    }

    public void render(int colourTexture, int highlightTexture) {
        shader.start();
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, colourTexture);
        GL13.glActiveTexture(GL13.GL_TEXTURE1);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, highlightTexture);
        renderer.renderQuad();
        shader.stop();
    }

    public void cleanUp() {
        renderer.cleanUp();
        shader.cleanUp();
    }
}
