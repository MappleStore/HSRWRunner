import java.util.ArrayList;

public class Collision {
	Game game;

	public Collision(Game game) {
		this.game = game;
	}

	public static void detectPlayerObject(Player player,
			ArrayList<LvlObject> lvlObjects) {
		for (LvlObject lvlObject : lvlObjects) {

			// Nur auf Objekte in der Nähe reagieren
			if (Math.abs(player.x - lvlObject.x) < 50) {

				// Player im Objektbereich?
				if ((player.x + player.PLAYER_WIDTH) >= lvlObject.x
						&& player.x <= (lvlObject.x + lvlObject.width)) {

					// Kollision zwischenspeichern
					player.states[2] = true; //

					// Auf gleicher Höhe?
					if (player.y == lvlObject.y) {
						// Steht die Figur eher vor oder hinter dem Objekt?
						if (player.x <= lvlObject.x + (lvlObject.width/2)) {
							player.states[0] = true; // Vorbewegung sperren
						} else {
							player.states[1] = true; // Zurückbewegung sperren
						}
					} else {
						// Während eines Sprunges die Bewegung zulassen
						player.states[0] = false;
						player.states[1] = false;
					}
				} else {
					// Zustände zurücksetzen
					player.states[0] = false;
					player.states[1] = false;
					player.states[2] = false;
				}
			}
		}
	}

}
