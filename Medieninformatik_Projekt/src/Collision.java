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
			lvlObject.collided = false;
			
			// Player im Objektbereich?
			if ((player.x + player.PLAYER_WIDTH) >= lvlObject.x
					&& player.x <= (lvlObject.x + lvlObject.width)) {

				// Kollision zwischenspeichern
				if ((player.y >= (lvlObject.y - lvlObject.height) && player.y <= lvlObject.y)) {
					player.states[2] = true;
					lvlObject.collided = true;
					
					if(lvlObject.goThrough) {
						player.states[2] = false;
					}

					if (lvlObject.mission != null) {
						if(lvlObject.mission.isPlayed == false) {
							this.game.hsrwLvl.inMission = true;
							player.missionCounter++;	
						}
					}

					// Spieler darf nicht in/unter Objektoberfläche stehen
					if (player.y != (lvlObject.y - lvlObject.height) && this.game.hsrwLvl.inMission == false && lvlObject.goThrough == false) {
						player.y -= 1; // anheben
					}
				}

				// Auf gleicher Höhe?
				if ((lvlObject.y - lvlObject.height + 1) < player.y && lvlObject.goThrough == false) {
					// Steht die Figur eher vor oder hinter dem Objekt?
					if (player.x <= lvlObject.x + (lvlObject.width / 2)) {
						player.states[0] = true; // Vorbewegung sperren
					} else {
						player.states[1] = true; // Zurückbewegung sperren
					}
				}
			}
		}

	}
}
