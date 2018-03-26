package gameEngine.particles;

/**
 *
 * @author Charly Lamothe
 */
public class ParticleTexture {

    private int textureID;
    private int numberOfRows;
    private boolean additive = false;

    public ParticleTexture(int textureID, int numberOfRows) {
        this.textureID = textureID;
        this.numberOfRows = numberOfRows;
    }

    protected int getTextureID() {
        return textureID;
    }

    protected int getNumberOfRows() {
        return numberOfRows;
    }

    protected boolean isAdditive() {
        return additive;
    }

    public void setAdditive(boolean additive) {
        this.additive = additive;
    }
}
