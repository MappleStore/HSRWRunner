public class Level {
	Game g;
	Player hero;
	Background levelBackground;
	public int creditpoints;
	public double time;
	
	public Level() {
		// default
	}
	
	// Level starten
	public Level(Game g) {
		this.g = g;
		this.levelBackground = new Background(g, g.DEFAULT_IMAGEPATH + "hsrw.png");
		this.hero = new Player(g, 80, 380);
	}
	
	public void drawLevel() {
		this.g.parent.background(255);
		this.levelBackground.drawBackground();
		this.hero.drawPlayer();
		this.levelMovements();
	}
	
	public void levelMovements() {
		// Vorwärtsbewegung
		if (this.g.keyboard[0] && this.hero.x == this.hero.MAX_X) {
			// Bewegung Hintergrundbild
			this.levelBackground.moveBackground(-2, 0);
			this.hero.delay++;
		} else if (this.g.keyboard[0] && this.hero.x < this.hero.MAX_X) {
			// Bewegung Spieler statt Hintergrundbild
			this.hero.movePlayer(2, 0);
			this.hero.delay++;
		}

		// Rückwärtsbewegung
		if (this.g.keyboard[1] && this.hero.x == this.hero.MIN_X) {
			this.hero.delay++;
		} else if (this.g.keyboard[1] && this.hero.x > this.hero.MIN_X) {
			// Bewegung Spieler statt Hintergrundbild
			this.hero.movePlayer(-2, 0);
			this.hero.delay++;
		}

		// Springbewegung
		if (this.g.keyboard[2]) {
			// Nur springen wenn die Spielfigur auf dem "Boden" steht
			if (this.hero.y + this.hero.PLAYER_HEIGHT == this.g.GROUND_LEVEL) {
				this.hero.isJumped = true;
			}
		}
	}
}
