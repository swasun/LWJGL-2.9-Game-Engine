package gameEngine.postProcessing;

import gameEngine.shaders.ShaderProgram;

public class ContrastShader extends ShaderProgram {

    private static final String VERTEX_FILE = "src/gameEngine/postProcessing/contrastVertex.txt";
    private static final String FRAGMENT_FILE = "src/gameEngine/postProcessing/contrastFragment.txt";

    public ContrastShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void getAllUniformLocations() {
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
}
