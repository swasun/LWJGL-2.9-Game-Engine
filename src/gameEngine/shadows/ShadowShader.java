package gameEngine.shadows;

import org.lwjgl.util.vector.Matrix4f;

import gameEngine.shaders.ShaderProgram;

public class ShadowShader extends ShaderProgram {

    private static final String VERTEX_FILE = "src/gameEngine/shadows/shadowVertexShader.txt";
    private static final String FRAGMENT_FILE = "src/gameEngine/shadows/shadowFragmentShader.txt";

    private int location_mvpMatrix;

    protected ShadowShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void getAllUniformLocations() {
        location_mvpMatrix = super.getUniformLocation("mvpMatrix");
    }

    protected void loadMvpMatrix(Matrix4f mvpMatrix) {
        super.loadMatrix(location_mvpMatrix, mvpMatrix);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "in_position");
        super.bindAttribute(1, "in_texturecoords");
    }
}
