import java.util.ArrayList;
import processing.core.PImage;

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
	PImage logoImage;

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
		tmpAnswers.add("[1] Schwarz");
		tmpAnswers.add("[2] Blau");
		tmpAnswers.add("[3] Gelb");
		tmpAnswers.add("[4] Lila");
		String tmpMissionText = "Hallo, mein Name ist Tim...";
		String tmpQuestion = "Was ist meine Lieblingsfarbe?";
		String tmpSolvedText = "Gut gemacht!";
		String tmpNotSolvedText = "Schade, das ist leider falsch!";
		tmpMission = new Mission(game, "white.png", 200, 300, 100, 100, 3,
				tmpMissionText, tmpQuestion, tmpSolvedText, tmpNotSolvedText,
				tmpAnswers, 2);

		lvlObjects
				.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
						+ "ape.png", 35, 36, 200, this.game.GROUND_LEVEL, 2,
						tmpMission));

	}

	public void drawLevel() {
		this.game.app.background(255);
		this.levelBackground.drawBackground();
		this.hero.drawPlayer();
		this.logoImage = this.game.app.loadImage(game.DEFAULT_IMAGEPATH + "logo.png");
		this.game.app.beginShape();
		this.game.app.texture(logoImage);
		this.game.app.vertex(10, 10, 3, 0, 0);
		this.game.app.vertex(300, 10, 3, 1, 0);
		this.game.app.vertex(300, 100, 3, 1, 1);
		this.game.app.vertex(10, 100, 3, 0, 1);
		this.game.app.textSize(24);
		this.game.app.text("CreditPoints: " + this.game.sumCreditPoints, 500,
				34, 2);
		this.game.app.fill(0, 0, 0);
		this.game.app.endShape();

		inMission = false;

		// Objekte zeichnen
		for (LvlObject lvlObject : this.lvlObjects) {
			lvlObject.draw();

			// Mission prüfen und ggf. zeichnen
			if (lvlObject.mission != null) {
				if (lvlObject.collided && lvlObject.mission.isPlayed != true) {
					inMission = true;
					lvlObject.mission.drawMission();

					// Mission durchführen
					lvlObject.mission.checkMission();
				}
			}
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
