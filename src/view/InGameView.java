package view;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.state.StateBasedGame;

import model.Game;
import model.InGame;
import model.MoveableBox;
import model.Spikes;
import model.StatusBar;

/**
 * 	Visar upp World & StatusBar.
 */
public class InGameView {
	private InGame inGame;
	private WorldView worldView;
	private StatusBarView statusBarView;
	private CharacterView characterView;
	private ArrayList<MoveableBoxView> moveableBoxViewList;
	private ArrayList<SpikesView> spikesViewList;
	private Animation nelson, blink;
	private Graphics g;

	public InGameView(InGame inGame, WorldView worldView, StatusBarView statusBarView, CharacterView characterView, ArrayList<MoveableBoxView> tmpMoveableBoxViewList, ArrayList<SpikesView> spikesViewList) {
		this.inGame = inGame;
		this.worldView = worldView;
		this.statusBarView = statusBarView;
		this.characterView = characterView;
		this.moveableBoxViewList = tmpMoveableBoxViewList;
		this.spikesViewList = spikesViewList;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		this.g = g;
		//draw character
		this.g.setColor(characterView.getColor());
		this.g.fill(characterView.getSlickShape());
		Image background = new Image("pics/rainbow.jpg"); //Will be get from the Multimedia class later
		background.draw();
		worldView.getBlockMapView().getTiledMap().render(0, 0);
		//draw candyMonsters
		for (int j = 0; j < worldView.getCandyMonsterViewList().size(); j++) {
			this.g.setColor(worldView.getCandyMonsterViewList().get(j).getColor());
			this.g.fill(worldView.getCandyMonsterViewList().get(j).getShape());
		}	
		//draw spikes
		for (int j = 0; j < spikesViewList.size(); j++) {
			//set the color when "debugging"
			g.setColor(Color.transparent); //so it does not show the circle
			g.fill(spikesViewList.get(j).getShape());
			g.drawImage(spikesViewList.get(j).getImage(), 
					spikesViewList.get(j).getSpikes().getX()- Spikes.RADIUS - 3, 
					spikesViewList.get(j).getSpikes().getY() - Spikes.RADIUS - 3);
		}
		characterView.getImage().draw(characterView.getSlickShape().getX(), characterView.getSlickShape().getY());
		for (MoveableBoxView moveableBoxView : moveableBoxViewList) {
			g.drawImage(moveableBoxView.getImage(), moveableBoxView.getMoveableBox().getPos().getX()-MoveableBox.HALF_WIDTH,
					moveableBoxView.getMoveableBox().getPos().getY()-MoveableBox.HALF_HEIGHT+1); // +1 is to correct position which
																							// probably is rounded incorrectly
		}
		

		/* blinking animation - not yet working 
		Image[] blinking = {new Image("pics/Nelson.png"), new Image("pics/GulNelson.png")};
		int duration[] = {300, 300};
		blink = new Animation(blinking, duration, true);
		nelson = blink;
		nelson.draw(characterView.getSlickShape().getX(), characterView.getSlickShape().getY());*/


		//draw items
		for (int j = 0; j < worldView.getItemViewList().size(); j++) {
			this.g.setColor(worldView.getItemViewList().get(j).getColor());
			this.g.fill(worldView.getItemViewList().get(j).getShape());
		}
		//draw a temporary timer
		this.g.drawString("Time : " + this.inGame.getTime(), 10, 25);

		//draw status bar
		for(int k = 0; k < characterView.getCharacter().getLife(); k++) {
			statusBarView.getHeart()[k].draw(StatusBar.HEART_POSX[k], StatusBar.HEART_POSY);
		}
		this.g.setColor(Color.white);
		this.g.drawString("LIFE", StatusBar.HEART_POSX[0] - 15, StatusBar.HEART_POSY - 20);
		this.g.drawString("TIME", StatusBar.FIXED_BAR_POSX - 15, StatusBar.HEART_POSY - 20);
		this.g.setColor(Color.darkGray);
		this.g.fill(statusBarView.getFixedBar());
		this.g.setColor(Color.green);
		this.g.fill(statusBarView.getTimeBar());

	}
	/**Save all graphics in an Image to create an illusion of a paused screen in PauseView
	 * @throws SlickException */
	public void createPauseImage() throws SlickException {
		Image pauseImage = new Image(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
		this.g.copyArea(pauseImage, 0, 0);
		ImageOut.write(pauseImage.copy(), "pics/pauseBackground.png", false);
		pauseImage.destroy();
	}


}
