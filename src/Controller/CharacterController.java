package controller;


import model.Character;

import org.newdawn.slick.Color;
import org.newdawn.slick.Input;

import view.CharacterView;


public class CharacterController {
	private InGameController inGameController;
	private Character character;
	private CharacterView characterView;

	/*Default keyvalues*/
	private int keyRight = Input.KEY_RIGHT;
	private int keyLeft = Input.KEY_LEFT;
	private int keyDown = Input.KEY_DOWN;
	private int keyUp = Input.KEY_UP;
	
	public CharacterController(InGameController inGameController) {
		this.inGameController = inGameController;
		this.character = new Character(400, 300);
		this.characterView = new CharacterView(character);
	}
	
	public Character getCharacter() {
		return character;
	}

	public CharacterView getCharacterView() {
		return characterView;
	}

	/*Getters for keypresses*/
	public int getKeyRight() {
		return this.keyRight;
	}
	
	public int getKeyLeft() {
		return this.keyLeft;
	}
	
	public int getKeyUp() {
		return this.keyUp;
	}
	
	public int getKeyDown() {
		return this.keyDown;
	}
	
	/*Setters for keypresses*/
	public void setKeyRight(int keyRight) {
		this.keyRight = keyRight;
	}
	
	public void setKeyLeft(int keyLeft) {
		this.keyLeft = keyLeft;
	}
	
	public void setKeyUp(int keyUp) {
		this.keyUp = keyUp;
	}
	
	public void setKeyDown(int keyDown) {
		this.keyDown = keyDown;
	}
	
	/*Check the key pressed matches the right key*/
	
	public boolean isControllerRight(int key) {
		return this.keyRight == key;
	}
	
	public boolean isControllerLeft(int key) {
		return this.keyLeft == key;
	}
	
	public boolean isControllerUp(int key) {
		return this.keyUp == key;
	}
	
	public boolean isControllerDown(int key) {
		return this.keyUp == key;
	}
		
	//check which key is pressed
	//borde event-anropas från vyn
	public void keyPressedUpdate() {
		
		if(isControllerRight(Input.ANY_CONTROLLER)) {
			characterView.setColor(Color.blue);
		}
		if(isControllerLeft(Input.ANY_CONTROLLER)) {
			characterView.setColor(Color.green);
		}
		if(isControllerDown(Input.ANY_CONTROLLER)) {
			//plocka upp ett item TODO
		}
		if(isControllerUp(Input.ANY_CONTROLLER)) {
			//hoppa TODO
		}
	}
}
