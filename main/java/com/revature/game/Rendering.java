package com.revature.game;

import java.util.ArrayList;
import java.util.List;

import com.revature.fixtures.Map;
import com.revature.fixtures.Room;

public class Rendering {
	
	
public static void printMap(RoomManager rm) {
		
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
		System.out.println("");
		
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
	
	
	
	public static void actionRender(Room r) {
		StringBuilder breakLine = new StringBuilder();
		for(int i=0; i < 85; i++) {
			breakLine.append("-");
		}
		System.out.println(breakLine);
		StringBuilder tableTop = new StringBuilder(" ");
		for(int i=0; i < 83; i++) {
			tableTop.append("_");
		}
		tableTop.append(" ");
		System.out.println(tableTop);
		StringBuilder topsides = new StringBuilder("|");
		for(int i=0; i < 83; i++) {
			topsides.append(" ");
		}
		topsides.append("|");
	
		System.out.println(topsides);

		System.out.println(actionListGen(r));
		System.out.println(topsides);

		System.out.println(messageFormat(r.getLongDescription()));
		StringBuilder bottom =new StringBuilder("|");
		for(int i=0; i < 83; i++) {
			bottom.append("_");
		}
		bottom.append("|");
		
		System.out.println(topsides);
		System.out.println(bottom);
		
		
		
		
	}
	
	public static String actionListGen(Room r) {
		int cap = 85;
		StringBuilder s = new StringBuilder("|   ");
		
		
			s.append(r.getActionList().get(0) + ":[");
			if(r.getExits()[0] != null) {
				s.append("north ");
			}
			if(r.getExits()[1] != null) {
				s.append("east ");
			}
			if(r.getExits()[2] != null) {
				s.append("south ");
			}
			if(r.getExits()[3] != null) {
				s.append("west");
			}
	
		s.append("]");
		
		int diff = cap - s.length();
		if(diff <= cap) {
			for(int i=0; i < diff-1; i++) {
				s.append(" ");
			}
		}
		
		s.append("|");
		
		return s.toString();
	}
	
	public static List<String> messageBreak(String s, int cap) {
		String[] sl = s.split(" ");
	
		
		StringBuilder sb = new StringBuilder();
		List<String> rs = new ArrayList<String>();
		
		int ind =0;
	
		while(ind < sl.length) {
			if(sb.length()+ sl[ind].length() <= cap) {
				sb.append(sl[ind]+ " ");
			}else {
				rs.add(sb.toString());
				sb = new StringBuilder();
			}

				ind++;
		}
//		if(!rs.get(rs.size()-1).equals(sb.toString())) {
			rs.add(sb.toString());
//		}
		

		return rs;
		
	}
	
	public static String messageFormat(String s) {
		int cap = 85;
		StringBuilder sb = new StringBuilder("|   Message:[");
		
		List<String> ls = messageBreak(s, 50);
		int diff;
		
		for(String se : ls) {
			sb.append(se);
			
			diff = cap - sb.length();
			for(int i=0; i < diff-1; i++) {
				sb.append(" ");
			}
			sb.append("|");
			System.out.println(sb.toString());
			
			sb = new StringBuilder("|            ");
		}
		sb.append("]");
		
		diff = cap - sb.length();
		for(int i=0; i < diff-1; i++) {
			sb.append(" ");
		}
		
		sb.append("|");
		return sb.toString();
		
	}
	
	public static void render(RoomManager rm, Room r) {
		printMap(rm);
		actionRender(r);
	}
	
//	public static void main(String[] args) {
//
//		RoomManager rm = new RoomManager(12);
//		printMap(rm);
//		Room test = new Room();
//		test.setLongDescription("this is message box test. this is message box test. this is message box test. this is message bo test.");
//		actionRender(test);
//		
////		String ts = "hello hello hello hello ehllo eholjelj hslejlje hsleje ljsej l jsle lsej lj seje  hello ehllo ehllo heool";
////		List<String> sl = messageBreak(ts,85);
////		sl.forEach(x -> System.out.print(x + " "));
//	}
}
