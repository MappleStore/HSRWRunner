import java.util.ArrayList;

import processing.core.PConstants;
import processing.core.PImage;

public class Mission {
	Game game;
	boolean isPlayed;
	boolean isCompleted;
	boolean isSolved;
	boolean isMatched;
	boolean isDelayed;
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
	int creditPoints = 5;
	final int FONTSIZE = 14;

	public Mission(Game game, int creditPoints, String texturePath, int height,
			int width, int x, int y, int z, String missionText,
			String questionText, String solvedText, String notSolvedText,
			ArrayList<String> answers, ArrayList<Integer> answerKey) {
		this.game = game;
		this.creditPoints = creditPoints;
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
		this.game.app.beginShape(PConstants.QUADS);
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

		// Info-Missionen
		if (this.answerKey.size() == 0) {
			tmpOutputText = this.missionText;
		}

		// Ggf. Platzhalter ersetzen
		tmpOutputText = tmpOutputText.replace("#CP#", this.game.sumCreditPoints
				+ "");
		this.game.app.text(tmpOutputText, this.x + 15, this.y + 25, this.z);
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
						this.game.sumCreditPoints += this.creditPoints;
						this.isSolved = true;
					} else if (this.game.keyboard[5] && key == 2) {
						this.game.sumCreditPoints += this.creditPoints;
						this.isSolved = true;
					} else if (this.game.keyboard[6] && key == 3) {
						this.game.sumCreditPoints += this.creditPoints;
						this.isSolved = true;
					} else if (this.game.keyboard[7] && key == 4) {
						this.game.sumCreditPoints += this.creditPoints;
						this.isSolved = true;
					}
				}

				// Spiele CPs-Sound ab
				if (this.isSolved) {
					this.game.hsrwLvl.playerCreditPoints.rewind();
					this.game.hsrwLvl.playerCreditPoints.play();
				}

				this.isCompleted = true;
			} else if (this.answerKey.size() == 0) {
				this.isCompleted = true;
			}

		} else if (this.isCompleted) {
			// Delay für Info-Missionen
			if (this.isDelayed == false && this.answerKey.size() == 0) {
				this.game.hsrwLvl.delay = this.game.hsrwLvl.delayTime;
				this.game.keyboard = new boolean[this.game.keyboard.length];
				this.isDelayed = true;
			}

			if ((this.game.keyboard[0] || this.game.keyboard[1]
					|| this.game.keyboard[2] || this.game.keyboard[8])
					&& this.game.hsrwLvl.delay == 0) {

				this.isPlayed = true;

				// Letzte Mission? Neustarten ...
				if (this.game.hsrwLvl.lvlObjects
						.get(this.game.hsrwLvl.lvlObjects.size() - 1).mission
						.equals(this)) {
					this.game.reloadLevel();
				}
			}

		}
	}

}
