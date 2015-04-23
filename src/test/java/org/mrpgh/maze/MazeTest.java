package org.mrpgh.maze;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import  static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MazeTestConfig.class)
public class MazeTest {

	@Autowired
	@Qualifier("withConstructor")
	private IMaze maze;
	
	@Test
	public void checkMazeNotNull () {
		assertNotNull(maze);
	}
	
	@Test
	public void checkMazeGeneratorisNotNull() {
		assertNotNull(maze.getMazeGenerator());	
	}
	
	@Test
	public void testSizeOfMaze() {
		assertEquals("The length does not match", 11, maze.getSize().length);
	}
	
	@Test
	public void testStartPointMatch() {
		Point point = maze.getStartPoint();
		assertEquals("The starting point does not match", MazePosition.START,
				maze.getPosition(point));
	}
	
	@Test
	public void testFinishPointMatch() {
		Point point = maze.getFinishPoint();
		assertEquals("The starting point does not match", MazePosition.FINISH,
				maze.getPosition(point));
	}
	
	@Test
	public void testTotalEmptySpacesAndTotalWalls() {
		int totalWalls = (int) maze.getTotalWalls();
		int totalEmptySpaces = (int) maze.getTotalEmptySpaces();
		
		assertEquals("The total size of walls, empty space, start and finish point should match"
				+ " the size of maze", 11*11, totalWalls + totalEmptySpaces + 2);
	}

}
