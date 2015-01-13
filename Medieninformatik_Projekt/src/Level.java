import java.util.ArrayList;

import processing.core.PImage;

public class Level {
	Game game;
	Player hero;
	Collision collision;
	ArrayList<LvlObject> lvlObjects = new ArrayList<LvlObject>();
	Background levelShadowBackground;
	Background levelBackground;
	public int creditpoints;
	public double time;
	public boolean inMission;
	PImage logoImage;

	public Level() {
		// default
	}

	// Level starten
	public Level(Game game) {
		this.game = game;
		this.logoImage = this.game.app.loadImage(game.DEFAULT_IMAGEPATH
				+ "logo.png");
		this.levelShadowBackground = new Background(game,
				game.DEFAULT_IMAGEPATH + "shadowbg.png");
		this.levelBackground = new Background(game, game.DEFAULT_IMAGEPATH
				+ "mainbg.png");

		this.collision = new Collision(this.game);
		this.hero = new Player(game, 80, this.game.GROUND_LEVEL - 26);

		// Objekt 1
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji//blume.png", 35, 36, 400, this.game.GROUND_LEVEL, 2, false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji//poop.png", 35, 36, 600, this.game.GROUND_LEVEL, 2, false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji//frosch.png", 35, 36, 750, this.game.GROUND_LEVEL, 2, false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji//santa.png", 35, 36, 1100, this.game.GROUND_LEVEL, 2, false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji//bus.png", 35, 36, 1300, this.game.GROUND_LEVEL, 2, false));

		// Mission 1 - Tim
		ArrayList<Mission> tmpMissions = new ArrayList<Mission>();
		ArrayList<String> tmpAnswers = new ArrayList<String>();
		ArrayList<Integer> answerKey = new ArrayList<Integer>();
		answerKey.add(2);
		tmpAnswers.add("[1] Schwarz");
		tmpAnswers.add("[2] Blau");
		tmpAnswers.add("[3] Gelb");
		tmpAnswers.add("[4] Lila");
		String tmpMissionText = "Hallo, ich bin Tim ...";
		String tmpQuestion = "Was ist meine Lieblingsfarbe?";
		String tmpSolvedText = "Gut geraten!\n5 CPs für dich.";
		String tmpNotSolvedText = "Ernsthaft?\nKeine CPs für dich!";
		tmpMissions.add(new Mission(game, "white.png", 200, 300, 100, 100, 3,
				tmpMissionText, tmpQuestion, tmpSolvedText, tmpNotSolvedText,
				tmpAnswers, answerKey));
		tmpAnswers = new ArrayList<String>();
		answerKey = new ArrayList<Integer>();
		answerKey.add(1);
		tmpAnswers.add("[1] Schwimmen");
		tmpAnswers.add("[2] Hockey");
		tmpAnswers.add("[3] Darten");
		tmpAnswers.add("[4] Fußball");
		tmpMissionText = "Hallo, ich bin Tim ...";
		tmpQuestion = "Was ist mein Hobby?";
		tmpSolvedText = "Gut geraten!\n5 CPs für dich.";
		tmpNotSolvedText = "Ernsthaft?\nKeine CPs für dich!";
		tmpMissions.add(new Mission(game, "white.png", 200, 300, 100, 100, 3,
				tmpMissionText, tmpQuestion, tmpSolvedText, tmpNotSolvedText,
				tmpAnswers, answerKey));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "tim.png", 60, 42, 1500, this.game.GROUND_LEVEL, 2, true,
				tmpMissions));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "tim.png", 60, 42, 10000, this.game.GROUND_LEVEL, 2, true,
				tmpMissions));

		// Objekt 2
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji//burger.png", 35, 36, 1800, this.game.GROUND_LEVEL, 2, false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji//poop.png", 35, 36, 2000, this.game.GROUND_LEVEL, 2, false));

		// Mission 2 - Marwin
		tmpMissions = new ArrayList<Mission>();
		tmpAnswers = new ArrayList<String>();
		answerKey = new ArrayList<Integer>();
		answerKey.add(3);
		tmpAnswers.add("[1] ComicPlanet");
		tmpAnswers.add("[2] Lady Gaga");
		tmpAnswers.add("[3] DirtyWhitePaint");
		tmpAnswers.add("[4] keiner von denen");
		tmpMissionText = "Hallo, ich heiße Marwin. Ich gucke\nmir gerne sinnlosen Kram an.";
		tmpQuestion = "Wer hat auf YouTube den\nMarienkäfer \"Marvin\" erfunden?";
		tmpSolvedText = "Ich heiße Marwin!\n5 CPs an den Marienkäfer.";
		tmpNotSolvedText = "Ist das so?\nKeine extra CPs für dich!";
		tmpMissions.add(new Mission(game, "white.png", 230, 300, 100, 100, 3,
				tmpMissionText, tmpQuestion, tmpSolvedText, tmpNotSolvedText,
				tmpAnswers, answerKey));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "marwin.png", 60, 42, 2300, this.game.GROUND_LEVEL, 2, true,
				tmpMissions));

		//Objekte 4
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji//frosch.png", 35, 36, 700, this.game.GROUND_LEVEL, 2, false));

		// Prof 1
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji//profplatzhalter.png", 35, 36, 3500, this.game.GROUND_LEVEL, 2, false));

		// Mission 3 - Sarah
		tmpMissions = new ArrayList<Mission>();
		tmpAnswers = new ArrayList<String>();
		answerKey = new ArrayList<Integer>();
		answerKey.add(4);
		tmpAnswers.add("[1] Fight Club");
		tmpAnswers.add("[2] Garden State");
		tmpAnswers.add("[3] Sin City");
		tmpAnswers.add("[4] The Fast and the Furious");
		tmpMissionText = "Hallo, ich bin Sarah und mag Filme.";
		tmpQuestion = "Welchen Film habe ich aber nicht\nim Regal stehen?";
		tmpSolvedText = "5 filmreife CPs!";
		tmpNotSolvedText = "Keine CPs, kein Oscar.";
		tmpMissions.add(new Mission(game, "white.png", 200, 300, 100, 100, 3,
				tmpMissionText, tmpQuestion, tmpSolvedText, tmpNotSolvedText,
				tmpAnswers, answerKey));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "sarah.png", 60, 42, 3700, this.game.GROUND_LEVEL, 2, true,
				tmpMissions));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "ape.png", 35, 36, 5500, this.game.GROUND_LEVEL, 2, false));

		// Prof 2
		// ....

		// Mission 4 - Johannes
		tmpMissions = new ArrayList<Mission>();
		tmpAnswers = new ArrayList<String>();
		answerKey = new ArrayList<Integer>();
		answerKey.add(4);
		tmpAnswers.add("[1] Tünnes");
		tmpAnswers.add("[2] Schäl");
		tmpAnswers.add("[3] Hennes");
		tmpAnswers.add("[4] Alle drei sind Kölner");
		tmpMissionText = "Hallo, ich bin Johannes und\nkomme aus Köln.";
		tmpQuestion = "Kannst du mir sagen, wer kein\nKölner ist?";
		tmpSolvedText = "Richtig. Hennes ist das Maskottchen\ndes FC, ein Geißbock, Tünnes und\nSchäl sind Figuren aus dem Kölschen\nHännesschen Theater.";
		tmpNotSolvedText = "Falsch, alle sind Kölner.\nHennes ist das Maskottchen des FC,\nein Geißbock, Tünnes und Schäl\nsind Figuren aus dem Kölschen\nHännesschen Theater.";
		tmpMissions.add(new Mission(game, "white.png", 230, 300, 100, 100, 3,
				tmpMissionText, tmpQuestion, tmpSolvedText, tmpNotSolvedText,
				tmpAnswers, answerKey));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "johannes.png", 60, 42, 4500, this.game.GROUND_LEVEL, 2,
				true, tmpMissions));

		// Prof 3
		// ...

		// Zieleinlauf
				tmpMissions = new ArrayList<Mission>();
				tmpAnswers = new ArrayList<String>();
				answerKey = new ArrayList<Integer>();
				answerKey.add(4);
				tmpAnswers.add("[1] Kann");
				tmpAnswers.add("[2] man");
				tmpAnswers.add("[3] das hier");
				tmpAnswers.add("[4] wegmachen?");
				tmpMissionText = "Super! Du hast es geschafft. Oben siehtst\ndu deine gesammelten Creditpoints.";
				tmpQuestion = "Bla,bla.";
				tmpSolvedText = "Hier noch Credits und Bildquellen.";
				tmpNotSolvedText = "Hier noch Credits und Bildquellen.";
				tmpMissions.add(new Mission(game, "white.png", 230, 300, 100, 100, 3,
						tmpMissionText, tmpQuestion, tmpSolvedText, tmpNotSolvedText,
						tmpAnswers, answerKey));

				lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
						+ "ziel.png", 130, 71, 4700, this.game.GROUND_LEVEL+15, 2,
						true, tmpMissions));

				
		// Random Missions
		for (LvlObject lvlObject : this.lvlObjects) {
			if (lvlObject.missions != null) {
				lvlObject.selectMission();
			}
		}
	}

	public void drawLevel() {
		this.game.app.background(255);
		this.levelShadowBackground.drawBackground();
		this.levelBackground.drawBackground();
		this.hero.drawPlayer();

		this.game.app.noStroke();
		this.game.app.beginShape();
		this.game.app.texture(logoImage);
		this.game.app.vertex(0 + 15, 0 + 15, 3, 0, 0);
		this.game.app.vertex(168 + 15, 0 + 15, 3, 1, 0);
		this.game.app.vertex(168 + 15, 30 + 15, 3, 1, 1);
		this.game.app.vertex(0 + 15, 30 + 15, 3, 0, 1);
		this.game.app.endShape();

		this.game.app.textSize(24);
		this.game.app.text("CreditPoints: " + this.game.sumCreditPoints, 500,
				34, 2);
		this.game.app.fill(0, 0, 0);

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
			// Bewegung Hintergründe
			this.levelShadowBackground.moveBackground(-1, 0);
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
