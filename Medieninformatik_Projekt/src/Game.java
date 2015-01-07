import processing.core.PApplet;

public class Game {
	PApplet app = null;
	final String DEFAULT_IMAGEPATH = "..\\media\\images\\";
	final int GRAVITY = 4;
	final int WINDOW_HEIGHT = 480;
	final int WINDOW_WIDTH = 720;
	final int GROUND_LEVEL = 428;
	public int sumCreditPoints = 0;

	Level hsrwLvl = null;
	boolean[] keyboard; // Tasten-Array

	// Spiel starten
	public Game(PApplet parentApplet) {
		// Rechts, Links, Oben, Unten
		this.keyboard = new boolean[8];
		this.app = parentApplet;
	}

	// Level laden
	public void loadLevel() {
		this.hsrwLvl = new Level(this);
	}

	// Gedrückte Tasten in Array setzen
	public void keyPressed() {
		if (this.app.key == this.app.CODED) {
			if (this.app.keyCode == this.app.RIGHT) {
				this.keyboard[0] = true;
			}
			if (this.app.keyCode == this.app.LEFT) {
				this.keyboard[1] = true;
			}
			if (this.app.keyCode == this.app.UP) {
				this.keyboard[2] = true;
			}
			if (this.app.keyCode == this.app.DOWN) {
				this.keyboard[3] = true;
			}
			if (this.app.keyCode == this.app.SHIFT) {
				this.keyboard[4] = true;
			}
			if (this.app.keyCode == this.app.CONTROL) {
				this.keyboard[5] = true;
			}
			if (this.app.keyCode == this.app.BACKSPACE) {
				this.keyboard[6] = true;
			}
			if (this.app.keyCode == this.app.ENTER) {
				this.keyboard[7] = true;
			}
		}
	}

	// Nicht mehr gedrückte Tasten in Array setzen
	public void keyReleased() {
		if (this.app.key == this.app.CODED) {
			if (this.app.keyCode == this.app.RIGHT) {
				this.keyboard[0] = false;
			}
			if (this.app.keyCode == this.app.LEFT) {
				this.keyboard[1] = false;
			}
			if (this.app.keyCode == this.app.UP) {
				this.keyboard[2] = false;
			}
			if (this.app.keyCode == this.app.DOWN) {
				this.keyboard[3] = false;
			}
			if (this.app.keyCode == this.app.SHIFT) {
				this.keyboard[4] = false;
			}
			if (this.app.keyCode == this.app.CONTROL) {
				this.keyboard[5] = false;
			}
			if (this.app.keyCode == 51) {
				this.keyboard[6] = true;
			}
			if (this.app.keyCode == 52) {
				this.keyboard[7] = true;
			}
		}
	}

}
