package lewis.edu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundMan {
    public static Sound jump;

    public static Music background;

    public static void create() {
        jump = Gdx.audio.newSound(Gdx.files.internal("audio/jump.mp3"));
        
        background = Gdx.audio.newMusic(Gdx.files.internal("audio/background.mp3"));

    }

    public static void dispose() {
        jump.dispose();
        background.dispose();
    }
}
