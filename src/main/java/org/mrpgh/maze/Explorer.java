package org.mrpgh.maze;

import java.util.function.Supplier;

import org.mrpgh.maze.IMaze;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Explorer implements IExplorer {
	private IMaze maze;
	private Point cordinates;
	private StringBuffer explorerPath = new StringBuffer("");

	@Autowired
	public void setMaze(IMaze maze) {
		this.maze = maze;
		cordinates = maze.getStartPoint();
		trackExplorerPath();
	}
	
	public IMaze getMaze() {
		return this.maze;
	}
	
	public Point getCordinates() {
		return this.cordinates;
	}

	public void moveTop() throws InvalidMoveException {
		move(() -> getTopPosition(), () -> {
			cordinates.setY(cordinates.getY() - 1);
			return cordinates;
		});
	}


	public void moveBottom() throws InvalidMoveException {
		move(() -> getBottomPostion(), () -> {
			cordinates.setY(cordinates.getY() + 1);
			return cordinates;
		});
	}

	public void turnLeft() throws InvalidMoveException {
		move(() -> getLeftPostion(), () -> {
			cordinates.setX(cordinates.getX() - 1);
			return cordinates;
		});
	}

	public void turnRight() throws InvalidMoveException {
		move(() -> getRightPostion(), () -> {
			cordinates.setX(cordinates.getX() + 1);
			return cordinates;
		});
	}

	private void move(Supplier<MazePosition> postion,
			Supplier<Point> updateCordinate) throws InvalidMoveException {
		switch (postion.get()) {
		case EMPTY:
		case START:
			updateCordinate.get();
			trackExplorerPath();
			break;
		case FINISH:
			updateCordinate.get();
			trackExplorerPath();
			printExplorerPath();
			break;
		default:
			throw new InvalidMoveException("This move is invalid");

		}
	}

	public MazePosition getTopPosition() {
		return maze.getPosition(new Point(cordinates.getY() - 1, cordinates.getX()));
	}

	public MazePosition getBottomPostion() {
		return maze.getPosition(new Point(cordinates.getY() + 1, cordinates.getX()));
	}

	public MazePosition getLeftPostion() {
		return maze.getPosition(new Point(cordinates.getY(), cordinates.getX() - 1));
	}

	public MazePosition getRightPostion() {
		return maze.getPosition(new Point(cordinates.getY(), cordinates.getX() + 1));
	}
	
	private void trackExplorerPath() {
		explorerPath.append("(" + cordinates.getY() + "," + cordinates.getX() + ")");

	}

	private void printExplorerPath() {
		System.out.println(explorerPath.toString());
	}

}
