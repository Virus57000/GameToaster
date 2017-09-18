package com.goupil.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.goupil.game.screens.MainMenuScreen;

public class GameToasterRun extends Game implements ApplicationListener {

    public SpriteBatch batch;
    public AssetManager assets;
    public BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        assets = new AssetManager();
        font = new BitmapFont();
        assets.load("", type);
        this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

}
