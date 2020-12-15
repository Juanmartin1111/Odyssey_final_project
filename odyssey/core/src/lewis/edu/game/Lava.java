package lewis.edu.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Lava extends GameObject {

    Sprite sprite;

    public Lava(float x, float y) {
        sprite = new Sprite(TexManager.lava);
        this.setPosition(x, y);
    }

    @Override
    public void action(int type, float x, float y) {
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub

    }

    @Override
    public void moveRight(float delta) {
        // TODO Auto-generated method stub

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
