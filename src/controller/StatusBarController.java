package controller;

import org.newdawn.slick.SlickException;

import view.StatusBarView;

public class StatusBarController {

	private StatusBarView statusBarView;
	public StatusBarController(InGameController inGameController) throws SlickException {
		statusBarView = new StatusBarView();
		
	}

	public StatusBarView getStatusBarView() {
		return statusBarView;
	}
	
	
}
