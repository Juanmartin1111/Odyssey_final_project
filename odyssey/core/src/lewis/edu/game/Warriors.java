package lewis.edu.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Warriors {
    Rectangle bottom, left, right, top;
    Sprite sprite;
    Texture texture;
    int action;
    float veolocity;

    // entry point
    public Warriors() {
        bottom = new Rectangle(0.0f,0.0f, 128.0f, 128.0f);

        texture = new Texture("images/warrior.png");
        sprite = new Sprite(texture, 0,0,128,128);
        this.setPosition(0, 0);
    }

    public int hits(Rectangle r) {
        if (bottom.overlaps(r)) {
            return -1;
        }
        return -1;
    }

    public void action(int type) {

    }

    public void update(float delta) {

    }

    public void setPosition(float x, float y) {
        bottom.x = x;
        bottom.y = y;
        sprite.setPosition(x, y);
    }

    public void moveLeft(float delta) {
        
    }

    public void moveright(float delta) {
        
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

}
