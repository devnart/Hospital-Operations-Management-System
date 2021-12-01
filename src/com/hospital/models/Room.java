package com.hospital.models;

import java.util.List;

public class Room {

	private int number;
	private int stage;

	public Room(){

	}
	public Room(int number,int stage) {
		this.number = number;
		this.stage = stage;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public Boolean isAvailable(int id, List<Room> roomList){
		for (Room room: roomList)
		{
			if(room.getNumber() == id) {
				 return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Room [number=" + number + ", stage=" + stage + "]";
	}
}
