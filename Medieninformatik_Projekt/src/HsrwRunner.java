import processing.core.PApplet;
import processing.core.PImage;

public class HsrwRunner extends PApplet {
	Game game = null;

	public void setup() {
		this.game = new Game(this);
		size(game.WINDOW_WIDTH, game.WINDOW_HEIGHT, P3D);
		textureMode(NORMAL);

		this.game.loadLevel();
	}

	public void draw() {
		frameRate(60);
		background(255);
		this.game.hsrwLvl.drawLevel();

	}

	public void keyPressed() {
		this.game.keyPressed();
	}

	public void keyReleased() {
		this.game.keyReleased();
	}
	
	public void mouseClicked() {
		//this.game.app.loop();
	}
}
