package lewis.edu.game;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class OdysseyGame extends ApplicationAdapter {
	private OrthographicCamera cam;
	private SpriteBatch batch;
	private Warriors player1;
	private ArrayList<GameObject> list = new ArrayList<GameObject>();
	private ArrayList<GameObject> pDelete = new ArrayList<GameObject>();
	private ArrayList<GameObject> firstBackground = new ArrayList<GameObject>();
	private ArrayList<GameObject> secBackground = new ArrayList<GameObject>();

	private int level = 1;
	private BitmapFont font;
	private float fontPos = 0;
	private int deaths = 0;

	@Override
	public void create () {

		TexManager.create();
		SoundMan.create();
		SoundMan.background.setLooping(true);
		SoundMan.background.setVolume(0.1f);
		SoundMan.background.play();

		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();

		player1 = new Warriors();
		player1.setPosition(200, 100);
		
		level = 1;
		nextLevel("levels/level1");


		font = new BitmapFont(Gdx.files.internal("fonts/scaryfont.fnt"),
			Gdx.files.internal("fonts/scaryfont.png"), false);
		
		deaths = -1;

		
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
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		handleInput();
		batch.setProjectionMatrix(cam.combined);

		batch.begin();
		for (GameObject t : secBackground) {
			t.draw(batch);
		}
		for (GameObject t : firstBackground) {
			t.draw(batch);
		}
		player1.draw(batch);
		for (GameObject t : list) {
			t.draw(batch);
		}
		font.draw(batch, "Deaths Count:" + deaths, fontPos, 450);
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
					deaths++;
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
					float distance = player1.getHitBox().getX() - (t.getHitBox().x + t.getHitBox().width+1);
					player1.action(2, t.getHitBox().x + t.getHitBox().width+1, 0);
					for (GameObject B : secBackground) {
						B.action(0, distance, 0);
					}
					break;
				case 2:
					player1.setPosition(0, 500);
					deaths++;
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
				float distance = player1.getHitBox().getX() - (t.getHitBox().x - player1.getHitBox().width-1);
					player1.action(3, t.getHitBox().x - player1.getHitBox().width - 1,0);
					for (GameObject B : secBackground) {
						B.action(0, distance, 0);
					}
					break;
				case 2:
					player1.setPosition(0, 500);
					deaths++;
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
					deaths++;
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

		//System.out.println(player1.getHitBox().x + ", " + player1.getHitBox().y);
		fontPos = player1.getHitBox().x - 300;
		updateCamera();

		// Controls
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player1.moveLeft(Gdx.graphics.getDeltaTime());
			for (GameObject t : secBackground) {
				t.moveLeft(Gdx.graphics.getDeltaTime());
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player1.moveRight(Gdx.graphics.getDeltaTime());
			for (GameObject t : secBackground) {
				t.moveRight(Gdx.graphics.getDeltaTime());
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			player1.jump();
		}   
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		TexManager.dispose();
		SoundMan.dispose();
	}

	public void updateCamera() {
		cam.position.x = player1.getHitBox().x;
		cam.update();
	}

	public void nextLevel(String level) {
		list.clear();
		firstBackground.clear();
		secBackground.clear();
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
			} else if (type.equals("lava")) {
				firstBackground.add(new Lava(
					Integer.parseInt(tokens.nextToken()), 
					Integer.parseInt(tokens.nextToken())));
			}
			else if (type.equals("volcano")) {
				secBackground.add(new Volcano(
					Integer.parseInt(tokens.nextToken()),
					Integer.parseInt(tokens.nextToken()),
					Integer.parseInt(tokens.nextToken())));
			}
		}
	}
}
