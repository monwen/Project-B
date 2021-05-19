package com.revature.game;

import com.revature.fixtures.Room;

public class RoomManager {
	Room startingRoom;
	Room[] rooms;
	
	RoomManager(){
		rooms = new Room[7];
		this.init();
	}
	
	
	public void init() {
		// creating rooms;
		Room foyer = new Room(
				"The Foyer",
				"a small foyer",
				"The small entry way of a neo-colonial house. A dinining room is open to the south, where a large table can be seen."
				);
		
		Room library = new Room(
				"the Library",
				"a small library",
				"a small library located to the north of the bedroom1 and east of the kitchen."	
				);	
		Room bedroom1 = new Room(
				"the Bedroom",
				"a small cozy bedroom",
				"a small cozy bedroom located to the east of the foyer."
				);

		Room outside = new Room(
				"Outside",
				"outside the house",
				"outside the house"
				);
		
		Room bathroom = new Room(
				"The Bathroom",
				"a small bathroom",
				"a small bathrrom with toilet and bathtub."
				);
		
		Room bedroom2 = new Room(
				"the Bedroom",
				"a small cozy bedroom",
				"a small cozy bedroom located to the west of the foyer and north of the bathroom"
				);
		
		Room kitchen = new Room(
				"The kitchen",
				"a small kitchen",
				"a small kitch with a round kitchen table, refrigerator, and a small stove"
				);
		
		Room entertainmentCenter = new Room(
				"The Entertainment Center",
				"a large entertainment center",
				"a large entertainment center with a cozy sofa, 100 8k TV, a pinpong table and a footsball table."
				);
		
		//loading adjacent room
		adjacentRoomLoader(foyer, kitchen, bedroom1,outside,bathroom);
		adjacentRoomLoader(bedroom1, library, null,outside,foyer);
		adjacentRoomLoader(bathroom, bedroom2, foyer,outside,null);
		adjacentRoomLoader(library, entertainmentCenter, null,bedroom1,kitchen);
		adjacentRoomLoader(kitchen, entertainmentCenter, library,foyer,bedroom2);
		adjacentRoomLoader(bedroom2, entertainmentCenter, kitchen,bathroom,null);
		adjacentRoomLoader(entertainmentCenter, null, null,kitchen,null);
		
		
		//loading room into rooms
		this.rooms[0] = foyer;
		this.rooms[1] = bedroom1;
		this.rooms[2] = bathroom;
		this.rooms[3] = library;
		this.rooms[4] = kitchen;
		this.rooms[5] = bedroom2;
		this.rooms[6] = entertainmentCenter;
		
		//set starting room
		this.startingRoom = foyer;
		
	}
	private void adjacentRoomLoader(Room currentRoom, Room n, Room e, Room s, Room w) {
		Room[] adjacentRooms = {n, e,s,w};
		currentRoom.setExits(adjacentRooms);
		
	}
	
	
	@Override
	public String toString() {
		StringBuilder totalRoom = new StringBuilder("");
		
		for(int i = 0 ; i < rooms.length; i++) {
			if(i == rooms.length-1) {
				totalRoom.append(this.rooms[i].getName());
			}else {
				totalRoom.append(this.rooms[i].getName()+ ", ");
			}
			
		}
		
		return "starting room: [" + this.startingRoom.getName() +"], total rooms: [" + totalRoom.toString() + "] ";
	}
	

}
