package org.mrpgh.maze;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RectangularMaze implements IMaze {
	
	private IMazeGenerator mazeGenerator;
	private int[][] maze;
	private final static int DEFAULT_HEIGHT = 21;
	private final static int DEFAULT_WIDTH = 21;
	private int height;
	private int width;
	private Point startPoint;
	private Point finishPoint;

	public RectangularMaze() {
		this(DEFAULT_HEIGHT, DEFAULT_WIDTH);
	}

	public RectangularMaze(int height, int width) {
		if (height > 0 && width > 0) {
			this.height = height;
			this.width = width;
			maze = new int[this.height][this.width];
		} else {
			throw new IllegalArgumentException(
					"The height and width should be greater than Zero");
		}
	}
	
	@Autowired
	@Qualifier("rectangular")
	public void setMazeGenerator(IMazeGenerator mazeGenerator) {
		this.mazeGenerator = mazeGenerator;
	}
	
	public IMazeGenerator getMazeGenerator() {
		return this.mazeGenerator;
	}

	public int[][] getSize() {
		return maze;
	}

	@PostConstruct
	public void generateMaze() {
		mazeGenerator.createMaze(this);
		
		/**
		 * Below part can be done dynamically using random generator,however keeping 
		 * static for now.
		 */
		startPoint = new Point(0, 1);
		maze[0][1] = MazePosition.START.getInVal();
		finishPoint = new Point(height-1, width-2);
		maze[height - 1][width - 2] = MazePosition.FINISH.getInVal();
	}

	public long getTotalWalls() {
		long count = Arrays.stream(maze).flatMapToInt(x -> Arrays.stream(x))
				.filter(i -> i == 1).count();
		return count;

	}

	public long getTotalEmptySpaces() {
		long count = Arrays.stream(maze).flatMapToInt(x -> Arrays.stream(x))
				.filter(i -> i == 0).count();
		return count;
	}

	public MazePosition getPosition(Point point) {
		if (point.getY() > height - 1 || point.getX() > width - 1)
			return MazePosition.INVALID;
		else
			return MazePosition.getPosition(maze[point.getY()][point.getX()]);
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public Point getFinishPoint() {
		return finishPoint;
	}
}
