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

package game;

import game.effects.Cosmic;
import game.effects.Effect;
import game.effects.Fire;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gameEngine.models.TexturedModel;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import gameEngine.renderEngine.DisplayManager;
import gameEngine.renderEngine.Loader;
import gameEngine.renderEngine.MasterRenderer;
import gameEngine.terrains.Terrain;
import gameEngine.textures.TerrainTexturePack;
import gameEngine.water.WaterFrameBuffers;
import gameEngine.water.WaterRenderer;
import gameEngine.water.WaterShader;
import gameEngine.water.WaterTile;
import gameEngine.entities.Camera;
import gameEngine.entities.Entity;
import gameEngine.entities.Light;
import game.entities.Player;
import game.flora.ferns.Fern;
import game.flora.trees.Cherry;
import game.flora.trees.Pine;
import game.objects.Lantern;
import gameEngine.audio.AudioMaster;
import gameEngine.audio.Source;
import gameEngine.entities.EntityBuilder;
import gameEngine.fontMeshCreator.FontType;
import gameEngine.fontRendering.TextMaster;
import gameEngine.guis.GuiRenderer;
import gameEngine.guis.GuiTexture;
import gameEngine.particles.ParticleMaster;
import gameEngine.postProcessing.Fbo;
import gameEngine.postProcessing.PostProcessing;
import java.io.File;
import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.AL11;
import org.lwjgl.util.vector.Vector2f;

public class MainGameLoop {

    private static final String ENTITIES_PATH = "entities/";
    private static final String MAPS_PATH = "maps/";
    private static final String CHARACTERS_PATH = ENTITIES_PATH + "character/";
    private static final String FONTS_PATH = "fonts/";
    private static final String TERRAINS_PATH = "terrains/";
    private static final String BLENDMAPS_PATH = MAPS_PATH + "blendmaps/";
    private static final String OBJECTS_PATH = ENTITIES_PATH + "objects/";
    private static final String HEIGHTMAPS_PATH = MAPS_PATH + "heightmaps/";
    private static final String AUDIO_THEMES_PATH = "res/audio/themes/";
    private static final String FLORA_PATH = ENTITIES_PATH + "flora/";
    private static final String FLOWERS_PATH = FLORA_PATH + "flowers/";

    private static final String TEST_TERRAINS_PATH = "testTerrains/";
    private static final String TEST_MAPS_PATH = "testMaps/";
    private static final String TEST_GUIS_PATH = "testGuis/";

