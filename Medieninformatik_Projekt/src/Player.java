import processing.core.PApplet;
import processing.core.PImage;

public class Player extends PApplet {
	Game g;

	final int JUMP_HEIGHT = 40;
	final int MIN_X = 80; // Minimal X-Koordinate beim Laufen
	final int MAX_X = 340; // Maximal X-Koordinate beim Laufen
	final int PLAYER_HEIGHT = 60;
	final int PLAYER_WIDTH = 32;

	// Koordinaten und Zustände
	int y;
	int x;
	int delay = 0;
	boolean isJumped = false;
	PImage playerImage;

	public Player() {

	}

	public Player(Game g, int x, int y) {
		this.g = g;
		this.x = x;
		this.y = y;
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

		// Springt der Spieler?
		if (this.isJumped) {
			// erhöhe die Spielfigur bei jedem draw()
			if ((this.y + this.PLAYER_HEIGHT + this.JUMP_HEIGHT) > g.GROUND_LEVEL) {
				this.y -= g.GRAVITY;
			}

			// am höchsten Punkt?
			if (this.y + this.PLAYER_HEIGHT + this.JUMP_HEIGHT <= g.GROUND_LEVEL) {
				isJumped = false; // Sprung beenden
			}
		} else if ((this.y + this.PLAYER_HEIGHT) < g.GROUND_LEVEL) {
			// Spielfigur wieder absenken bei jedem draw()
			this.y += g.GRAVITY;
		}

		// Spielfigurbild zeichnen

		if (this.delay < 5) {
			this.playerImage = this.g.parent.loadImage(g.DEFAULT_IMAGEPATH + "player.png");
		} else {
			this.playerImage = this.g.parent.loadImage(g.DEFAULT_IMAGEPATH + "player_walking.png");
		}

		this.g.parent.noStroke();
		this.g.parent.beginShape(this.g.parent.QUADS);
		this.g.parent.texture(playerImage);
		this.g.parent.vertex(this.x, this.y, 2, 0, 0);
		this.g.parent.vertex(this.x + this.PLAYER_WIDTH, this.y, 2, 1, 0);
		this.g.parent.vertex(this.x + this.PLAYER_WIDTH, this.y
				+ this.PLAYER_HEIGHT, 2, 1, 1);
		this.g.parent.vertex(this.x, this.y + this.PLAYER_HEIGHT, 2, 0, 1);

		this.g.parent.endShape();
	}
}
