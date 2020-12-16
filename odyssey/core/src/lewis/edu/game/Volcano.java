package lewis.edu.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Volcano extends GameObject {

    Sprite sprite;
    public Volcano (float x, float y, float size) {
        sprite = new Sprite(TexManager.volcano);
        sprite.setSize(64*size, 64*size);
        this.setPosition(x, y);
    }

    @Override
    public void action(int type, float x, float y) {
        setPosition(sprite.getX() - x/2, sprite.getY());

    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);

    }

    @Override
    public Rectangle getHitBox() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int hitAction(int side) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int hits(Rectangle r) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void jump() {
        // TODO Auto-generated method stub

    }

    @Override
    public void moveLeft(float delta) {
        int speed = 80;
        setPosition(sprite.getX() - (speed * delta), sprite.getY());

    }

    @Override
    public void moveRight(float delta) {
        int speed = 80;
        setPosition(sprite.getX() + (speed * delta), sprite.getY());

    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);

    }

    @Override
    public void update(float delta) {
        // TODO Auto-generated method stub

    }
    
}
