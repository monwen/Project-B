package com.revature.fixtures;

import com.revature.game.RoomManager;

public class Map extends Items{
	public Map(){
		super("Map",
				"Room map",
				"Room map"
				);
	}
	
	public void printMap(RoomManager rm) {
		
		Room[] roomList = rm.getRooms();
		
		System.out.println(" " +dashGen(true)+"    "+dashGen(true)+"    "+dashGen(true));
		System.out.println(horGen()+"  "+horGen()+"  "+horGen());
		System.out.println("|"+dashGenWithName(roomList[0].getName())+"    "+dashGenWithName(roomList[1].getName()) + "    " +dashGenWithName(roomList[2].getName())+ "|");
		System.out.println(dashGenWithPosition(roomList[0].isCurrent())+ "  "+ dashGenWithPosition(roomList[1].isCurrent())+ "  "+ dashGenWithPosition(roomList[2].isCurrent()));
		System.out.println("|" +dashGen(false)+"|  |"+dashGen(false)+"|  |"+dashGen(false)+ "|");
		
		System.out.println(" " +dashGen(false)+"    "+dashGen(false)+"    "+dashGen(false));
		System.out.println(horGen()+"  "+horGen()+"  "+horGen());
		System.out.println("|"+dashGenWithName(roomList[3].getName())+"    "+dashGenWithName(roomList[4].getName()) + "    " +dashGenWithName(roomList[5].getName())+ "|");
		System.out.println(dashGenWithPosition(roomList[3].isCurrent())+ "  "+ dashGenWithPosition(roomList[4].isCurrent())+ "  "+ dashGenWithPosition(roomList[5].isCurrent()));
		System.out.println("|" +dashGen(false)+"|  |"+dashGen(false)+"|  |"+dashGen(false)+ "|");
		
		System.out.println(" " +dashGen(false)+"    "+dashGen(false)+"    "+dashGen(false));
		System.out.println(horGen()+"  "+horGen()+"  "+horGen());
		System.out.println("|"+dashGenWithName(roomList[6].getName())+"    "+dashGenWithName(roomList[7].getName()) + "    " +dashGenWithName(roomList[8].getName())+ "|");
		System.out.println(dashGenWithPosition(roomList[6].isCurrent())+ "  "+ dashGenWithPosition(roomList[7].isCurrent())+ "  "+ dashGenWithPosition(roomList[8].isCurrent()));
		System.out.println("|" +dashGen(false)+"|  |"+dashGen(false)+"|  |"+dashGen(false)+ "|");
		
		System.out.println(" " +dashGen(false)+"    "+dashGen(false)+"    "+dashGen(false));
		System.out.println(horGen()+"  "+horGen()+"  "+horGen());
		System.out.println("|"+dashGenWithName(roomList[9].getName())+"    "+dashGenWithName(roomList[10].getName()) + "    " +dashGenWithName(roomList[11].getName())+ "|");
		System.out.println(dashGenWithPosition(roomList[9].isCurrent())+ "  "+ dashGenWithPosition(roomList[10].isCurrent())+ "  "+ dashGenWithPosition(roomList[11].isCurrent()));
		System.out.println("|" +dashGen(true)+"|  |"+dashGen(true)+"|  |"+dashGen(true)+ "|");
		
	}
	
	
	
	public static String dashGenWithName(String name) {
		StringBuilder s = new StringBuilder();
		int dashCount = 25 - name.length();
		int front = dashCount/ 2;
		if(dashCount % 2 != 0) {
			front +=1;
		}
//		System.out.println(front);
		int back = dashCount/ 2;
//		System.out.println(back);
		
		
		for(int i=0; i < front; i++) {
			s.append("-");
		}
		s.append(name);
		for(int i=0; i < back; i++) {
			s.append("-");
		}
		
		return s.toString();
	}
	
	public static String dashGen(boolean edge) {
		int dash = 25;
		StringBuilder s = new StringBuilder();
		if(edge) {
			s.append("_________________________");
		}else {
			s.append("___________  ____________");
		}
		return s.toString();
	}
	
	
	public static String dashGenWithPosition(boolean current) {
		int cap = 25;
		StringBuilder s = new StringBuilder();
		
		if(current) {
			String p = "|-------you are here------|";
			s.append(p);
		}else {
			s.append("|-------------------------|");
		}
		return s.toString();
	}
	public static String horGen() {
		return "|                         |";
	}
	
	
//	public static void main(String[] args) {
//		Map testMap = new Map();
//		RoomManager rm = new RoomManager(12);
//		testMap.printMap(rm);
//		
//
//
//		
//	}
}
