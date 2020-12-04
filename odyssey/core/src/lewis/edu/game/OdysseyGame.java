package lewis.edu.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class OdysseyGame extends ApplicationAdapter {
	private OrthographicCamera cam;
	private SpriteBatch batch;
	private Warriors player1;
	private ArrayList<GameObject> list = new ArrayList<GameObject>();
	
	@Override
	public void create () {
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 400);
		batch = new SpriteBatch();

		player1 = new Warriors();
		player1.setPosition(200, 100);
		
		list.add(new Bricks(0,0));
		list.add(new Bricks(64,0));
		list.add(new Bricks(128,0));
		list.add(new Bricks(256,128));
		list.add(new Bricks(320,128));



		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(cam.combined);

		batch.begin();
		player1.draw(batch);
		for (GameObject t : list) {
			t.draw(batch);
		}
		batch.end();

		// Updates
		player1.update(Gdx.graphics.getDeltaTime());
		Rectangle temp = new Rectangle(0, 0, 800, 10);
		if (player1.hits(temp) != -1) {
			player1.action(1, 0, 10);
		}

		for (GameObject t : list) {
			if (player1.hits(t.getHitBox()) != -1) {
				player1.action(1, 0, t.getHitBox().y + t.getHitBox().height);
			}
		}
		// Controls
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player1.moveLeft(Gdx.graphics.getDeltaTime());
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player1.moveRight(Gdx.graphics.getDeltaTime());
		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			player1.jump();
		}   
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
