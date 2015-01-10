import java.util.ArrayList;
import java.util.Random;

import processing.core.PImage;

public class LvlObject {
	Game game;
	int height;
	int width;
	int y;
	int x;
	int z;
	boolean goThrough;
	boolean collided;
	Random random = new Random();

	ArrayList<Mission> missions;
	Mission mission;
	PImage texture;

	// Ohne Mission
	public LvlObject(Game game, String texturePath, int height, int width,
			int x, int y, int z, boolean goThrough) {
		this.game = game;
		this.texture = this.game.app.loadImage(texturePath);
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		this.z = z;
		this.goThrough = goThrough;
	}
	
	// Mit Mission
	public LvlObject(Game game, String texturePath, int height, int width,
			int x, int y, int z, boolean goThrough, ArrayList<Mission> missionen) {
		this(game, texturePath, height, width, x, y, z, goThrough);
		this.missions = missionen;
		
	}

	public void draw() {
		this.game.app.noStroke();

		this.game.app.beginShape(this.game.app.QUADS);
		this.game.app.texture(this.texture);
		this.game.app.vertex(this.x, this.y - this.height, this.z, 0, 0);
		this.game.app.vertex(this.x + this.width, this.y - this.height, this.z,
				1, 0);
		this.game.app.vertex(this.x + this.width, this.y, this.z, 1, 1);
		this.game.app.vertex(this.x, this.y, this.z, 0, 1);
		this.game.app.endShape();
	}
	
	public void move(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}
	
	public void selectMission() {
		if (this.missions != null) {	
			while(this.mission == null) {
				Mission tmp = this.missions.get(random.nextInt(this.missions.size()));
				if (tmp.isMatched == false) {
					this.mission = tmp;
					this.mission.isMatched = true;
				}
			}
		}
	}
}
