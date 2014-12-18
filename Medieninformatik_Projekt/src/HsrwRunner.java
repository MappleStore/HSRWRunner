import processing.core.PApplet;
import processing.core.PImage;

public class HsrwRunner extends PApplet {
	// :)
	String folderPath = "C:\\Users\\Marwin\\SkyDrive\\HSRW\\Strukturierte und Objektorientierte Programmierung\\Workspace\\Medieninformatik_Projekt\\src\\";
	PImage backgroundImg;
	PImage playerImg;

	int delay = 0;
	int backgroundX = 0;

	public void setup() {
		size(720, 480, P3D);
		backgroundImg = loadImage(folderPath + "hsrw.png");
		playerImg = loadImage(folderPath + "player.png");
		textureMode(NORMAL);
	}

	public void draw() {
		background(255);

		// Hintergrundbild zeichnen
		drawEndlessBackground();
		drawPlayer();

	}

	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == RIGHT) {
				// Bewegung Hintergrundbild
				backgroundX = backgroundX - 1;
			}
			
			if (keyCode == LEFT) {
				// Bewegung Hintergrundbild
				backgroundX = backgroundX + 1;
			}
			
			delay++;
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
		vertex(0 + x, 0 + y, 2, 0, 0);
		vertex(32 + x, 0 + y, 2, 1, 0);
		vertex(32 + x, 60 + y, 2, 1, 1);
		vertex(0 + x, 60 + y, 2, 0, 1);
		endShape();

		if (delay >= 10) {
			delay = 0;
		}

		if (delay < 5) {
			playerImg = loadImage(folderPath + "player.png");
		} else {
			playerImg = loadImage(folderPath + "player_walking.png");
		}
	}

}