    public static void main(String[] args) {

        DisplayManager.createDisplay();
        Loader loader = new Loader();
        
        List<GuiTexture> guiTextures = new ArrayList<GuiTexture>();
        //guiTextures.add(new GuiTexture(loader.loadGameTexture("loadingPage"), new Vector2f(-2f, 1f), new Vector2f(5f, 5f)));
        GuiRenderer guiRenderer = new GuiRenderer(loader);
        //guiRenderer.render(guiTextures);
        //DisplayManager.updateDisplay();
        
        //Init sound
        /*AudioMaster.init();
        AudioMaster.setListenerData(0, 0, 0);
        AL10.alDistanceModel(AL11.AL_LINEAR_DISTANCE);*/
        
        /*int krallThemeBuffer = AudioMaster.loadSound(AUDIO_THEMES_PATH + "krallTheme.wav");
        Source krallTheme = new Source();
        krallTheme.play(krallThemeBuffer);
        krallTheme.setLooping(true);*/
        
        /*int alvaeThemeBuffer = AudioMaster.loadSound(AUDIO_THEMES_PATH + "alvaeTheme.wav");
        Source alvaeTheme = new Source();
        alvaeTheme.play(alvaeThemeBuffer);
        alvaeTheme.setLooping(true);*/
        
        TextMaster.init(loader);

        TexturedModel person = loader.loadTexturedModel(CHARACTERS_PATH + "person/person");
        Player player = new Player(new EntityBuilder(person, new Vector3f(300, 5, -400), 0, 0, 0, 0.6f));

        Camera camera = new Camera(player);
        MasterRenderer renderer = new MasterRenderer(loader, camera);
        ParticleMaster.init(loader, renderer.getProjectionMatrix());

        FontType font = new FontType(loader.loadFontTextureAtlas(FONTS_PATH + "candara"), new File("res/" + FONTS_PATH + "candara.fnt"));
        //GUIText text = new GUIText("Titi", 3f, font, new Vector2f(0.0f, 0.4f), 1f, true);
        //text.setColour(0.1f, 0.1f, 0.1f);

        // *********TERRAIN TEXTURE STUFF**********
        List<Terrain> terrains = new ArrayList<Terrain>();

        //Desert
        TerrainTexturePack desertPack = new TerrainTexturePack(
                loader,
                TEST_TERRAINS_PATH + "desertSand",
                TEST_TERRAINS_PATH + "desertRock",
                TEST_TERRAINS_PATH + "desertSandstone",
                TEST_TERRAINS_PATH + "desertPath"
        );

        //Plains
        TerrainTexturePack plainsPack = new TerrainTexturePack(
                loader,
                TEST_TERRAINS_PATH + "plainsGrass",
                TEST_TERRAINS_PATH + "plainsDirt",
                TEST_TERRAINS_PATH + "plainsGrass2",
                TEST_TERRAINS_PATH + "plainsPath"
        );

        //Jungle
        TerrainTexturePack junglePack = new TerrainTexturePack(
                loader,
                TEST_TERRAINS_PATH + "jungleGrass",
                TEST_TERRAINS_PATH + "junglePathSupport",
                TEST_TERRAINS_PATH + "jungleGrassDark",
                TEST_TERRAINS_PATH + "junglePath"
        );

        //Snow
        TerrainTexturePack snowPack = new TerrainTexturePack(
                loader,
                TEST_TERRAINS_PATH + "snowMain",
                TEST_TERRAINS_PATH + "snowPathSupport",
                TEST_TERRAINS_PATH + "snowIce",
                TEST_TERRAINS_PATH + "snowPath"
        );

        //Evil
        TerrainTexturePack evilPack = new TerrainTexturePack(
                loader,
                TEST_TERRAINS_PATH + "evilMain",
                TEST_TERRAINS_PATH + "evilMainSupport",
                TEST_TERRAINS_PATH + "evilBlood",
                TEST_TERRAINS_PATH + "evilPath"
        );

        //Mountains
        TerrainTexturePack mountainPack = new TerrainTexturePack(
                loader,
                TEST_TERRAINS_PATH + "mountainStone",
                TEST_TERRAINS_PATH + "mountainMud",
                TEST_TERRAINS_PATH + "mountainRock",
                TEST_TERRAINS_PATH + "mountainPath"
        );

        //Mine
        TerrainTexturePack mineEntrancePack = new TerrainTexturePack(
                loader,
                TEST_TERRAINS_PATH + "mountainStone",
                TEST_TERRAINS_PATH + "mountainMud",
                TEST_TERRAINS_PATH + "mountainRock",
                TEST_TERRAINS_PATH + "mountainPath"
        );

        //OriginCityPack
        TerrainTexturePack originCityPack = new TerrainTexturePack(
                loader,
                TEST_TERRAINS_PATH + "plainsGrass",
                TEST_TERRAINS_PATH + "plainsDirt",
                TEST_TERRAINS_PATH + "plainsGrass2",
                TEST_TERRAINS_PATH + "plainsPath"
        );

        Terrain originCity = new Terrain(0, 0, loader, originCityPack, TEST_MAPS_PATH + "originCityBlendMap", TEST_MAPS_PATH + "originCityHM");
        Terrain mineEntrance = new Terrain(0, 1, loader, mineEntrancePack, TEST_MAPS_PATH + "mineEntranceBlendMap", TEST_MAPS_PATH + "mineEntranceHM");
        Terrain plains1 = new Terrain(0, -1, loader, plainsPack, TEST_MAPS_PATH + "plains1BlendMap", TEST_MAPS_PATH + "plains1HM");
        Terrain plains2 = new Terrain(-1, -1, loader, plainsPack, TEST_MAPS_PATH + "plains2BlendMap", TEST_MAPS_PATH + "plains2HM");
        Terrain plains3 = new Terrain(1, -1, loader, plainsPack, TEST_MAPS_PATH + "plains3BlendMap", TEST_MAPS_PATH + "plains3HM");

        Terrain currentTerrain = originCity;

        terrains.add(originCity);
        terrains.add(mineEntrance);
        terrains.add(plains1);
        terrains.add(plains2);
        terrains.add(plains3);

        List<Entity> entities = new ArrayList<Entity>();
        List<Entity> normalMapEntities = new ArrayList<Entity>();

        //************ENTITIES*******************
        int h = 0; // height of objects at the moment
        Random random = new Random(5666778);

        for (int i = 0; i < 320; i++) {
            if (i % 5 == 0) {
                float x = random.nextFloat() * 800;
                float z = random.nextFloat() * -800;

                float y = currentTerrain.getHeightOfTerrain(x, z);
                if (y >= 0) {
                    entities.add(new Cherry(loader, new Vector3f(x, y, z), random));
                }
            }
            if (i % 3 == 0) {
                float x = random.nextFloat() * 800;
                float z = random.nextFloat() * -800;

                float y = currentTerrain.getHeightOfTerrain(x, z);
                if (y >= 0) {
                    entities.add(new Fern(loader, new Vector3f(x, y, z), random));
                }
            }
            if (i % 1 == 0) {
                float x = random.nextFloat() * 800;
                float z = random.nextFloat() * -800;

                if ((x > 50 && x < 100) || (z < -50 && z > -100)) {

                } else {
                    float y = currentTerrain.getHeightOfTerrain(x, z);
                    if (y >= 0) {
                        entities.add(new Pine(loader, new Vector3f(x, y, z), random));
                    }
                }
            }
        }

        entities.add(new Lantern(loader, new Vector3f(300, -10, -400), random));

        /*for (int i = 0; i < 30; i++) {
            float x = 400 + random.nextFloat() * 200;
            float z = -400 + random.nextFloat() * 200;
            float y = currentTerrain.getHeightOfTerrain(x, z);
            
            normalMapEntities.add(new Boulder(loader, new Vector3f(x, y, z), random));
        }*/
        
        // LAMP
        //Entity lamp = new Entity(new EntityBuilder(loader.loadTexturedModel("entity/lamp/lamp"), new Vector3f(100, h, 180), 0, 0, 0, 1));
        //lamp.getModel().getTexture().setShineDamper(40);
        // ROCK 1
        Entity rock1 = new Entity(new EntityBuilder(loader.loadTexturedModel("testEntities/rocks/rock1"), new Vector3f(100, h, 200), 0, 0, 0, 5f));
        entities.add(rock1);
        // ROCK 2
        /*Entity rock2 = new Entity(loader, "Entity/Rock/rock2", "Entity/Rock/texture2",
                new Vector3f(100, h, 220), 0, 0, 0, 5f);
        // ROCK 3
        Entity rock3 = new Entity(loader, "Entity/Rock/rock3", "Entity/Rock/texture3",
                new Vector3f(100, h, 240), 0, 0, 0, 5f);
        // ROCK 4
        Entity rock4 = new Entity(loader, "Entity/Rock/rock4", "Entity/Rock/texture4",
                new Vector3f(100, h, 260), 0, 0, 0, 5f);
        // ROCK 5
        Entity rock5 = new Entity(loader, "Entity/Rock/rock5", "Entity/Rock/texture5",
                new Vector3f(100, h, 280), 0, 0, 0, 5f);
        // ROCK 6
        Entity rock6 = new Entity(loader, "Entity/Rock/rock6", "Entity/Rock/texture6",
                new Vector3f(100, h, 300), 0, 0, 0, 5f);

        // PALM TREE
        Entity palmTree = new Entity(loader, "Entity/Tree/palmTree", "Entity/Tree/palmTreeTexture",
                new Vector3f(100, h, 320), 0, 0, 0, 1);*/
        //*******************OTHER SETUP***************
        List<Light> lights = new ArrayList<Light>();
        Light sun = new Light(new Vector3f(10000, 15000, -10000), new Vector3f(1.3f, 1.3f, 1.3f));
        lights.add(sun);

        entities.add(player);

        //MousePicker picker = new MousePicker(camera, renderer.getProjectionMatrix(), terrain);
        //GUIs
        guiTextures.addAll(setUpGUI(loader));

        //**********Water Renderer Set-up************************
        WaterFrameBuffers buffers = new WaterFrameBuffers();
        WaterShader waterShader = new WaterShader();
        WaterRenderer waterRenderer = new WaterRenderer(loader, waterShader, renderer.getProjectionMatrix(), buffers);
        List<WaterTile> waters = new ArrayList<WaterTile>();
        waters.add(new WaterTile(300, 5, -1.5f));
        /*for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                waters.add(new WaterTile(i * 150, -j * 500, -1.5f));
            }
        }*/

        //PostProcessing
        Fbo multisampleFbo = new Fbo(Display.getWidth(), Display.getHeight());
        Fbo outputFbo = new Fbo(Display.getWidth(), Display.getHeight(), Fbo.DEPTH_TEXTURE);
        Fbo outputFbo2 = new Fbo(Display.getWidth(), Display.getHeight(), Fbo.DEPTH_TEXTURE);
        PostProcessing.init(loader);

        //Effects
        Effect fire = new Fire();
        Effect cosmic = new Cosmic();

        //****************Game Loop Below*********************
        while (!Display.isCloseRequested()) {
            for (Terrain terrain : terrains) {
                if (player.getCurrentGridX() == terrain.getGridX() && player.getCurrentGridZ() == terrain.getGridZ()) {
                    currentTerrain = terrain;
                }
            }

            //player.move(currentTerrain);
            for (Entity entity : entities) {
                entity.move(currentTerrain);
            }
            camera.move();

            //picker.update();
            //render all terrains that surround the player, including the one the player is on (so 9 of them)
            for (Terrain terrain : terrains) {
                if ((player.getCurrentGridX()) == terrain.getGridX() && player.getCurrentGridZ() == terrain.getGridZ()) {
                    renderer.processTerrain(terrain);	// 0, 0
                }
                if ((player.getCurrentGridX() + 1) == terrain.getGridX() && player.getCurrentGridZ() == terrain.getGridZ()) {
                    renderer.processTerrain(terrain);	// 1, 0
                }
                if ((player.getCurrentGridX() - 1) == terrain.getGridX() && player.getCurrentGridZ() == terrain.getGridZ()) {
                    renderer.processTerrain(terrain);	// -1,0
                }
                if (player.getCurrentGridX() == terrain.getGridX() && (player.getCurrentGridZ() + 1) == terrain.getGridZ()) {
                    renderer.processTerrain(terrain);	// 0, 1
                }
                if (player.getCurrentGridX() == terrain.getGridX() && (player.getCurrentGridZ() - 1) == terrain.getGridZ()) {
                    renderer.processTerrain(terrain);	// 0, -1
                }
                if ((player.getCurrentGridX() + 1) == terrain.getGridX() && (player.getCurrentGridZ() + 1) == terrain.getGridZ()) {
                    renderer.processTerrain(terrain);	// 1, 1
                }
                if ((player.getCurrentGridX() - 1) == terrain.getGridX() && (player.getCurrentGridZ() - 1) == terrain.getGridZ()) {
                    renderer.processTerrain(terrain);	// -1, -1
                }
                if ((player.getCurrentGridX() + 1) == terrain.getGridX() && (player.getCurrentGridZ() - 1) == terrain.getGridZ()) {
                    renderer.processTerrain(terrain);	// 1, -1
                }
                if ((player.getCurrentGridX() - 1) == terrain.getGridX() && (player.getCurrentGridZ() + 1) == terrain.getGridZ()) {
                    renderer.processTerrain(terrain);	// -1, 1
                }
            }

            for (Entity entity : entities) {
                if ((player.getCurrentGridX()) == entity.getGridX() && player.getCurrentGridZ() == entity.getGridZ()) {
                    renderer.processEntity(entity);	// 0, 0
                }
                if ((player.getCurrentGridX() + 1) == entity.getGridX() && player.getCurrentGridZ() == entity.getGridZ()) {
                    renderer.processEntity(entity);	// 1, 0
                }
                if ((player.getCurrentGridX() - 1) == entity.getGridX() && player.getCurrentGridZ() == entity.getGridZ()) {
                    renderer.processEntity(entity);	// -1,0
                }
                if (player.getCurrentGridX() == entity.getGridX() && (player.getCurrentGridZ() + 1) == entity.getGridZ()) {
                    renderer.processEntity(entity);	// 0, 1
                }
                if (player.getCurrentGridX() == entity.getGridX() && (player.getCurrentGridZ() - 1) == entity.getGridZ()) {
                    renderer.processEntity(entity);	// 0, -1
                }
                if ((player.getCurrentGridX() + 1) == entity.getGridX() && (player.getCurrentGridZ() + 1) == entity.getGridZ()) {
                    renderer.processEntity(entity);	// 1, 1
                }
                if ((player.getCurrentGridX() - 1) == entity.getGridX() && (player.getCurrentGridZ() - 1) == entity.getGridZ()) {
                    renderer.processEntity(entity);	// -1, -1
                }
                if ((player.getCurrentGridX() + 1) == entity.getGridX() && (player.getCurrentGridZ() - 1) == entity.getGridZ()) {
                    renderer.processEntity(entity);	// 1, -1
                }
                if ((player.getCurrentGridX() - 1) == entity.getGridX() && (player.getCurrentGridZ() + 1) == entity.getGridZ()) {
                    renderer.processEntity(entity);	// -1, 1
                }
            }

            if (Keyboard.isKeyDown(Keyboard.KEY_1)) {
                fire.generate(new Vector3f(player.getPosition()));
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_2)) {
                cosmic.generate(new Vector3f(player.getPosition()));
            }

            ParticleMaster.update(camera);

            renderer.renderShadowMap(entities, sun);
            GL11.glEnable(GL30.GL_CLIP_DISTANCE0);

            //render reflection teture
            buffers.bindReflectionFrameBuffer();
            float distance = 2 * (camera.getPosition().y - waters.get(0).getHeight());
            //float distance = 2 * (camera.getPosition().y - -15);
            camera.getPosition().y -= distance;
            camera.invertPitch();
            renderer.renderScene(entities, normalMapEntities, terrains, lights, camera, new Vector4f(0, 1, 0, -waters.get(0).getHeight() + 1));
            camera.getPosition().y += distance;
            camera.invertPitch();

            //render refraction texture
            buffers.bindRefractionFrameBuffer();
            renderer.renderScene(entities, normalMapEntities, terrains, lights, camera, new Vector4f(0, -1, 0, waters.get(0).getHeight()));

            //render to screen
            GL11.glDisable(GL30.GL_CLIP_DISTANCE0);
            buffers.unbindCurrentFrameBuffer();

            multisampleFbo.bindFrameBuffer();
            renderer.renderScene(entities, normalMapEntities, terrains, lights, camera, new Vector4f(0, -1, 0, 100000));
            waterRenderer.render(waters, camera, sun);
            ParticleMaster.renderParticles(camera);
            multisampleFbo.unbindFrameBuffer();
            multisampleFbo.resolveToFbo(GL30.GL_COLOR_ATTACHMENT0, outputFbo);
            multisampleFbo.resolveToFbo(GL30.GL_COLOR_ATTACHMENT1, outputFbo2);
            PostProcessing.doPostProcessing(outputFbo.getColourTexture(), outputFbo2.getColourTexture());

            guiRenderer.render(guiTextures);
            TextMaster.render();

            DisplayManager.updateDisplay();
        }

