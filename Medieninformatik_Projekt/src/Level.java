import java.util.ArrayList;

public class Level {
	Game game;
	Player hero;
	Collision collision;
	ArrayList<LvlObject> lvlObjects = new ArrayList<LvlObject>();
	Background levelBackground;
	public int creditpoints;
	public double time;

	public Level() {
		// default
	}

	// Level starten
	public Level(Game game) {
		this.game = game;
		this.levelBackground = new Background(game, game.DEFAULT_IMAGEPATH
				+ "hsrw.png");
		this.collision = new Collision(this.game);
		this.hero = new Player(game, 80, this.game.GROUND_LEVEL);

		// Objekte :)
		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "poop.png", 35, 36, 300, this.game.GROUND_LEVEL, 2));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "poop.png", 35, 36, 380, this.game.GROUND_LEVEL, 2));

		lvlObjects.add(new LvlObject(this.game, this.game.DEFAULT_IMAGEPATH
				+ "poop.png", 35, 36, 820, this.game.GROUND_LEVEL, 2));
	}

	public void drawLevel() {
		this.game.app.background(255);
		this.levelBackground.drawBackground();
		this.hero.drawPlayer();

		// Objekte zeichnen
		for (LvlObject lvlObject : this.lvlObjects) {
			lvlObject.draw();
		}

		// Funktion für Bewegungen im Level
		this.levelMovements();
	}

	public void levelMovements() {
		// Kollisionen prüfen
		this.collision.detectPlayerObject(this.hero, this.lvlObjects);

		// Vorwärtsbewegung
		if (this.game.keyboard[0] && this.hero.states[0] == false
				&& this.hero.x == this.hero.MAX_X) {
			// Bewegung Hintergrund
			this.levelBackground.moveBackground(-2, 0);

			// Objekte mitbewegen
			for (LvlObject lvlObject : this.lvlObjects) {
				lvlObject.move(-2, 0);
			}
			
			this.hero.states[4] = false;
		} else if (this.game.keyboard[0] && this.hero.states[0] == false
				&& this.hero.x < this.hero.MAX_X) {
			// Bewegung Spieler statt Hintergrundbild
			this.hero.movePlayer(2, 0);
			this.hero.states[4] = false;
		}

		// Rückwärtsbewegung
		if (this.game.keyboard[1] && this.hero.states[1] == false
				&& this.hero.x == this.hero.MIN_X) {
			this.hero.states[4] = true;
			// Kein Rücklauf des Hintergrundes
			// this.levelBackground.moveBackground(2, 0);
		} else if (this.game.keyboard[1] && this.hero.states[1] == false
				&& this.hero.x > this.hero.MIN_X) {
			// Bewegung Spieler statt Hintergrundbild
			this.hero.movePlayer(-2, 0);
			this.hero.states[4] = true;
		}
		
		// Delay
		if (this.hero.isJumped == false && (this.game.keyboard[0] || this.game.keyboard[1])) {
			this.hero.states[3] = false;
			this.hero.delay++;		
		} else {
			this.hero.states[3] = true;
		}

		// Springbewegung
		if (this.game.keyboard[2]) {
			// Nur springen wenn die Spielfigur auf dem "Boden" steht
			if (this.hero.y == this.game.GROUND_LEVEL) {
				this.hero.isJumped = true;
			}
		}
	}
}
