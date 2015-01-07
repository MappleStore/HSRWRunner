import java.util.ArrayList;

public class Level {
	Game game;
	Player hero;
	Collision collision;
	ArrayList<LvlObject> lvlObjects = new ArrayList<LvlObject>();
	Background levelBackground;
	public int creditpoints;
	public double time;
	public boolean inMission;
	Mission tmpMission;

	public Level() {
		// default
	}

	// Level starten
	public Level(Game game) {
		this.game = game;
		this.levelBackground = new Background(game, game.DEFAULT_IMAGEPATH
				+ "hsrw.png");
		this.collision = new Collision(this.game);
		this.hero = new Player(game, 80, this.game.GROUND_LEVEL - 26);

		// Objekte
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "ape.png", 35, 36, 300, this.game.GROUND_LEVEL, 2));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "alien.png", 47, 49, 565, this.game.GROUND_LEVEL, 2));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "alien.png", 47, 49, 614, this.game.GROUND_LEVEL, 2));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "alien.png", 47, 49, 588, this.game.GROUND_LEVEL - 47, 2));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "poop.png", 35, 36, 820, this.game.GROUND_LEVEL, 2));

		// Level-Objekte mit Mission

		// Mission 1
		ArrayList<String> tmpAnswers = new ArrayList<String>();
		tmpAnswers.add("[SHIFT] Schwarz");
		tmpAnswers.add("[CTRL] Blau");
		String tmpMissionText = "Hallo, mein Name ist Tim...";
		String tmpQuestion = "Was ist meine Lieblingsfarbe?";
		tmpMission = new Mission(game, "white.png", 200, 300, 100, 100, 3,
				tmpMissionText, tmpQuestion, tmpAnswers, 0, 2);

		lvlObjects
				.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
						+ "ape.png", 35, 36, 200, this.game.GROUND_LEVEL, 2,
						tmpMission));

	}

	public void drawLevel() {
		this.game.app.background(255);
		this.levelBackground.drawBackground();
		this.hero.drawPlayer();

		this.game.app.beginShape();
		this.game.app.textSize(24);
		this.game.app.text("HSRW Runner", 10, 34, 2);
		this.game.app.text("CreditPoints: " + this.game.sumCreditPoints, 500,
				34, 2);
		this.game.app.fill(255, 255, 255);
		this.game.app.endShape();

		inMission = false;

		// Objekte zeichnen
		for (LvlObject lvlObject : this.lvlObjects) {
			lvlObject.draw();

			// Mission prüfen
			if (this.hero.states[5] == true && lvlObject.collided
					&& this.tmpMission.isPlayed != true) {
				lvlObject.mission.drawMission();
				inMission = true;
			}
		}

		// Funktion für in Mission check welche Taste gedrückt wurde, bei
		// richtiger Antwort creditpoints addieren
		if (inMission) {
			if (this.game.keyboard[4] ^ this.game.keyboard[5]
					^ this.game.keyboard[6] ^ this.game.keyboard[7]) {
				inMission = false;
				if (this.game.keyboard[4] && this.tmpMission.rightAnswer == 1) {
					this.game.sumCreditPoints += this.tmpMission.CREDITPOINTS;
				} else if (this.game.keyboard[5]
						&& this.tmpMission.rightAnswer == 2) {
					this.game.sumCreditPoints += this.tmpMission.CREDITPOINTS;
				}

				this.hero.x += 70; // noch versuchen variabel zu bekommen
									// (missionsobjekt breite anstatt 70)
				this.tmpMission.isPlayed = true;
			}

		}

		// Check wieviel CP's man hat
		if (this.game.keyboard[6]) {
			System.out.println("CreditPoints = " + this.game.sumCreditPoints);
		}

		// Funktion für Bewegungen im Level
		if (inMission == false) {
			this.levelMovements();
		}
	}

	public void levelMovements() {
		// Kollisionen prüfen
		this.collision.detectPlayerObject(this.hero, this.lvlObjects);

		// Vorwärtsbewegung
		if (this.game.keyboard[0] && this.hero.states[0] == false
				&& this.hero.x >= this.hero.MAX_X) {
			// Bewegung Hintergrund
			this.levelBackground.moveBackground(this.hero.SPEED * (-1), 0);

			// Objekte mitbewegen
			for (LvlObject lvlObject : this.lvlObjects) {
				lvlObject.move(this.hero.SPEED * (-1), 0);
			}

			this.hero.states[4] = false;
		} else if (this.game.keyboard[0] && this.hero.states[0] == false
				&& this.hero.x < this.hero.MAX_X) {
			// Bewegung Spieler statt Hintergrundbild
			this.hero.movePlayer(this.hero.SPEED, 0);
			this.hero.states[4] = false;
		} else if (this.hero.states[0] && this.hero.isJumped == false) {
			// Antihaftung am Objektrand bei Kollision
			this.hero.movePlayer(-1, 0);
		}

		// Rückwärtsbewegung
		if (this.game.keyboard[1] && this.hero.states[1] == false
				&& this.hero.x == this.hero.MIN_X) {
			this.hero.states[4] = true;
		} else if (this.game.keyboard[1] && this.hero.states[1] == false
				&& this.hero.x > this.hero.MIN_X) {
			// Bewegung Spieler statt Hintergrundbild
			this.hero.movePlayer(this.hero.SPEED * (-1), 0);
			this.hero.states[4] = true;
		} else if (this.hero.states[1] && this.hero.isJumped == false) {
			// Antihaftung am Objektrand bei Kollision
			this.hero.movePlayer(1, 0);
		}

		// Delay
		if (this.hero.isJumped == false
				&& (this.game.keyboard[0] || this.game.keyboard[1])) {
			this.hero.states[3] = false;
			this.hero.delay++;
		} else {
			this.hero.states[3] = true;
		}

		// Springbewegung
		if (this.game.keyboard[2]) {
			// Nur springen wenn die Spielfigur auf dem "Boden" bzw. "Objekt"
			// steht
			if (this.hero.y == this.game.GROUND_LEVEL || this.hero.states[2]) {
				this.hero.isJumped = true;
			}
		}

		// Springt der Spieler?
		if (this.hero.isJumped) {
			// erhöhe die Spielfigur bei jedem draw()
			this.hero.jumpedY += game.GRAVITY;
			if (this.hero.jumpedY % this.hero.JUMP_HEIGHT > 0) {
				this.hero.y -= game.GRAVITY;
			}

			// am höchsten Punkt?
			if (this.hero.jumpedY % this.hero.JUMP_HEIGHT == 0) {
				this.hero.isJumped = false; // Sprung beenden
			}
		} else if (this.hero.y < game.GROUND_LEVEL
				&& this.hero.states[2] == false) {
			// Spielfigur wieder absenken
			if (Math.abs(this.hero.y - this.game.GROUND_LEVEL) < game.GRAVITY) {
				this.hero.y = this.game.GROUND_LEVEL;
			} else {
				this.hero.y += game.GRAVITY;
			}

			this.hero.jumpedY = 0;
		}
	}
}
