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

package gameEngine.shadows;

import java.nio.ByteBuffer;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL32;

/**
 * The frame buffer for the shadow pass. This class sets up the depth texture
 * which can be rendered to during the shadow render pass, producing a shadow
 * map.
 *
 * @author Karl
 *
 */
public class ShadowFrameBuffer {

    private final int WIDTH;
    private final int HEIGHT;
    private int fbo;
    private int shadowMap;

    /**
     * Initialises the frame buffer and shadow map of a certain size.
     *
     * @param width - the width of the shadow map in pixels.
     * @param height - the height of the shadow map in pixels.
     */
    protected ShadowFrameBuffer(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        initialiseFrameBuffer();
    }

    /**
     * Deletes the frame buffer and shadow map texture when the game closes.
     */
    protected void cleanUp() {
        GL30.glDeleteFramebuffers(fbo);
        GL11.glDeleteTextures(shadowMap);
    }

    /**
     * Binds the frame buffer, setting it as the current render target.
     */
    protected void bindFrameBuffer() {
        bindFrameBuffer(fbo, WIDTH, HEIGHT);
    }

    /**
     * Unbinds the frame buffer, setting the default frame buffer as the current
     * render target.
     */
    protected void unbindFrameBuffer() {
        GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, 0);
        GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
    }

    /**
     * @return The ID of the shadow map texture.
     */
    protected int getShadowMap() {
        return shadowMap;
    }

    /**
     * Creates the frame buffer and adds its depth attachment texture.
     */
    private void initialiseFrameBuffer() {
        fbo = createFrameBuffer();
        shadowMap = createDepthBufferAttachment(WIDTH, HEIGHT);
        unbindFrameBuffer();
    }

    /**
     * Binds the frame buffer as the current render target.
     *
     * @param frameBuffer - the frame buffer.
     * @param width - the width of the frame buffer.
     * @param height - the height of the frame buffer.
     */
    private static void bindFrameBuffer(int frameBuffer, int width, int height) {
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
        GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, frameBuffer);
        GL11.glViewport(0, 0, width, height);
    }

    /**
     * Creates a frame buffer and binds it so that attachments can be added to
     * it. The draw buffer is set to none, indicating that there's no colour
     * buffer to be rendered to.
     *
     * @return The newly created frame buffer's ID.
     */
    private static int createFrameBuffer() {
        int frameBuffer = GL30.glGenFramebuffers();
        GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, frameBuffer);
        GL11.glDrawBuffer(GL11.GL_NONE);
        GL11.glReadBuffer(GL11.GL_NONE);
        return frameBuffer;
    }

    /**
     * Creates a depth buffer texture attachment.
     *
     * @param width - the width of the texture.
     * @param height - the height of the texture.
     * @return The ID of the depth texture.
     */
    private static int createDepthBufferAttachment(int width, int height) {
        int texture = GL11.glGenTextures();
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture);
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL14.GL_DEPTH_COMPONENT16, width, height, 0,
                GL11.GL_DEPTH_COMPONENT, GL11.GL_FLOAT, (ByteBuffer) null);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
        GL32.glFramebufferTexture(GL30.GL_FRAMEBUFFER, GL30.GL_DEPTH_ATTACHMENT, texture, 0);
        return texture;
    }
}
