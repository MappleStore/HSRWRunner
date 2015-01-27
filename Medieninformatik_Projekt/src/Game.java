import ddf.minim.*;
import processing.core.PApplet;
import processing.core.PConstants;

public class Game {
	PApplet app = null;
	final String DEFAULT_IMAGEPATH = HsrwRunner.class.getResource("/media/images/")
			.toString();
	final String DEFAULT_SOUNDPATH = HsrwRunner.class.getResource("/media/sounds/")
			.toString();
	final int GRAVITY = 6;
	final int WINDOW_HEIGHT = 480;
	final int WINDOW_WIDTH = 720;
	final int GROUND_LEVEL = 434;
	public int sumCreditPoints = 0;

	Level hsrwLvl = null;
	boolean[] keyboard; // Tasten-Array

	// Spiel starten
	public Game(PApplet parentApplet) {
		// Rechts, Links, Oben, Unten, 1, 2, 3, 4, Enter, m
		this.keyboard = new boolean[10];
		this.app = parentApplet;
	}

	// Level laden
	public void loadLevel() {
		this.hsrwLvl = new Level(this);
	}

	// Level restart
	public void reloadLevel() {
		sumCreditPoints = 0;
		this.hsrwLvl.playerLevelTheme.close();
		this.hsrwLvl = new Level(this);
	}

	// Gedrückte Tasten in Array setzen
	public void keyPressed() {
		if (this.app.keyCode == PConstants.RIGHT) {
			this.keyboard[0] = true;
		}
		if (this.app.keyCode == PConstants.LEFT) {
			this.keyboard[1] = true;
		}
		if (this.app.keyCode == PConstants.UP) {
			this.keyboard[2] = true;
		}
		if (this.app.keyCode == PConstants.DOWN) {
			this.keyboard[3] = true;
		}
		if (this.app.keyCode == 49) {
			this.keyboard[4] = true;
		}
		if (this.app.keyCode == 50) {
			this.keyboard[5] = true;
		}
		if (this.app.keyCode == 51) {
			this.keyboard[6] = true;
		}
		if (this.app.keyCode == 52) {
			this.keyboard[7] = true;
		}
		if (this.app.keyCode == PConstants.ENTER
				|| this.app.keyCode == PConstants.RETURN) {
			this.keyboard[8] = true;
		}
		if (this.app.keyCode == 77 || this.app.keyCode == 109) {
			this.keyboard[9] = true;
		}
	}

	// Nicht mehr gedrückte Tasten in Array setzen
	public void keyReleased() {
		if (this.app.keyCode == PConstants.RIGHT) {
			this.keyboard[0] = false;
		}
		if (this.app.keyCode == PConstants.LEFT) {
			this.keyboard[1] = false;
		}
		if (this.app.keyCode == PConstants.UP) {
			this.keyboard[2] = false;
		}
		if (this.app.keyCode == PConstants.DOWN) {
			this.keyboard[3] = false;
		}
		if (this.app.keyCode == 49) {
			this.keyboard[4] = false;
		}
		if (this.app.keyCode == 50) {
			this.keyboard[5] = false;
		}
		if (this.app.keyCode == 51) {
			this.keyboard[6] = false;
		}
		if (this.app.keyCode == 52) {
			this.keyboard[7] = false;
		}
		if (this.app.keyCode == PConstants.ENTER
				|| this.app.keyCode == PConstants.RETURN) {
			this.keyboard[8] = false;
		}
		if (this.app.keyCode == 77 || this.app.keyCode == 109) {
			this.keyboard[9] = false;
		}
	}

}
