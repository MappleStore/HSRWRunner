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
		this.hero = new Player(game, 80, this.game.GROUND_LEVEL);

		// Mission Temp-Variablen
		ArrayList<Mission> tmpMissions = null;
		ArrayList<String> tmpAnswers = null;
		ArrayList<Integer> answerKey = null;
		String tmpMissionText;
		String tmpQuestion;
		String tmpSolvedText;
		String tmpNotSolvedText;

		// Info Objekt
		tmpMissions = new ArrayList<Mission>();
		tmpAnswers = new ArrayList<String>();
		answerKey = new ArrayList<Integer>();
		tmpMissionText = "Willkommen auf dem Campus der HSRW!\n\nEs ist kurz vor Ende des Semesters aber blöderweise fehlen dir noch ein\npaar Creditpoints. Laufe über den Campus und löse die Aufgaben, die\ndir gestellt werden. Für jede richtig Antwort erhältst du CPs!\n\nDrücke nun [ENTER] zum Starten und benutze die\nPfeiltasten zum Steuern.\n\nViel Spaß!";
		tmpQuestion = null;
		tmpSolvedText = null;
		tmpNotSolvedText = null;
		tmpMissions.add(new Mission(game, 5, "white.png", 230, 530, 100, 100,
				3, tmpMissionText, tmpQuestion, tmpSolvedText,
				tmpNotSolvedText, tmpAnswers, answerKey));
		// Startflagge
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/flagge.png", 35, 36, 110, this.game.GROUND_LEVEL, 2,
				true, tmpMissions));
		// Objekte
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/blume.png", 35, 36, 400, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/poop.png", 35, 36, 600, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/frosch.png", 35, 36, 750, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/mail.png", 35, 36, 1065, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/mail.png", 35, 36, 1110, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/affe.png", 35, 36, 1090, this.game.GROUND_LEVEL - 35,
				2, false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/bus.png", 35, 36, 1300, this.game.GROUND_LEVEL, 2,
				false));

		// Mission 1 - Tim
		tmpMissions = new ArrayList<Mission>();
		tmpAnswers = new ArrayList<String>();
		answerKey = new ArrayList<Integer>();
		answerKey.add(2);
		tmpAnswers.add("[1] Schwarz");
		tmpAnswers.add("[2] Blau");
		tmpAnswers.add("[3] Gelb");
		tmpAnswers.add("[4] Lila");
		tmpMissionText = "Hallo, ich bin Tim ...";
		tmpQuestion = "Was ist meine Lieblingsfarbe?";
		tmpSolvedText = "Gut geraten!\n5 CPs für dich.";
		tmpNotSolvedText = "Ernsthaft?\nKeine CPs für dich!";
		tmpMissions.add(new Mission(game, 5, "white.png", 200, 300, 100, 100,
				3, tmpMissionText, tmpQuestion, tmpSolvedText,
				tmpNotSolvedText, tmpAnswers, answerKey));
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
		tmpMissions.add(new Mission(game, 5, "white.png", 200, 300, 100, 100,
				3, tmpMissionText, tmpQuestion, tmpSolvedText,
				tmpNotSolvedText, tmpAnswers, answerKey));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "tim.png", 60, 42, 1500, this.game.GROUND_LEVEL, 2, true,
				tmpMissions));
		// lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
		// + "tim.png", 60, 42, 1600, this.game.GROUND_LEVEL, 2, true,
		// tmpMissions));

		// Objekt 2
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/burger.png", 35, 36, 1800, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/poop.png", 35, 36, 2000, this.game.GROUND_LEVEL, 2,
				false));

		// Mission 2 - Marwin
		tmpMissions = new ArrayList<Mission>();
		
		// Frage 1
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
		tmpMissions.add(new Mission(game, 5, "white.png", 230, 300, 100, 100,
				3, tmpMissionText, tmpQuestion, tmpSolvedText,
				tmpNotSolvedText, tmpAnswers, answerKey));
		
		// Frage 2
		tmpAnswers = new ArrayList<String>();
		answerKey = new ArrayList<Integer>();
		answerKey.add(1);
		tmpAnswers.add("[1] Xbox One");
		tmpAnswers.add("[2] PlayStation 4");
		tmpAnswers.add("[3] Nintendo Wii U");
		tmpAnswers.add("[4] Turingmaschine");
		tmpMissionText = "Grüß dich, ich heiße Marwin. Ich spiele\nneuerdings auf einer Konsole.";
		tmpQuestion = "Kannst du erraten welche Konsole?";
		tmpSolvedText = "Goldrichtig, 5 CPs!";
		tmpNotSolvedText = "Ich bin enttäuscht!\nLeider falsch.";
		tmpMissions.add(new Mission(game, 5, "white.png", 230, 300, 100, 100,
				3, tmpMissionText, tmpQuestion, tmpSolvedText,
				tmpNotSolvedText, tmpAnswers, answerKey));
		
		// Frage 3
		tmpAnswers = new ArrayList<String>();
		answerKey = new ArrayList<Integer>();
		answerKey.add(3);
		tmpAnswers.add("[1] Ja bitte, Johannes.");
		tmpAnswers.add("[2] Ja bitte, Tim.");
		tmpAnswers.add("[3] Ja bitte, Marwin.");
		tmpMissionText = "Hi, du siehst verzweifelt aus.\nDu suchst sicher noch CPs.";
		tmpQuestion = "Kann ich dir helfen?";
		tmpSolvedText = "Klar, hier hast du 5 CPs.";
		tmpNotSolvedText = "Ich heiße nicht so.";
		tmpMissions.add(new Mission(game, 5, "white.png", 230, 300, 100, 100,
				3, tmpMissionText, tmpQuestion, tmpSolvedText,
				tmpNotSolvedText, tmpAnswers, answerKey));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "marwin.png", 60, 42, 2300, this.game.GROUND_LEVEL, 2, true,
				tmpMissions));

		// Objekte 4
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/frosch.png", 35, 36, 2400, this.game.GROUND_LEVEL, 2,
				false));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/postbox.png", 35, 36, 2660, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/postbox.png", 35, 36, 2700, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/postbox.png", 35, 36, 2745, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/postbox.png", 35, 36, 2790, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/postbox.png", 35, 36, 2835, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/postbox.png", 35, 36, 2875, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/diskette.png", 35, 36, 2700,
				this.game.GROUND_LEVEL - 35, 2, false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/diskette.png", 35, 36, 2745,
				this.game.GROUND_LEVEL - 35, 2, false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/diskette.png", 35, 36, 2790,
				this.game.GROUND_LEVEL - 35, 2, false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/diskette.png", 35, 36, 2835,
				this.game.GROUND_LEVEL - 35, 2, false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/CD.png", 35, 36, 2745, this.game.GROUND_LEVEL - 70, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/CD.png", 35, 36, 2790, this.game.GROUND_LEVEL - 70, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/kugel.png", 35, 36, 2770,
				this.game.GROUND_LEVEL - 105, 2, false));

		// Prof 1
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/profplatzhalter.png", 40, 36, 3500,
				this.game.GROUND_LEVEL, 2, false));

		// Objekte
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/poop.png", 35, 36, 3700, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/blume.png", 35, 36, 3800, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/tv.png", 35, 36, 4100, this.game.GROUND_LEVEL, 2,
				false));

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
		tmpMissions.add(new Mission(game, 5, "white.png", 200, 300, 100, 100,
				3, tmpMissionText, tmpQuestion, tmpSolvedText,
				tmpNotSolvedText, tmpAnswers, answerKey));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "sarah.png", 60, 42, 4200, this.game.GROUND_LEVEL, 2, true,
				tmpMissions));

		// Objekte
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/palme.png", 35, 36, 4400, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/santa.png", 35, 36, 4700, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects
				.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
						+ "emoji/H.png", 35, 36, 5000, this.game.GROUND_LEVEL,
						2, false));
		lvlObjects
				.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
						+ "emoji/S.png", 35, 36, 5040, this.game.GROUND_LEVEL,
						2, false));
		lvlObjects
				.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
						+ "emoji/R.png", 35, 36, 5080, this.game.GROUND_LEVEL,
						2, false));
		lvlObjects
				.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
						+ "emoji/W.png", 35, 36, 5120, this.game.GROUND_LEVEL,
						2, false));

		// Prof 2
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/profplatzhalter.png", 40, 36, 5500,
				this.game.GROUND_LEVEL, 2, false));

		// Objekte
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/burger.png", 35, 36, 5900, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/frosch.png", 35, 36, 5600, this.game.GROUND_LEVEL, 2,
				false));

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
		tmpMissions.add(new Mission(game, 5, "white.png", 230, 300, 100, 100,
				3, tmpMissionText, tmpQuestion, tmpSolvedText,
				tmpNotSolvedText, tmpAnswers, answerKey));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "johannes.png", 60, 42, 6100, this.game.GROUND_LEVEL, 2,
				true, tmpMissions));

		// Objekte
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/postbox.png", 35, 36, 6500, this.game.GROUND_LEVEL, 2,
				false));
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/bus.png", 35, 36, 6800, this.game.GROUND_LEVEL, 2,
				false));

		// Prof 3
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/profplatzhalter.png", 40, 36, 7000,
				this.game.GROUND_LEVEL, 2, false));

		// Objekte
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "emoji/fernrohr.png", 35, 36, 7300, this.game.GROUND_LEVEL,
				2, false));

		// Zieleinlauf
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "hsrw_flag.png", 250, 59, 7870, this.game.GROUND_LEVEL, 2,
				true));

		tmpMissions = new ArrayList<Mission>();
		tmpAnswers = new ArrayList<String>();
		answerKey = new ArrayList<Integer>();
		answerKey.add(2);
		tmpAnswers.add("[1] Level neustarten");
		tmpAnswers.add("[2] Quellen und Credits ansehen");
		tmpMissionText = "Super! Du hast es geschafft und dabei #CP# Credit Points gesammelt.";
		tmpQuestion = "\nWähle eine der Optionen:";
		tmpSolvedText = "\nEin Projekt von Tim Landskron, Marwin Wiegard,\nSarah-Maria Rostalski und Johannes Nolte.\n\nEmojis von https://github.com/twitter/twemoji (CC-BY 4.0).\n\nDrücke eine Pfeil-Taste zum Neustart.";
		tmpNotSolvedText = "Bitte drücke eine Pfeiltaste um das Spiel neuzustarten.";
		tmpMissions.add(new Mission(game, 0, "white.png", 230, 520, 100, 100,
				3, tmpMissionText, tmpQuestion, tmpSolvedText,
				tmpNotSolvedText, tmpAnswers, answerKey));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "hsrw_flag.png", 250, 59, 8000, this.game.GROUND_LEVEL, 2,
				false, tmpMissions));

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

		// Logo zeichnen
		this.game.app.noStroke();
		this.game.app.beginShape();
		this.game.app.texture(logoImage);
		this.game.app.vertex(0 + 15, 0 + 15, 3, 0, 0);
		this.game.app.vertex(168 + 15, 0 + 15, 3, 1, 0);
		this.game.app.vertex(168 + 15, 30 + 15, 3, 1, 1);
		this.game.app.vertex(0 + 15, 30 + 15, 3, 0, 1);
		this.game.app.endShape();

		// CPs zeichnen
		this.game.app.textSize(24);
		this.game.app.text("Credit Points: " + this.game.sumCreditPoints, 500,
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

		// Player zeichnen
		this.hero.drawPlayer();

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
