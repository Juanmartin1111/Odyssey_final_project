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
        full = new Rectangle(0.0f,0.0f, 128.0f, 128.0f);
        bottom = new Rectangle(0, 0, 128, 16);
        left = new Rectangle(0, 16, 64, 96);
        right = new Rectangle(64, 16, 64, 96);
        top = new Rectangle(0, 112, 128, 16);


        texture = new Texture("images/escanor.png");
        sprite = new Sprite(texture, 0,0,128,128);
        this.setPosition(0, 0);
        velocityY = 0;
    }

    public int hits(Rectangle r) {
        if (left.overlaps(r)) {
            return 2;
        }
        if (right.overlaps(r)) {
            return 3;
        }
        if (top.overlaps(r)) {
            return 4;
        }
        if (bottom.overlaps(r)) {
            return 1;
        }
        return -1;
    }

    public void action(int type, float x, float y) {
        if (type == 1) {
            velocityY = 0;
            setPosition(bottom.x, y);
        }
    }

    public void update(float delta) {
        velocityY -= 500 * delta;
        bottom.y += velocityY;
        sprite.setPosition(bottom.x, bottom.y + (velocityY*delta));
    }

    public void setPosition(float x, float y) {
        bottom.x = x;
        bottom.y = y;
        sprite.setPosition(x, y);
    }

    public void moveLeft(float delta) {
        int speed = 100;
        setPosition(bottom.x - (speed * delta), bottom.y);
        if (direction == 1) {
            direction = 0;
            sprite.flip(true, false);
        }
    }

    public void moveRight(float delta) {
        int speed = 100;
        setPosition(bottom.x - (speed * delta), bottom.y);
        if (direction == 0) {
            direction = 1;
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

}
