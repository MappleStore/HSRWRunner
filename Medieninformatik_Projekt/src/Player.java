import processing.core.PApplet;
import processing.core.PImage;

public class Player extends PApplet {
	Game game;

	final int JUMP_HEIGHT = 60;
	final int SPEED = 2;
	final int MIN_X = 0; // Minimal X-Koordinate beim Laufen
	final int MAX_X = 340; // Maximal X-Koordinate beim Laufen
	final int PLAYER_HEIGHT = 60;
	final int PLAYER_WIDTH = 42;

	// Zustände:
	// vorwärts-blockiert, rückwärts-blockiert, kollision, stehen, rückwärts, mission
	boolean[] states = new boolean[6];

	// Koordinaten und weitere Zustände
	int y;
	int x;
	int delay = 0;
	boolean isJumped = false;
	int jumpedY = 0;
	PImage playerImage;

	public Player() {

	}

	public Player(Game game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.states[3] = true; // Idle
	}

	public void movePlayer(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}

	public void drawPlayer() {
		// Spielfigurbildwechsel verzögern
		if (this.delay >= 10) {
			this.delay = 0;
		}

		// Spielfigurbild zeichnen:
		// Stehen
		if (this.states[3] && this.isJumped == false) {
			this.playerImage = this.game.app.loadImage(game.DEFAULT_IMAGEPATH
					+ "hero_idle.png");
		}

		// Springen
		if (this.isJumped && this.states[3]) {
			this.playerImage = this.game.app.loadImage(game.DEFAULT_IMAGEPATH
					+ "hero_jump.png");
		} else if (this.isJumped == false && this.states[3] == false) {
			// Laufen
			if (this.delay < 5) {
				this.playerImage = this.game.app
						.loadImage(game.DEFAULT_IMAGEPATH + "hero_run1.png");
			} else {
				this.playerImage = this.game.app
						.loadImage(game.DEFAULT_IMAGEPATH + "hero_run2.png");
			}
		}

		// Vorwärts
		if (this.states[4] == false) {
			this.game.app.noStroke();
			this.game.app.beginShape(this.game.app.QUADS);
			this.game.app.texture(playerImage);
			this.game.app.vertex(this.x, this.y - this.PLAYER_HEIGHT, 2, 0, 0);
			this.game.app.vertex(this.x + this.PLAYER_WIDTH, this.y
					- this.PLAYER_HEIGHT, 2, 1, 0);
			this.game.app.vertex(this.x + this.PLAYER_WIDTH, this.y, 2, 1, 1);
			this.game.app.vertex(this.x, this.y, 2, 0, 1);
			this.game.app.endShape();
		} else { // Rückwärts (gespiegelt)
			this.game.app.noStroke();
			this.game.app.beginShape(this.game.app.QUADS);
			this.game.app.texture(playerImage);
			this.game.app.vertex(this.x, this.y - this.PLAYER_HEIGHT, 2, 1, 0);
			this.game.app.vertex(this.x + this.PLAYER_WIDTH, this.y
					- this.PLAYER_HEIGHT, 2, 0, 0);
			this.game.app.vertex(this.x + this.PLAYER_WIDTH, this.y, 2, 0, 1);
			this.game.app.vertex(this.x, this.y, 2, 1, 1);
			this.game.app.endShape();
		}
	}
}
