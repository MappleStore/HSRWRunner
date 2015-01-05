import processing.core.PImage;

public class Background {
	Game game;
	PImage backgroundImage;
	public int x;
	public int y;

	public Background() {
		// default
	}

	public Background(Game game, String path) {
		this.game = game;
		this.backgroundImage = this.game.app.loadImage(path);
	}

	public void moveBackground(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}

	public void drawBackground() {
		this.game.app.noStroke();
		
		this.game.app.beginShape(this.game.app.QUADS);
		this.game.app.texture(this.backgroundImage);
		this.game.app.vertex(this.x, this.y + 0, 1, 0, 0);
		this.game.app.vertex(this.x + game.WINDOW_WIDTH, this.y + 0, 1, 1, 0);
		this.game.app.vertex(this.x + game.WINDOW_WIDTH, this.y + game.WINDOW_HEIGHT, 1, 1, 1);
		this.game.app.vertex(this.x, this.y + game.WINDOW_HEIGHT, 1, 0, 1);
		this.game.app.endShape();

		// Endloser Hintergrund 
		this.game.app.beginShape(this.game.app.QUADS);
		this.game.app.texture(this.backgroundImage);
		this.game.app.vertex(this.x + game.WINDOW_WIDTH, this.y + 0, 1, 0, 0);
		this.game.app.vertex(this.x + game.WINDOW_WIDTH * 2, this.y + 0, 1, 1, 0);
		this.game.app.vertex(this.x + game.WINDOW_WIDTH * 2, this.y + game.WINDOW_HEIGHT, 1, 1, 1);
		this.game.app.vertex(this.x + game.WINDOW_WIDTH, this.y + game.WINDOW_HEIGHT, 1, 0, 1);
		this.game.app.endShape();

		if (this.x < game.WINDOW_WIDTH * (-1)) {
			this.x = 0;
		}
		// ...
	}
}