package org.mrpgh.maze;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("rectangular")
public class RectangularMazeGenerator implements IMazeGenerator {

	private int[][] maze;
	private int height;
	private int width;
	public void createMaze(IMaze imaze) {
		this.maze = imaze.getSize();
		this.height = maze.length;
		this.width = maze[0].length;

		for (int[] row : maze)
			Arrays.fill(row, 1);
		maze[1][1] = 0;
		carveMaze(1, 1);		
	}
	
	private void carveMaze(int x, int y) {
		int empty = MazePosition.EMPTY.getInVal();
		int wall = MazePosition.WALL.getInVal();

		double generated = Math.random();
		int randomInt = (int) (generated * 4);
		int count = 0;
		int x1, y1, x2, y2 = 0;
		while (count < 4) {
			switch (randomInt) {
			case 0:
				x1 = x + 1;
				y1 = y + 0;
				x2 = x + 2;
				y2 = y + 0;
				if (x2 > 0 && x2 < width && y2 > 0 && y2 < height) {
					if (maze[y1][x1] == wall && maze[y2][x2] == wall) {
						maze[y1][x1] = empty;
						maze[y2][x2] = empty;
						carveMaze(x2, y2);
					}
				}
				break;
			case 1:
				x1 = x + 0;
				y1 = y + 1;
				x2 = x + 0;
				y2 = y + 2;
				if (x2 > 0 && x2 < width && y2 > 0 && y2 < height) {
					if (maze[y1][x1] == wall && maze[y2][x2] == wall) {
						maze[y1][x1] = empty;
						maze[y2][x2] = empty;
						carveMaze(x2, y2);
					}
				}
				break;
			case 2:
				x1 = x - 1;
				y1 = y + 0;
				x2 = x - 2;
				y2 = y + 0;
				if (x2 > 0 && x2 < width && y2 > 0 && y2 < height) {
					if (maze[y1][x1] == wall && maze[y2][x2] == wall) {
						maze[y1][x1] = empty;
						maze[y2][x2] = empty;
						carveMaze(x2, y2);
					}
				}
				break;
			case 3:
				x1 = x + 0;
				y1 = y - 1;
				x2 = x + 0;
				y2 = y - 2;
				if (x2 > 0 && x2 < width && y2 > 0 && y2 < height) {
					if (maze[y1][x1] == wall && maze[y2][x2] == wall) {
						maze[y1][x1] = empty;
						maze[y2][x2] = empty;
						carveMaze(x2, y2);
					}
				}
				break;
			}
			count += 1;
			randomInt = (randomInt + 1) % 4;

		}
	}
}
