package com.revature.game;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.revature.fixtures.Room;

public class RoomManager {
	private Room startingRoom;
	private Room[] rooms;
	
	public RoomManager(int roomSize){
		this.rooms = new Room[roomSize];
		this.init();
	}
	
	
	public void init() {
		
		// creating rooms;
		Room foyer = new Room(
				"The Foyer",
				"a small foyer",
				"The small entry way of a neo-colonial house. A dinining room is open to the south, where a large table can be seen."
				);
		foyer.setIndex(new ArrayList<Integer>(Arrays.asList(7)));
		
		
		Room library = new Room(
				"the Library",
				"a small library",
				"a small library located to the north of the bedroom1 and east of the kitchen."	
				);	
		library.setIndex(new ArrayList<Integer>(Arrays.asList(5)));
		
		
		Room bedroom1 = new Room(
				"the Bedroom",
				"a small cozy bedroom",
				"a small cozy bedroom located to the east of the foyer."
				);
		bedroom1.setIndex(new ArrayList<Integer>(Arrays.asList(8)));

		Room outside = new Room(
				"Outside",
				"outside the house",
				"outside the house"
				);
		outside.setIndex(new ArrayList<Integer>(Arrays.asList(9,10,11)));
		
		Room bathroom = new Room(
				"The Bathroom",
				"a small bathroom",
				"a small bathrrom with toilet and bathtub."
				);
		bathroom.setIndex(new ArrayList<Integer>(Arrays.asList(6)));
		
		Room bedroom2 = new Room(
				"the Bedroom",
				"a small cozy bedroom",
				"a small cozy bedroom located to the west of the foyer and north of the bathroom"
				);
		bedroom2.setIndex(new ArrayList<Integer>(Arrays.asList(3)));
		
		Room kitchen = new Room(
				"The kitchen",
				"a small kitchen",
				"a small kitch with a round kitchen table, refrigerator, and a small stove"
				);
		kitchen.setIndex(new ArrayList<Integer>(Arrays.asList(4)));
		
		Room entertainmentCenter = new Room(
				"The Entertainment Center",
				"a large entertainment center",
				"a large entertainment center with a cozy sofa, 100 8k TV, a pinpong table and a footsball table."
				);

		entertainmentCenter.setIndex(new ArrayList<Integer>(Arrays.asList(0,1,2)));
//		System.out.println(entertainmentCenter.getIndex());
		
		//loading adjacent room
		adjacentRoomLoader(foyer, kitchen, bedroom1,outside,bathroom);
		adjacentRoomLoader(bedroom1, library, null,outside,foyer);
		adjacentRoomLoader(bathroom, bedroom2, foyer,outside,null);
		adjacentRoomLoader(library, entertainmentCenter, null,bedroom1,kitchen);
		adjacentRoomLoader(kitchen, entertainmentCenter, library,foyer,bedroom2);
		adjacentRoomLoader(bedroom2, entertainmentCenter, kitchen,bathroom,null);
		adjacentRoomLoader(entertainmentCenter, null, null,kitchen,null);
		
		
		//loading room into rooms
		foyer.getIndex().forEach(x -> this.rooms[x] = foyer);
		bedroom1.getIndex().forEach(x -> this.rooms[x] = bedroom1);
		bathroom.getIndex().forEach(x -> this.rooms[x] = bathroom);
		library.getIndex().forEach(x -> this.rooms[x] = library);
		kitchen.getIndex().forEach(x -> this.rooms[x] = kitchen);
		bedroom2.getIndex().forEach(x -> this.rooms[x] = bedroom2);
		entertainmentCenter.getIndex().forEach(x -> this.rooms[x] = entertainmentCenter);
		outside.getIndex().forEach(x -> this.rooms[x] = outside);
//		System.out.println(this.getRooms()[0]);
		
		//set starting room
		this.startingRoom = foyer;
		foyer.setCurrent(true);
		
	}
	private void adjacentRoomLoader(Room currentRoom, Room n, Room e, Room s, Room w) {
		Room[] adjacentRooms = {n, e,s,w};
		currentRoom.setExits(adjacentRooms);
		
	}
	
	
	public Room getStartingRoom() {
		return startingRoom;
	}


	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}


	public Room[] getRooms() {
		return rooms;
	}


	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}


	@Override
	public String toString() {
		StringBuilder totalRoom = new StringBuilder("");
		
		for(Room r : this.getRooms()) {
			totalRoom.append(r.getName()+ ", ");
		}
		
		return "starting room: [" + this.startingRoom.getName() +"], total rooms: [" + totalRoom.toString() + "] ";
	}
	

}
