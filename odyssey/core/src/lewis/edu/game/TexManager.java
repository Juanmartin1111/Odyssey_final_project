package lewis.edu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TexManager {
    public static Texture brick;
    public static Texture sun;
    public static Texture warrior;
    public static Texture castle;
    public static Texture obstacle;
    

    public static void create() {
        brick = new Texture("images/sand.png");
        sun = new Texture(Gdx.files.internal("images/sun.png"));
        warrior = new Texture("images/escanor14.png");
        castle =  new Texture(Gdx.files.internal("images/castle.png"));
        obstacle = new Texture("images/spikes.png");
    }
    public static void dispose() {
        brick.dispose();
        sun.dispose();
        warrior.dispose();
        castle.dispose();
        obstacle.dispose();
    }
}
