import processing.core.PApplet;
import processing.core.PImage;

public class HsrwRunner extends PApplet {
	String imagePath = "..\\..\\media\\images\\";
	PImage backgroundImg;
	PImage playerImg;

	boolean[] keys; // Tasten-Array
	int delay = 0; // Verzögerung für Spielfigur-Bildwechsel
	int backgroundX = 0; // Bewegungsvariable vom Hintergrund

	// Spielfigur Koordinaten und Zustände
	int playerY = 0;
	int playerX = 80;
	boolean jumped = false;
	final int minPixelsPlayer = 80; // Minimal X-Koordinate beim Laufen
	final int maxPixelsPlayer = 340; // Maximal X-Koordinate beim Laufen

	// Spiel vorbereiten
	public void setup() {
		size(720, 480, P3D);
		keys = new boolean[4];
		backgroundImg = loadImage(imagePath + "hsrw.png");
		textureMode(NORMAL);
	}

	public void draw() {
		background(255);
		frameRate(60);

		// Hintergrundbild zeichnen
		drawBackground();

		// Vorwärtsbewegung
		if (keys[0] && playerX == maxPixelsPlayer) {
			// Bewegung Hintergrundbild
			backgroundX = backgroundX - 2;
			delay++;
		} else if (keys[0] && playerX < maxPixelsPlayer) {
			// Bewegung Spieler statt Hintergrundbild
			playerX = playerX + 2;
			delay++;
		}

		// Rückwärtsbewegung
		if (keys[1] && playerX == minPixelsPlayer) {
			// Bewegung Hintergrundbild
			// backgroundX = backgroundX + 2; nicht mehr vorgesehen
			delay++;
		} else if (keys[1] && playerX > minPixelsPlayer) {
			// Bewegung Spieler statt Hintergrundbild
			playerX = playerX - 2;
			delay++;
		}

		// Springbewegung
		if (keys[2]) {
			// Nur springen wenn die Spielfigur auf dem "Boden" steht
			if (playerY == 0) {
				jumped = true;
			}
		}

		// Spielfigur zeichnen
		drawPlayer();
	}

	// Gedrückte Tasten in Array setzen
	public void keyPressed() {
		if (keyCode == RIGHT) {
			keys[0] = true;
		}
		if (keyCode == LEFT) {
			keys[1] = true;
		}
		if (keyCode == UP) {
			keys[2] = true;
		}
		if (keyCode == DOWN) {
			keys[3] = true;
		}
	}

	// Nicht mehr gedrückte Tasten in Array setzen
	public void keyReleased() {
		if (keyCode == RIGHT) {
			keys[0] = false;
		}
		if (keyCode == LEFT) {
			keys[1] = false;
		}
		if (keyCode == UP) {
			keys[2] = false;
		}
		if (keyCode == DOWN) {
			keys[3] = false;
		}
	}

	public void drawBackground() {
		noStroke();

		beginShape(QUADS);
		texture(backgroundImg);
		vertex(backgroundX, 0, 1, 0, 0);
		vertex(backgroundX + 720, 0, 1, 1, 0);
		vertex(backgroundX + 720, 480, 1, 1, 1);
		vertex(backgroundX, 480, 1, 0, 1);
		endShape();

		// Endloser Hintergrund nach Leveldesign überflüssig 
		beginShape(QUADS);
		texture(backgroundImg);
		vertex(backgroundX + 720, 0, 1, 0, 0);
		vertex(backgroundX + 1440, 0, 1, 1, 0);
		vertex(backgroundX + 1440, 480, 1, 1, 1);
		vertex(backgroundX + 720, 480, 1, 0, 1);
		endShape();

		if (backgroundX < -720) {
			backgroundX = 0;
		}
		// ...
	}

	public void drawPlayer() {
		int x = playerX;
		int y = 380;

		// Spielfigurbildwechsel verzögern
		if (delay >= 10) {
			delay = 0;
		}

		// Springt der Spieler?
		if (jumped) {
			// erhöhe die Spielfigur bei jedem draw()
			if (playerY > -40) {
				playerY -= 4;
			}

			// am höchsten Punkt?
			if (playerY <= -40) {
				jumped = false; // Sprung beenden
			}
		} else if (playerY < 0) {
			// Spielfigur wieder absenken bei jedem draw()
			playerY += 4;
		}

		// Spielfigurbild zeichnen
		noStroke();
		beginShape(QUADS);
		texture(playerImg);
		vertex(0 + x, playerY + y, 2, 0, 0);
		vertex(32 + x, playerY + y, 2, 1, 0);
		vertex(32 + x, playerY + 60 + y, 2, 1, 1);
		vertex(0 + x, playerY + 60 + y, 2, 0, 1);
		endShape();

		// Verzögerung anwenden
		if (delay < 5) {
			playerImg = loadImage(imagePath + "player.png");
		} else {
			playerImg = loadImage(imagePath + "player_walking.png");
		}

	}

}
