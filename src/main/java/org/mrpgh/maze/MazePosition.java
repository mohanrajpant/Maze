package org.mrpgh.maze;

public enum MazePosition {
	
	EMPTY(0, " "),
	WALL(1, "X"),
	START(2, "S"),
	FINISH(3, "F"),
	INVALID(-1, "INVALID");

	private int intVal;
	private String stringVal;
	
	MazePosition(int intVal, String stringVal) {
		this.intVal = intVal;
		this.stringVal = stringVal;
	}
	
	public int getInVal() {
		return intVal;
	}
	
	public String getStringVal() {
		return stringVal;
	}

	public static MazePosition getPosition(int intVal) {
		switch (intVal) {
		case 0:
			return MazePosition.EMPTY;
		case 1:
			return MazePosition.WALL;
		case 2:
			return MazePosition.START;
		case 3:
			return MazePosition.FINISH;
		default:
			return MazePosition.INVALID;
		}
	}
}
