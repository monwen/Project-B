package com.revature.fixtures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room extends Fixture{
	private Room[] exits;
	private List<Integer> index;
	private boolean isCurrent;
	private List<String> actionList;
	
	public Room() {
		super();
		this.exits = new Room[4];
		this.isCurrent = false;
		this.actionList = new ArrayList(Arrays.asList("go"));
	}
	
	public Room(String name, String s, String l) {
		super(name, s, l);
		this.exits = new Room[4];
		this.isCurrent = false;
		this.actionList = new ArrayList(Arrays.asList("go"));
		
	}
	

	public List<String> getActionList() {
		return actionList;
	}

	public void setActionList(List<String> actionList) {
		this.actionList = actionList;
	}

	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}

	public List<Integer> getIndex() {
		return index;
	}

	public void setIndex(List<Integer> index) {
		this.index = index;
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
