import java.util.ArrayList;

public class Collision {
	Game game;

	public Collision(Game game) {
		this.game = game;
	}

	public void detectPlayerObject(Player player,
			ArrayList<LvlObject> lvlObjects) {
		player.states[0] = false;
		player.states[1] = false;
		player.states[2] = false;

		for (LvlObject lvlObject : lvlObjects) {

			// Player im Objektbereich?
			if ((player.x + player.PLAYER_WIDTH) >= lvlObject.x
					&& player.x <= (lvlObject.x + lvlObject.width)) {

				// Kollision zwischenspeichern
				if ((player.y >= (lvlObject.y - lvlObject.height) && player.y <= lvlObject.y)) {
					player.states[2] = true;
					
					// Spieler darf nicht in/unter Objektoberfläche stehen
					if (player.y != (lvlObject.y - lvlObject.height)) {
						player.y -= 1; // anheben
					}
				}

				// Auf gleicher Höhe?
				if ((lvlObject.y - lvlObject.height + 1) < player.y) {
					// Steht die Figur eher vor oder hinter dem Objekt?
					if (player.x <= lvlObject.x + (lvlObject.width / 2)) {
						player.states[0] = true; // Vorbewegung sperren
					} else {
						player.states[1] = true; // Zurückbewegung sperren
					}
				}
				
				//System.out.println(player.states[0] + " # " + player.states[1] + " # " + player.states[2]);
				//System.out.println(player.y + " # " + lvlObject.y + " # " + (lvlObject.y + lvlObject.height));
			}
		}

	}

}
