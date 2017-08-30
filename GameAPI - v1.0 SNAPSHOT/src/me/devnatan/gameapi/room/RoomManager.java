package me.devnatan.gameapi.room;

import java.util.HashSet;
import java.util.Set;

public class RoomManager {

	private static final Set<Room> rooms = new HashSet<Room>();
	
	public Set<Room> getRooms() {
		return rooms;
	}
	
	public Room getById(int id) {
		for(Room room : rooms) {
			if(room.getId() == id) return room;
		} return null;
	}
	
	public Room[] getByName(String name) {
		Room[] rooms = new Room[0];
		
		int i = 0;
		while(getRooms().iterator().hasNext()) {
			rooms[i] = getRooms().iterator().next();
			i++;
		}
		
		return rooms;
	}
	
	public boolean hasRoom(int id) {
		return getById(id) != null;
	}
	
	public boolean hasRoom(String name) {
		return getByName(name).length > 0;
	}
	
}
