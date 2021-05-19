package com.revature.fixtures;

import java.util.Arrays;

public class Room extends Fixture{
	Room[] exits;
	
	public Room() {
		super();
		this.exits = new Room[4];
	}
	
	public Room(String name, String s, String l) {
		super(name, s, l);
		this.exits = new Room[4];
	}
	
	public Room[] getExits() {
		return this.exits;
	}
	
	public Room getExit(String direction) {
		
		switch(direction) {
		case "north": return this.exits[0];
		case "east": return this.exits[1];
		case "south": return this.exits[2];
		case "west": return this.exits[3];
		default : System.out.println("please enter the correct format.");
		
		}
		
		
		return null;
	}
	
	public void setExits(Room[] adjacentRooms) {
		for(int i=0; i< exits.length;i++) {
			this.exits[i] = adjacentRooms[i];
		}
	}
	
	
	private String getNameForAdjacentRoom(Room r) {
		try {
			return r.getName();
		}catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public String toString() {
		
		return "Room [name=" + this.getName() + ", adjacent rooms: [" + getNameForAdjacentRoom(this.getExits()[0]) + ", " + getNameForAdjacentRoom(this.getExits()[1]) + ", " + getNameForAdjacentRoom(this.getExits()[2]) + ", " + getNameForAdjacentRoom(this.getExits()[3]) + "]]";
	}
	
}
