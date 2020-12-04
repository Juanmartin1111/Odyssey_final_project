package lewis.edu.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class OdysseyGame extends ApplicationAdapter {
	private OrthographicCamera cam;
	private SpriteBatch batch;
	private Warriors player1;
	
	@Override
	public void create () {
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 400);
		batch = new SpriteBatch();

		player1 = new Warriors();
		player1.setPosition(200, 100);
		
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(cam.combined);

		batch.begin();
		player1.draw(batch);
		batch.end();

		// Updates

		// Controls  
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
