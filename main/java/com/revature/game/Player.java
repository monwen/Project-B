package com.revature.game;
import com.revature.fixtures.Room;

public class Player {
	Room currentRoom;
	
	public Player(Room r) {
		this.currentRoom = r;
	}
	
	public Room getCurrentRoom() {
		return this.currentRoom;
	}
	public void setCurrentRoom(Room r) {
		this.currentRoom = r;
		r.setCurrent(true);
	}
}
