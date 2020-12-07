package lewis.edu.game;

import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.StringTokenizer;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Input.Keys;

public class OdysseyGame extends ApplicationAdapter {
	private OrthographicCamera cam;
	private SpriteBatch batch;
	private Warriors player1;
	private ArrayList<GameObject> list = new ArrayList<GameObject>();
	private ArrayList<GameObject> pDelete = new ArrayList<GameObject>();
	private int level = 1;

	@Override
	public void create () {
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();

		player1 = new Warriors();
		player1.setPosition(200, 100);
		
		level = 1;
		nextLevel("levels/level1");
		/*list.add(new Bricks(0,0));
		list.add(new Bricks(64,0));
		list.add(new Bricks(128,0));
		list.add(new Bricks(456, 0));
		list.add(new Bricks(520,200));
		list.add(new Bricks(584, 200));
		list.add(new Bricks(148, 200));
		list.add(new Obstacle(648, 200));*/




		
	}


	public void handleInput() {
		boolean shiftHeld = false;
		if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT)) {
			shiftHeld = true;
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			Gdx.app.exit();		// quit the game
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		handleInput();
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
		boolean nextStage = false;
		for (GameObject t : list) {
			switch (player1.hits(t.getHitBox())) {
			case 1:
				switch(t.hitAction(1)) {
				case 1:
					player1.action(1, 0, t.getHitBox().y + t.getHitBox().height);
					break;
				case 2:
					player1.setPosition(0, 500);
					break;
				case 3:
					pDelete.add(t);
					break;
				case 4:
					level++;
					nextStage = true;
					break;
				}
				break;
			case 2:
				switch(t.hitAction(2)) {
				case 1:
					player1.action(2, t.getHitBox().x + t.getHitBox().width+1, 0);
					break;
				case 2:
					player1.setPosition(0, 500);
					break;
				case 3:
					pDelete.add(t);
					break;
				case 4:
					level++;
					nextStage = true;
					break;
				}
				break;
			case 3:
				switch(t.hitAction(3)) {
				case 1:
					player1.action(3, t.getHitBox().x - player1.getHitBox().width - 1,0);
					break;
				case 2:
					player1.setPosition(0, 500);
					break;
				case 3:
					pDelete.add(t);
					break;
				case 4:
					level++;
					nextStage = true;
					break;
				}
				break;
			case 4:
				switch(t.hitAction(4)) {
				case 1:
				player1.action(4, 0, t.getHitBox().y - player1.getHitBox().height);
				case 2:
					player1.setPosition(0, 500);
					break;
				case 3:
					pDelete.add(t);
					break;
				case 4:
					level++;
					nextStage = true;
					break;
				}
				break;
			}
		}

		

		while (!pDelete.isEmpty()) {
			list.remove(pDelete.get(0));
			pDelete.remove(0);
		}
		if (nextStage) {
			player1.setPosition(0, 500);
			nextLevel("level" + level);
		}
		updateCamera();

		// Controls
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player1.moveLeft(Gdx.graphics.getDeltaTime());
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player1.moveRight(Gdx.graphics.getDeltaTime());
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			player1.jump();
		}   
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public void updateCamera() {
		cam.position.x = player1.getHitBox().x;
		cam.update();
	}

	public void nextLevel(String level) {
		list.clear();
		FileHandle file = Gdx.files.internal(level);
		StringTokenizer tokens = new StringTokenizer(file.readString());
		while (tokens.hasMoreTokens()) {
			String type = tokens.nextToken();
			if (type.equals("sand")) {
				list.add(new Bricks(
					Integer.parseInt(tokens.nextToken()), 
					Integer.parseInt(tokens.nextToken())));
			} else if (type.equals("Obstacle")) {
				list.add(new Obstacle(
					Integer.parseInt(tokens.nextToken()), 
					Integer.parseInt(tokens.nextToken())));
			} else if (type.equals("Sun")) {
				list.add(new Suns(
					Integer.parseInt(tokens.nextToken()), 
					Integer.parseInt(tokens.nextToken())));
			} else if (type.equals("castle")) {
				list.add(new Castle(
					Integer.parseInt(tokens.nextToken()), 
					Integer.parseInt(tokens.nextToken())));
			}
		}
	}
}
