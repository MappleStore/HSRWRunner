import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Mission {
	Game game;
	int missionCounter;
	PImage missionImage;
	//this.missionImage = this.game.app.loadImage(game.DEFAULT_IMAGEPATH + "white.png");

	public Mission(Game game, int missionCounter) {
		this.game = game;
		this.missionCounter = missionCounter;
	}

	public void drawMission(int missionCounter) {
		
		switch (missionCounter) {
		case 1:
			this.missionImage = this.game.app.loadImage(game.DEFAULT_IMAGEPATH + "white.png");
			this.game.app.noStroke();
			this.game.app.beginShape(this.game.app.QUADS);
			this.game.app.texture(missionImage);
			this.game.app.vertex(100, 100, 2, 0, 0);
			this.game.app.vertex(400, 100, 2, 0, 1);
			this.game.app.vertex(400, 400, 2, 1, 0);
			this.game.app.vertex(100, 400, 2, 1, 1);
			this.game.app.endShape();
			this.game.app.textSize(20);
			this.game.app.fill(0,0,0);
			this.game.app.text("Hallo, meine Name ist Tim ...", 100, 120, 2);
			
			break;
		}
		this.game.app.noLoop();
		//this.game.app.loop();
	}

}
