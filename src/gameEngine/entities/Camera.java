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

package gameEngine.entities;

import game.entities.Player;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class Camera {

    private float distanceFromPlayer = 35;
    private float angleAroundPlayer = 0;

    private Vector3f position = new Vector3f(0, 0, 0);
    private float pitch = 20;
    private float yaw = 0;
    private float roll;

    private Player player;

    public Camera(Player player) {
        this.player = player;
    }

    public void move() {
        calculateZoom();
        calculatePitch();
        calculateAngleAroundPlayer();
        float horizontalDistance = calculateHorizontalDistance();
        float verticalDistance = calculateVerticalDistance();
        calculateCameraPosition(horizontalDistance, verticalDistance);
        this.yaw = 180 - (player.getRotY() + angleAroundPlayer);
        yaw %= 360;
    }

    public void invertPitch() {
        this.pitch = -pitch;
    }

    public Vector3f getPosition() {
        return position;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getRoll() {
        return roll;
    }

    private void calculateCameraPosition(float horizDistance, float verticDistance) {
        float theta = player.getRotY() + angleAroundPlayer;
        float offsetX = (float) (horizDistance * Math.sin(Math.toRadians(theta)));
        float offsetZ = (float) (horizDistance * Math.cos(Math.toRadians(theta)));
        position.x = player.getPosition().x - offsetX;
        position.z = player.getPosition().z - offsetZ;
        position.y = player.getPosition().y + verticDistance + 4;
    }

    private float calculateHorizontalDistance() {
        return (float) (distanceFromPlayer * Math.cos(Math.toRadians(pitch + 4)));
    }

    private float calculateVerticalDistance() {
        return (float) (distanceFromPlayer * Math.sin(Math.toRadians(pitch + 4)));
    }

    private void calculateZoom() {
        float zoomLevel = Mouse.getDWheel() * 0.03f;
        distanceFromPlayer -= zoomLevel;
        if (distanceFromPlayer < -2) {
            distanceFromPlayer = -2;
        } else if (distanceFromPlayer > 80) {
            distanceFromPlayer = 80;
        }
    }

    private void calculatePitch() {
        if (Mouse.isButtonDown(1)) {
            float pitchChange = Mouse.getDY() * 0.2f;
            pitch -= pitchChange;
            if (pitch < 0) {
                pitch = 0;
            } else if (pitch > 90) {
                pitch = 90;
            }
        }
    }

    private void calculateAngleAroundPlayer() {
        if (Mouse.isButtonDown(1)) {
            float angleChange = Mouse.getDX() * 0.3f;
            angleAroundPlayer -= angleChange;
        }
    }
}
