package lewis.edu.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class skulls extends GameObject {

    Rectangle hitBox;
    Sprite sprite;
    Texture texture;

    public skulls(int x, int y) {
        hitBox = new Rectangle(0, 0, 5, 16);
       // texture = new Texture(file)
    }

    @Override
    public void action(int type, float x, float y) {
        // TODO Auto-generated method stub

    }

    @Override
    public void draw(SpriteBatch batch) {
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub

    }

    @Override
    public void update(float delta) {
        // TODO Auto-generated method stub

    }
    
}
