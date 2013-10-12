package view;

import java.awt.Font;

import model.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;
/**
 * 
 * @author Josefin, Martin, Sara, Kino
 *
 */
public class NewHighscoreView {
	final private TextField textField;
	final private TrueTypeFont font;
	private int score;
	private final int POSX = Game.WINDOW_WIDTH/5;
	private Image bg;
	
	public NewHighscoreView(final GameContainer gc, final int score) {
		this.font = new TrueTypeFont(new Font(Font.MONOSPACED, Font.BOLD, 50), false);
		this.textField = new TextField(gc, font, POSX + 330, Game.WINDOW_HEIGHT/2, 300, font.getHeight() + 5);
		this.textField.setMaxLength(8);
		textField.setBorderColor(Color.transparent);
		this.score = score;
		try {
			bg = new Image("pics/pink_background.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {		
		bg.draw();
		g.setFont(font);
		g.setColor(new Color(255,224,244));
		g.drawString(" Nytt rekord: " + this.score + "! ", POSX, Game.WINDOW_HEIGHT/4);
		g.drawString("Skriv namn:", POSX, Game.WINDOW_HEIGHT/2);
		this.textField.render(gc, g);
	}

	public TextField getTextField() {
		return textField;
	}
	
	public void reset(int score) {
		this.score = score;
		textField.setText("");
	}
}