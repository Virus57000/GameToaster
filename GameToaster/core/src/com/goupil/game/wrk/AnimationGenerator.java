/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goupil.game.wrk;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author renardn
 */
public class AnimationGenerator {

    public AnimationGenerator() {
    }

    public static Animation<TextureRegion> generate(Texture texture, int nbrCol, int nbrRow) {
        Animation<TextureRegion> animation;
        TextureRegion[][] tmp = TextureRegion.split(texture,
                texture.getWidth() / nbrCol,
                texture.getHeight() / nbrRow);

        // Place the regions into a 1D array in the correct order, starting from the top 
        // left, going across first. The Animation constructor requires a 1D array.
        TextureRegion[] walkFrames = new TextureRegion[nbrCol * nbrRow];
        int index = 0;
        for (int i = 0; i < nbrRow; i++) {
            for (int j = 0; j < nbrCol; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }

        // Initialize the Animation with the frame interval and array of frames
        animation = new Animation<TextureRegion>(0.025f, walkFrames);
        return animation;
    }

}
