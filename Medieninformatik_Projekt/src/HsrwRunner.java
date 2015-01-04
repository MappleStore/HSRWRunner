import processing.core.PApplet;
import processing.core.PImage;

public class HsrwRunner extends PApplet {
	Game hsrwRunner = null;

	public void setup() {	
		hsrwRunner = new Game(this);
		size(hsrwRunner.WINDOW_WIDTH, hsrwRunner.WINDOW_HEIGHT, P3D);
		textureMode(NORMAL);
		
		hsrwRunner.loadLevel();
	}

	public void draw() {
		frameRate(60);
		background(255);
		hsrwRunner.level1.drawLevel();
	}
	
	public void keyPressed() {
		hsrwRunner.keyPressed();
	}

	public void keyReleased() {
		hsrwRunner.keyReleased();
	}
}