        //*********Clean Up Below**************
        //fire.cleanUp();
        //cosmic.cleanUp();
        //alvaeTheme.delete();
        //AudioMaster.cleanUp();
        PostProcessing.cleanUp();
        outputFbo.cleanUp();
        outputFbo2.cleanUp();
        multisampleFbo.cleanUp();
        ParticleMaster.cleanUp();
        TextMaster.cleanUp();
        buffers.cleanUp();
        waterShader.cleanUp();
        guiRenderer.cleanUp();
        renderer.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
    }

    // Create GUIs and set positions. Then return a filled list for the gui
    public static List<GuiTexture> setUpGUI(Loader loader) {

        // List for use in this method
        List<GuiTexture> list = new ArrayList<GuiTexture>();

        // Variables to be modified depending on the GUI area being set up
        float space = 0f;
        float spaceIncrement = 0.065f;
        float startingPosX = -0.293f;
        float startingPosY = -0.9f;

        // ACTION BARS
        GuiTexture abFrame = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "abFrame"), new Vector2f(0.0f, startingPosY), new Vector2f(0.33f, 0.07f));
        GuiTexture ab1 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "ab1"), new Vector2f(startingPosX + space, startingPosY), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture ab2 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "ab2"), new Vector2f(startingPosX + space, startingPosY), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture ab3 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "ab3"), new Vector2f(startingPosX + space, startingPosY), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture ab4 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "ab4"), new Vector2f(startingPosX + space, startingPosY), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture ab5 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "ab5"), new Vector2f(startingPosX + space, startingPosY), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture ab6 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "ab6"), new Vector2f(startingPosX + space, startingPosY), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture ab7 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "ab7"), new Vector2f(startingPosX + space, startingPosY), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture ab8 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "ab8"), new Vector2f(startingPosX + space, startingPosY), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture ab9 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "ab9"), new Vector2f(startingPosX + space, startingPosY), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture ab0 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "ab0"), new Vector2f(startingPosX + space, startingPosY), new Vector2f(0.03f, 0.058f));

        // FIREBALL ABILITY EXAMPLE
        GuiTexture fireAbility = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "fire"), new Vector2f(-0.293f, startingPosY), new Vector2f(0.03f, 0.058f));
        GuiTexture cosmicAbility = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "cosmic"), new Vector2f(-0.293f + 0.065f, startingPosY), new Vector2f(0.03f, 0.058f));

        /*// HEALTH AND MAGIC ENERGY BAR
        GuiTexture healthBar = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "abHealth"), new Vector2f(0.0f, -0.72f), new Vector2f(0.33f, 0.03f));
        GuiTexture energyBar = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "abEnergy"), new Vector2f(0.0f, -0.79f), new Vector2f(0.33f, 0.03f));

        // change variables
        space = 0f;
        spaceIncrement = 0.12f;
        startingPosX = 0.95f;
        startingPosY = -0.9f;

        // RIGHT SIDE INTERFACE (INVENTORY, ETC)
        GuiTexture rightFrame = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "fillerFrame"), new Vector2f(startingPosX - 0.315f, -0.66f), new Vector2f(0.28f, 0.30f));
        GuiTexture fillerR1 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "filler"), new Vector2f(startingPosX, startingPosY + space), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture fillerR2 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "filler"), new Vector2f(startingPosX, startingPosY + space), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture fillerR3 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "filler"), new Vector2f(startingPosX, startingPosY + space), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture fillerR4 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "filler"), new Vector2f(startingPosX, startingPosY + space), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture fillerR5 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "filler"), new Vector2f(startingPosX, startingPosY + space), new Vector2f(0.03f, 0.058f));

        // change variables
        space = 0f;
        spaceIncrement = 0.12f;
        startingPosX = -0.95f;
        startingPosY = -0.9f;

        // LEFT SIDE INTERFACE (INVENTORY, ETC)
        GuiTexture leftFrame = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "fillerFrame"), new Vector2f(startingPosX + 0.315f, -0.66f), new Vector2f(0.28f, 0.30f));
        GuiTexture fillerL1 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "filler"), new Vector2f(startingPosX, startingPosY + space), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture fillerL2 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "filler"), new Vector2f(startingPosX, startingPosY + space), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture fillerL3 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "filler"), new Vector2f(startingPosX, startingPosY + space), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture fillerL4 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "filler"), new Vector2f(startingPosX, startingPosY + space), new Vector2f(0.03f, 0.058f));
        space += spaceIncrement;
        GuiTexture fillerL5 = new GuiTexture(loader.loadGameTexture(TEST_GUIS_PATH + "filler"), new Vector2f(startingPosX, startingPosY + space), new Vector2f(0.03f, 0.058f));*/
        // add to GUI
        list.add(abFrame);
        list.add(fireAbility);
        list.add(cosmicAbility);
        list.add(ab1);
        list.add(ab2);
        list.add(ab3);
        list.add(ab4);
        list.add(ab5);
        list.add(ab6);
        list.add(ab7);
        list.add(ab8);
        list.add(ab9);
        list.add(ab0);

        /*list.add(healthBar);
        list.add(energyBar);*/

 /*list.add(rightFrame);
        list.add(fillerR1);
        list.add(fillerR2);
        list.add(fillerR3);
        list.add(fillerR4);
        list.add(fillerR5);

        list.add(leftFrame);
        list.add(fillerL1);
        list.add(fillerL2);
        list.add(fillerL3);
        list.add(fillerL4);
        list.add(fillerL5);*/
        return list;
    }
}
