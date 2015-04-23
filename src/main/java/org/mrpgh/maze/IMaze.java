package org.mrpgh.maze;

public interface IMaze {
	void setMazeGenerator(IMazeGenerator generator);
	IMazeGenerator getMazeGenerator();
	int[][] getSize();
	long getTotalWalls();
	long getTotalEmptySpaces();
	void generateMaze();
	MazePosition getPosition(Point point);
	Point getStartPoint();
	Point getFinishPoint();
}
