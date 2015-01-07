import java.util.ArrayList;
import processing.core.PImage;

public class Mission {
	Game game;
	boolean isPlayed;
	PImage missionImage;
	int height;
	int width;
	int y;
	int x;
	int z;
	String missionText;
	String questionText;
	ArrayList<String> answers;
	int answerIndex;
	final int CREDITPOINTS = 5;
	final int FONTSIZE = 16;
	public int rightAnswer;

	public Mission(Game game, String texturePath, int height,
			int width, int x, int y, int z, String missionText,
			String questionText, ArrayList<String> answers, int answerIndex,
			int rightAnswer) {
		this.game = game;
		this.isPlayed = false;
		this.missionImage = this.game.app.loadImage(game.DEFAULT_IMAGEPATH
				+ texturePath);

		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		this.z = z;
		this.missionText = missionText;
		this.questionText = questionText;
		this.answers = answers;
		this.answerIndex = answerIndex;
		this.rightAnswer = rightAnswer;
	}

	public void drawMission() {
		this.game.app.noStroke();
		this.game.app.beginShape(this.game.app.QUADS);
		this.game.app.texture(this.missionImage);
		this.game.app.vertex(this.x, this.y, this.z, 0, 0);
		this.game.app.vertex(this.x + this.width, this.y, this.z, 1, 0);
		this.game.app.vertex(this.x + this.width, this.y + this.height, this.z,
				1, 1);
		this.game.app.vertex(this.x, this.y + this.height, this.z, 0, 1);
		this.game.app.endShape();
		this.game.app.textSize(this.FONTSIZE);
		this.game.app.fill(0, 0, 0);

		int pixelRow = (int) (this.FONTSIZE * 1.2);
		this.game.app.text(this.missionText, this.x + 10, this.y + pixelRow,
				this.z);
		pixelRow += this.FONTSIZE * 1.2;
		this.game.app.text(this.questionText, this.x + 10, this.y + pixelRow,
				this.z);
		pixelRow += this.FONTSIZE * 1.2;

		for (String answer : this.answers) {
			this.game.app.text(answer, this.x + 10, this.y + pixelRow, this.z);
			pixelRow += this.FONTSIZE * 1.2;
		}

	}

}
