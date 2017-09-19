/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goupil.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
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
    int jumpQueue = 0;
    boolean moving = false;
    boolean toTheRight = true;
    boolean isJumping = false;
    Sprite bg1;
    Sprite bg2;
    Sprite bg3;
    float positionX = 0f;
    float positionY;
    float velocityX = 4.0f;
    float velocityY = 0.0f;
    float gravity = 0.5f;

    public GameScreen(final GameToasterRun game) {
        this.positionY = game.ground;
        this.game = game;
        walkAnimation = AnimationGenerator.generate(game.assets.get("characters/sheet_hero_walk.png", Texture.class), 3, 1);
        idleAnimation = AnimationGenerator.generate(game.assets.get("characters/sheet_hero_idle.png", Texture.class), 8, 1);
        bg3 = new Sprite(game.assets.get("nature/bg/saturated/01_ground.png", Texture.class));
        bg1 = new Sprite(game.assets.get("nature/bg/saturated/11_background.png", Texture.class));
        bg2 = new Sprite(game.assets.get("nature/bg/saturated/10_distant_clouds.png", Texture.class));
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
        if (isJumping) {

        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (!isJumping) {
                velocityY = -12.0f;
                isJumping = true;
            }
        }
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            toTheRight = false;
            if (positionX < -100) {
                positionX += 5;
            } else {
                positionX += -5;
            }
            moving = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            toTheRight = true;
            if (positionX > 1180) {
                positionX += -5;
            } else {
                positionX += 5;
            }
            moving = true;
        }
        game.batch.begin();
        game.batch.draw(bg1, 0, 0, 1280, 720);
        game.batch.draw(bg2, 0, 0, 1280, 720);
        game.batch.draw(bg3, 0, 0, 1280, 720);
        game.font.draw(game.batch, "Hi!!", 50, 50);
        if (moving) {
            if (toTheRight) {
                game.batch.draw(walkFrame, positionX, game.ground, 200, 200);
            } else {
                game.batch.draw(walkFrame, positionX + 200, game.ground, -200, 200);
            }
        } else {
            if (toTheRight) {
                game.batch.draw(idleFrame, positionX, game.ground, 200, 200);
            } else {
                game.batch.draw(idleFrame, positionX + 200, game.ground, -200, 200);
            }
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
