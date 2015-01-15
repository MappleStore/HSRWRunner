import processing.core.PApplet;

public class HsrwRunner extends PApplet {
	/**
	 * HSRWRunner
	 */
	private static final long serialVersionUID = 1L;
	Game game = null;
	
	public static void main(String[] args) {
		PApplet.main("HsrwRunner");
	}

	public void setup() {
		frame.setTitle("HSRWRunner v1.0"); 
//		ImageIcon titlebaricon = new ImageIcon(loadBytes("myicon.gif"));
//		frame.setIconImage(titlebaricon.getImage());
		this.game = new Game(this);
		size(game.WINDOW_WIDTH, game.WINDOW_HEIGHT, P3D);
		textureMode(NORMAL);

		this.game.loadLevel();
	}

	public void draw() {
		frameRate(36);
		background(255);
		this.game.hsrwLvl.drawLevel();

	}

	public void keyPressed() {
		this.game.keyPressed();
	}

	public void keyReleased() {
		this.game.keyReleased();
	}
	
	public void mouseClicked() {
		//this.game.app.loop();
	}
}
