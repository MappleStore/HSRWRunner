import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
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
		frame.setTitle("HSRWRunner");
		this.game = new Game(this);
		ImageIcon titlebaricon = new ImageIcon(
				loadBytes(this.game.DEFAULT_IMAGEPATH + "hsrw-60.png"));
		frame.setIconImage(titlebaricon.getImage());
		size(game.WINDOW_WIDTH, game.WINDOW_HEIGHT, P3D);
		textureMode(NORMAL);

		try {
			this.game.loadLevel();
		} catch (Exception ex) {
			FileWriter fw;
			try {
				fw = new FileWriter("exception.txt", false);
				PrintWriter pw = new PrintWriter(fw);
				ex.printStackTrace(pw);
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void draw() {
		frameRate(32);
		background(255);

		try {
			this.game.hsrwLvl.drawLevel();
		} catch (Exception ex) {
			FileWriter fw;
			try {
				fw = new FileWriter("exception.txt", false);
				PrintWriter pw = new PrintWriter(fw);
				ex.printStackTrace(pw);
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void keyPressed() {
		this.game.keyPressed();
	}

	public void keyReleased() {
		this.game.keyReleased();
	}

	public void mouseClicked() {
		// this.game.app.loop();
	}
}
