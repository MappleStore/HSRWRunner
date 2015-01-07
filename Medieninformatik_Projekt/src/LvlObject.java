import processing.core.PImage;

public class LvlObject {
	Game game;
	int height;
	int width;
	int y;
	int x;
	int z;
	boolean visible;
	boolean collided;

	Mission mission;
	PImage texture;

	public LvlObject(Game game, String texturePath, int height, int width,
			int x, int y, int z) {
		this.game = game;
		this.texture = this.game.app.loadImage(texturePath);
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		this.z = z;
		this.visible = true;
	}
	
	public LvlObject(Game game, String texturePath, int height, int width,
			int x, int y, int z, Mission mission) {
		this(game, texturePath, height, width, x, y, z);
		this.mission = mission;
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
}
