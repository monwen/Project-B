package com.revature.game;

import java.util.Scanner;

import com.revature.fixtures.Room;

public class Main {
	public static void main(String[] args) {
		RoomManager rm = new RoomManager(12);
		System.out.println(rm);
		Player p = new Player(rm.getStartingRoom());
		printRoom(p);
		Scanner s = new Scanner(System.in);
		while(GameLoop.getGameON()) {
			try {
				Rendering.render(rm, p.getCurrentRoom());
				parse(collectInput(s), p);
			}catch(Exception e){
				System.out.println("parse error...");
			}
			
		}
	}
	
	public static void printRoom(Player p) {
		System.out.println("The player is now in " + p.getCurrentRoom().getName()+ ", " + p.getCurrentRoom().getShortDescription());
		System.out.println("");
		System.out.println(p.getCurrentRoom().getLongDescription());
	}
	
	public static String[] collectInput(Scanner s) {
		
		System.out.println("please input actions");
		try {
			String input = s.nextLine();
			return input.split(" ");
			
		}catch(Exception e) {
			System.out.println("Scanner error");
			return null;
		}
		
	}
	
	public static void parse(String[] input,  Player p) {
		String action = null;
		String target = null;
		System.out.println(input.length);
		try {
			action = input[0];
			System.out.println("action: " +action);
			if(input.length >1) {
				target = input[1];
				System.out.println("target: " +target);
			}
		}catch(Exception e){
			System.out.println("input error");
			return;
		}
		
		if(action.equals("go")) {
			Room currentRoom = p.getCurrentRoom();
			currentRoom.setCurrent(false);
			try {
				Room nextRoom = currentRoom.getExit(target);
				p.setCurrentRoom(nextRoom);
				System.out.println("The player is going to " + p.getCurrentRoom().getName()+ ".");
				printRoom(p);
			}catch(Exception e) {
				System.out.println("target error");
			}
		}
		
		if(action.equals("exit")) {
			GameLoop.setGameON();
			System.out.println("Exiting game...");
			System.out.println("Thank you for playing");
		}
	}
}
