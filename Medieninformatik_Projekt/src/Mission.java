import java.util.ArrayList;

import processing.core.PImage;

public class Mission {
	Game game;
	boolean isPlayed;
	boolean isCompleted;
	boolean isSolved;
	boolean isMatched;
	PImage missionImage;
	int height;
	int width;
	int y;
	int x;
	int z;
	String missionText;
	String questionText;
	ArrayList<String> answers;
	ArrayList<Integer> answerKey;
	String solvedText;
	String notSolvedText;

	final int CREDITPOINTS = 5;
	final int FONTSIZE = 14;

	public Mission(Game game, String texturePath, int height, int width, int x,
			int y, int z, String missionText, String questionText,
			String solvedText, String notSolvedText, ArrayList<String> answers,
			ArrayList<Integer> answerKey) {
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
		this.answerKey = answerKey;
		this.solvedText = solvedText;
		this.notSolvedText = notSolvedText;
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
		
		String tmpOutputText = "";
		if (this.isCompleted == false) {
			tmpOutputText = this.missionText + "\n\n" + this.questionText;


			for (String answer : this.answers) {
				tmpOutputText = tmpOutputText + "\n" + answer;
			}
		} else if (this.isSolved) {			
			tmpOutputText = this.solvedText;
		} else if (this.isSolved == false) {
			tmpOutputText = this.notSolvedText;
		}
		
		this.game.app.text(tmpOutputText, this.x + 15,
				this.y + 25, this.z);
	}

	public void checkMission() {
		// Funktion für in Mission check welche Taste gedrückt wurde, bei
		// richtiger Antwort creditpoints addieren
		if (this.game.hsrwLvl.inMission && this.isCompleted == false) {
			if (this.game.keyboard[4] ^ this.game.keyboard[5]
					^ this.game.keyboard[6] ^ this.game.keyboard[7]) {
				
				// Mehrere richtige Antworten möglich
				for (Integer key : this.answerKey) {
					if (this.game.keyboard[4] && key == 1) {
						this.game.sumCreditPoints += this.CREDITPOINTS;
						this.isSolved = true;
					} else if (this.game.keyboard[5] && key == 2) {
						this.game.sumCreditPoints += this.CREDITPOINTS;
						this.isSolved = true;
					} else if (this.game.keyboard[6] && key == 3) {
						this.game.sumCreditPoints += this.CREDITPOINTS;
						this.isSolved = true;
					} else if (this.game.keyboard[7] && key == 4) {
						this.game.sumCreditPoints += this.CREDITPOINTS;
						this.isSolved = true;
					}
				}

				this.isCompleted = true;
			}

		} else if (this.isCompleted) {
			if (this.game.keyboard[0] || this.game.keyboard[1] || this.game.keyboard[2]) {
				this.isPlayed = true;
			}

		}
	}

}
