import processing.core.PImage;

public class Background {
	Game g;
	PImage backgroundImage;
	public int x;
	public int y;

	public Background() {
		// default
	}

	public Background(Game g, String path) {
		this.g = g;
		this.backgroundImage = this.g.parent.loadImage(path);
	}

	public void moveBackground(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}

	public void drawBackground() {
		this.g.parent.noStroke();
		
		this.g.parent.beginShape(this.g.parent.QUADS);
		this.g.parent.texture(this.backgroundImage);
		this.g.parent.vertex(this.x, this.y + 0, 1, 0, 0);
		this.g.parent.vertex(this.x + g.WINDOW_WIDTH, this.y + 0, 1, 1, 0);
		this.g.parent.vertex(this.x + g.WINDOW_WIDTH, this.y + g.WINDOW_HEIGHT, 1, 1, 1);
		this.g.parent.vertex(this.x, this.y + g.WINDOW_HEIGHT, 1, 0, 1);
		this.g.parent.endShape();

		// Endloser Hintergrund 
		this.g.parent.beginShape(this.g.parent.QUADS);
		this.g.parent.texture(this.backgroundImage);
		this.g.parent.vertex(this.x + g.WINDOW_WIDTH, this.y + 0, 1, 0, 0);
		this.g.parent.vertex(this.x + g.WINDOW_WIDTH * 2, this.y + 0, 1, 1, 0);
		this.g.parent.vertex(this.x + g.WINDOW_WIDTH * 2, this.y + g.WINDOW_HEIGHT, 1, 1, 1);
		this.g.parent.vertex(this.x + g.WINDOW_WIDTH, this.y + g.WINDOW_HEIGHT, 1, 0, 1);
		this.g.parent.endShape();

		if (this.x < g.WINDOW_WIDTH * (-1)) {
			this.x = 0;
		}
		// ...
	}
}
