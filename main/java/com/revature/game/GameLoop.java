package com.revature.game;

public class GameLoop {
	private static boolean gameON = true;
	
	public static boolean getGameON() {
		return gameON;
	}
	public static void setGameON() {
		gameON = !gameON;
	}
	
}
