/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goupil.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
    int x = 0;
    boolean moving = false;

    public GameScreen(final GameToasterRun game) {
        this.game = game;
        walkAnimation = AnimationGenerator.generate(game.assets.get("characters/sheet_hero_walk.png", Texture.class), 3, 1);
        idleAnimation = AnimationGenerator.generate(game.assets.get("characters/sheet_hero_idle.png", Texture.class), 8, 1);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.stateTime += Gdx.graphics.getDeltaTime() / 8;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        TextureRegion walkFrame = walkAnimation.getKeyFrame(game.stateTime, true);
        TextureRegion idleFrame = idleAnimation.getKeyFrame(game.stateTime, true);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            walkFrame.flip(true, false);
            if (x < -100) {
                x += 5;
            } else {
                x += -5;
            }
            moving = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            walkFrame.flip(false, true);
            if (x > 1180) {
                x += -5;
            } else {
                x += 5;
            }
            moving = true;
        }
        game.batch.begin();
        game.font.draw(game.batch, "Hi!!", 50, 50);
        if (moving) {
            game.batch.draw(walkFrame, x, 200, 200, 200);
        } else {
            game.batch.draw(idleFrame, x, 200, 200, 200);
        }
        game.batch.end();
        moving = false;
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
