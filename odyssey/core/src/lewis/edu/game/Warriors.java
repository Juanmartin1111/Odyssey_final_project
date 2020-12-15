package lewis.edu.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Warriors extends GameObject {
    Rectangle bottom, left, right, top, full;
    Sprite sprite;
    Texture texture;
    int action;
    float velocityY;
    int direction = 0;

    // entry point
    public Warriors() {
        full = new Rectangle(0.0f, 0.0f, 128.0f, 128.0f);
        bottom = new Rectangle(0, 0, 128, 16);
        left = new Rectangle(0, 16, 64, 96);
        right = new Rectangle(64, 16, 64, 96);
        top = new Rectangle(0, 112, 128, 16);

        sprite = new Sprite(TexManager.warrior, 0, 0, 128, 128);
        setPosition(50, 300);
        velocityY = 0;
    }

    public int hits(Rectangle r) {
        if (left.overlaps(r)) {
            return 2;
        }
        if (right.overlaps(r)) {
            return 3;
        }
        if (bottom.overlaps(r)) {
            return 1;
        }
        if (top.overlaps(r)) {
            return 4;
        }
        return -1;
    }

    public void action(int type, float x, float y) {
        if (type == 1 || type == 4) {
            velocityY = 0;
            setPosition(bottom.x, y);
        }
        if (type == 2 || type == 3) {
            velocityY = 0;
            setPosition(x, bottom.y);
        }
    }

    public void update(float delta) {
        velocityY -= 500 * delta;
        setPosition(bottom.x, bottom.y + (velocityY * delta));
    }

    public void setPosition(float x, float y) {
        full.x = x;
        full.y = y;

        bottom.x = x;
        bottom.y = y;

        left.x = x;
        left.y = y + 16;

        right.x = x + 64;
        right.y = y + 16;

        top.x = x;
        top.y = y + 112;

        sprite.setPosition(x, y);
    }

    public void moveLeft(float delta) {
        int speed = 200;
        setPosition(bottom.x - (speed * delta), bottom.y);
        if (direction == 0) {
            direction = 1;
            sprite.flip(true, false);
        }
    }

    public void moveRight(float delta) {
        int speed = 200;
        setPosition(bottom.x + (speed * delta), bottom.y);
        if (direction == 1) {
            direction = 0;
            sprite.flip(true, false);
        }
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void jump() {
        if (velocityY == 0) {
            velocityY = 400;
        }
    }

    @Override
    public Rectangle getHitBox() {

        return full;
    }

    @Override
    public int hitAction(int side) {
        // TODO Auto-generated method stub
        return 0;
    }

}
