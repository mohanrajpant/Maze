package org.mrpgh.maze;

public interface IExplorer {
	
	void setMaze(IMaze maze);
	IMaze getMaze();
	Point getCordinates();
	void moveTop() throws InvalidMoveException;
	void moveBottom() throws InvalidMoveException;
	void turnLeft() throws InvalidMoveException;
	void turnRight() throws InvalidMoveException;
	MazePosition getTopPosition();
	MazePosition getBottomPostion();
	MazePosition getLeftPostion();
	MazePosition getRightPostion();
}