package lewis.edu.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Suns extends GameObject {

    Rectangle hitBox;
    Sprite sprite;
    Texture texture;

    public Suns(int x, int y) {
        hitBox = new Rectangle(0, 0, 50, 50);
        sprite = new Sprite(TexManager.sun, 0,0, 50, 50);
        setPosition(x, y);
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
        return hitBox;
    }

    @Override
    public int hitAction(int side) {
        return 3;
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
        hitBox.x = x;
        hitBox.y = y;
        sprite.setPosition(x, y);

    }

    @Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
    }
}

