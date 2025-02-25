package com.mygdx.galaxix;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Player {
    private Vector2 position;
    private Vector2 velocity;
    private Rectangle bounds;

    private Texture spriteSheet;
    private Animation<TextureRegion> walkAnimation;
    private TextureRegion currentFrame;

    private float stateTime = 0f;
    private boolean movingLeft = false;
    private boolean movingRight = false;

    private static final float SPEED = 100f;

    public Player(float x, float y) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        bounds = new Rectangle(x, y, 32, 32);

        spriteSheet = new Texture("player/idle/idle1.png");
        TextureRegion[][] tmp = TextureRegion.split(spriteSheet, 32, 32);
        Array<TextureRegion> frames = new Array<>();

        for (int i = 0; i < 4; i++) {
            frames.add(tmp[0][i]);
        }

        walkAnimation = new Animation<>(0.1f, frames, Animation.PlayMode.LOOP);
        currentFrame = walkAnimation.getKeyFrame(0);
    }

    public void update(float delta) {
        stateTime += delta;

        if (movingLeft) {
            velocity.x = -SPEED;
        } else if (movingRight) {
            velocity.x = SPEED;
        } else {
            velocity.x = 0;
        }

        position.add(velocity.x * delta, velocity.y * delta);
        bounds.setPosition(position);

        if (movingLeft || movingRight) {
            currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        } else {
            currentFrame = walkAnimation.getKeyFrame(0);
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(currentFrame, position.x, position.y);
    }

    public void moveLeft(boolean move) {
        movingLeft = move;
    }

    public void moveRight(boolean move) {
        movingRight = move;
    }

    public void dispose() {
        spriteSheet.dispose();
    }
}
