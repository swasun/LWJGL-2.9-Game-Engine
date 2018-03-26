package gameEngine.textures;

import gameEngine.renderEngine.Loader;

public class TerrainTexturePack {

    private TerrainTexture backgroundTexture;
    private TerrainTexture rTexture;
    private TerrainTexture gTexture;
    private TerrainTexture bTexture;

    public TerrainTexturePack(TerrainTexture backgroundTexture, TerrainTexture rTexture,
            TerrainTexture gTexture, TerrainTexture bTexture) {
        this.backgroundTexture = backgroundTexture;
        this.rTexture = rTexture;
        this.gTexture = gTexture;
        this.bTexture = bTexture;
    }

    public TerrainTexturePack(Loader loader, String backgroundTexture, String rTexture,
            String gTexture, String bTexture) {
        this.backgroundTexture = new TerrainTexture(loader.loadGameTexture(backgroundTexture));
        this.rTexture = new TerrainTexture(loader.loadGameTexture(rTexture));
        this.gTexture = new TerrainTexture(loader.loadGameTexture(gTexture));
        this.bTexture = new TerrainTexture(loader.loadGameTexture(bTexture));
    }

    public TerrainTexture getBackgroundTexture() {
        return backgroundTexture;
    }

    public TerrainTexture getrTexture() {
        return rTexture;
    }

    public TerrainTexture getgTexture() {
        return gTexture;
    }

    public TerrainTexture getbTexture() {
        return bTexture;
    }
}
