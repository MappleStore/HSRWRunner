import processing.core.PApplet;
import processing.core.PImage;

public class HsrwRunner extends PApplet {
	// :) Marwin hier
	String imagePath = "\\";
	PImage backgroundImg;
	PImage playerImg;

	int delay = 0;
	int backgroundX = 0;
	float playerY = 0;

	public void setup() {
		size(720, 480, P3D);
		backgroundImg = loadImage(imagePath + "hsrw.png");
		playerImg = loadImage(imagePath + "player.png");
		textureMode(NORMAL);
	}

	public void draw() {
		background(255);
		frameRate(30);
		// Hintergrundbild zeichnen
		drawEndlessBackground();
		drawPlayer();

	}

	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == RIGHT) {
				// Bewegung Hintergrundbild
				backgroundX = backgroundX - 1;
				delay++;
			}

			if (keyCode == LEFT) {
				// Bewegung Hintergrundbild
				backgroundX = backgroundX + 1;
				delay++;
			}

			if (keyCode == UP) {
				frameRate(1);
				playerY -= 30;
				drawPlayer();
				playerY = 0;
				drawPlayer();
			}
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
		noStroke();
		beginShape(QUADS);
		texture(playerImg);
		vertex(0 + x, playerY + y, 2, 0, 0);
		vertex(32 + x, playerY + y, 2, 1, 0);
		vertex(32 + x, playerY + 60 + y, 2, 1, 1);
		vertex(0 + x, playerY + 60 + y, 2, 0, 1);
		endShape();

		if (delay >= 10) {
			delay = 0;
		}

		if (delay < 5) {
			playerImg = loadImage(imagePath + "player.png");
		} else {
			playerImg = loadImage(imagePath + "player_walking.png");
		}
	}

}
