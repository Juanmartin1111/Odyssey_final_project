package lewis.edu.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Obstacle extends GameObject {
    Rectangle hitBox;
    Sprite sprite;
    Texture texture;

    public Obstacle(int x, int y) {
        hitBox = new Rectangle(x, y, 64, 37);
        texture = new Texture("images/spikes.png");
        sprite = new Sprite(texture, 0, 27, 64, 37);
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
        
        return hitBox;
    }

    @Override
    public int hits(Rectangle r) {
        
        return -1;
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

	@Override
	public int hitAction(int side) {
		if (side == 1) return 2;
		return 1;
	}
    
}
