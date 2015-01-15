import processing.core.PConstants;
import processing.core.PImage;

public class Player {
	Game game;

	final int JUMP_HEIGHT = 60;
	final int SPEED = 4;
	final int MIN_X = 0; // Minimal X-Koordinate beim Laufen
	final int MAX_X = 340; // Maximal X-Koordinate beim Laufen
	final int PLAYER_HEIGHT = 60;
	final int PLAYER_WIDTH = 42;
	String name;

	// Bilder
	PImage idleImage;
	PImage run1Image;
	PImage run2Image;
	PImage jumpImage;

	// Zustände:
	// vorwärts-blockiert, rückwärts-blockiert, kollision, stehen, rückwärts
	boolean[] states = new boolean[5];

	// Koordinaten und weitere Zustände
	int y;
	int x;
	int delay = 0;
	boolean isJumped = false;
	int jumpedY = 0;
	PImage playerImage;
	int missionCounter = 0;

	public Player() {

	}

	public Player(Game game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.states[3] = true; // Idle

		// Bilder laden
		this.idleImage = this.game.app.loadImage(game.DEFAULT_IMAGEPATH
				+ "hero_idle.png");
		this.run1Image = this.game.app.loadImage(game.DEFAULT_IMAGEPATH
				+ "hero_run1.png");
		this.run2Image = this.game.app.loadImage(game.DEFAULT_IMAGEPATH
				+ "hero_run2.png");
		this.jumpImage = this.game.app.loadImage(game.DEFAULT_IMAGEPATH
				+ "hero_jump.png");
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
			this.playerImage = this.idleImage;
		}

		// Springen
		if (this.isJumped && this.states[3]) {
			this.playerImage = this.jumpImage;
		} else if (this.isJumped == false && this.states[3] == false) {
			// Laufen
			if (this.delay < 5) {
				this.playerImage = this.run1Image;
			} else {
				this.playerImage = this.run2Image;
			}
		}

		// In Mission
		if (this.game.hsrwLvl.inMission) {
			this.playerImage = this.idleImage;
		}

		// Vorwärts
		if (this.states[4] == false) {
			this.game.app.noStroke();
			this.game.app.beginShape(PConstants.QUADS);
			this.game.app.texture(playerImage);
			this.game.app.vertex(this.x, this.y - this.PLAYER_HEIGHT, 9, 0, 0);
			this.game.app.vertex(this.x + this.PLAYER_WIDTH, this.y
					- this.PLAYER_HEIGHT, 9, 1, 0);
			this.game.app.vertex(this.x + this.PLAYER_WIDTH, this.y, 9, 1, 1);
			this.game.app.vertex(this.x, this.y, 9, 0, 1);
			this.game.app.endShape();
		} else { // Rückwärts (gespiegelt)
			this.game.app.noStroke();
			this.game.app.beginShape(PConstants.QUADS);
			this.game.app.texture(playerImage);
			this.game.app.vertex(this.x, this.y - this.PLAYER_HEIGHT, 9, 1, 0);
			this.game.app.vertex(this.x + this.PLAYER_WIDTH, this.y
					- this.PLAYER_HEIGHT, 9, 0, 0);
			this.game.app.vertex(this.x + this.PLAYER_WIDTH, this.y, 9, 0, 1);
			this.game.app.vertex(this.x, this.y, 9, 1, 1);
			this.game.app.endShape();
		}
	}
}
