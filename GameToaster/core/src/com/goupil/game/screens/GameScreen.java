/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goupil.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.goupil.game.GameToasterRun;
import com.goupil.game.wrk.AnimationGenerator;

/**
 *
 * @author renardn
 */
public class GameScreen implements Screen {

    final GameToasterRun game;
    OrthographicCamera camera;
    Animation<TextureRegion> idleAnimation;
    Animation<TextureRegion> walkAnimation;

    public GameScreen(final GameToasterRun game) {
        this.game = game;
        walkAnimation = AnimationGenerator.generate(game.assets.get("characters/sheet_hero_walk.png", Texture.class), 3, 1);
        idleAnimation = AnimationGenerator.generate(game.assets.get("characters/sheet_hero_idle.png", Texture.class), 8, 1);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.stateTime += Gdx.graphics.getDeltaTime() / 9;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        TextureRegion currentFrame = idleAnimation.getKeyFrame(game.stateTime, true);
        game.batch.begin();
        game.font.draw(game.batch, "Hi!!", 50, 50);
        game.batch.draw(currentFrame, 500, 500, 100, 100);
        game.batch.end();
    }

    @Override
    public void show() {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {

    }

}
