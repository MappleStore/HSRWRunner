import processing.core.PApplet;
import processing.core.PImage;

public class HsrwRunner extends PApplet {
	// Hallo
	String imagePath = "\\";
	PImage backgroundImg;
	PImage playerImg;

	boolean[] keys;
	int delay = 0;
	int backgroundX = 0;
	float playerY = 0;
	boolean jumped = false;

	public void setup() {
		size(720, 480, P3D);
		keys = new boolean[4];
		backgroundImg = loadImage(imagePath + "hsrw.png");
		playerImg = loadImage(imagePath + "player.png");
		textureMode(NORMAL);
	}

	public void draw() {
		background(255);
		frameRate(60);
		// Hintergrundbild zeichnen
		drawEndlessBackground();

		if (keys[0]) {
			// Bewegung Hintergrundbild
			backgroundX = backgroundX - 2;
			delay++;
		}

		if (keys[1]) {
			// Bewegung Hintergrundbild
			backgroundX = backgroundX + 2;
			delay++;
		}

		if (keys[2]) {
			// jump only if player at the ground
			if (playerY == 0) {
				jumped = true;
			}
		}

		drawPlayer();

	}

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

	public void drawEndlessBackground() {
		noStroke();

		beginShape(QUADS);
		texture(backgroundImg);
		vertex(backgroundX, 0, 1, 0, 0);
		vertex(backgroundX + 720, 0, 1, 1, 0);
		vertex(backgroundX + 720, 480, 1, 1, 1);
		vertex(backgroundX, 480, 1, 0, 1);
		endShape();

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
	}

	public void drawPlayer() {
		int x = 80;
		int y = 380;

		// Set X Y:

		// Slow down Image-Change
		if (delay >= 10) {
			delay = 0;
		}

		// Player Jumped?
		if (jumped) {
			// Increase height to 30px
			if (playerY > -40) {
				playerY -= 4;
			}

			// Jump at heighest point
			if (playerY <= -40) {
				jumped = false;
			}
		} else if (playerY < 0) {
			// Fall down
			playerY += 4;
		}

		// Draw Image
		noStroke();
		beginShape(QUADS);
		texture(playerImg);
		vertex(0 + x, playerY + y, 2, 0, 0);
		vertex(32 + x, playerY + y, 2, 1, 0);
		vertex(32 + x, playerY + 60 + y, 2, 1, 1);
		vertex(0 + x, playerY + 60 + y, 2, 0, 1);
		endShape();

		if (delay < 5) {
			playerImg = loadImage(imagePath + "player.png");
		} else {
			playerImg = loadImage(imagePath + "player_walking.png");
		}

	}

}
