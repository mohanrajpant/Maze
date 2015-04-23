package org.mrpgh.maze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MazeTestConfig.class)
public class ExplorerTest {

	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

	@Autowired
	private Explorer explorer;

	@Mock
	private Explorer explorerMock;

	@Mock
	private IMaze mazeMock;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testExplorerNotNull() {
		assertNotNull(explorer);
	}

	@Test
	public void testExplorerMazeNotNull() {
		assertNotNull(explorer.getMaze());
	}

	@Test
	public void test_valid_move_update_the_postion_correctly_for_wall()
			throws InvalidMoveException {
		when(mazeMock.getStartPoint()).thenReturn(new Point(10, 10));
		explorer.setMaze(mazeMock);
		when(mazeMock.getPosition(any(Point.class))).thenReturn(
				MazePosition.EMPTY);

		explorer.moveTop();
		assertEquals(9, explorer.getCordinates().getY());

		explorer.moveBottom();
		assertEquals(10, explorer.getCordinates().getY());

		explorer.turnLeft();
		;
		assertEquals(9, explorer.getCordinates().getX());

		explorer.turnRight();
		assertEquals(10, explorer.getCordinates().getX());

	}

	@Test
	public void void_test_print_explorer_path() throws InvalidMoveException {

		when(mazeMock.getStartPoint()).thenReturn(new Point(10, 10));
		when(mazeMock.getFinishPoint()).thenReturn(new Point(11, 11));
		explorer.setMaze(mazeMock);
		when(mazeMock.getPosition(any(Point.class))).thenReturn(
				MazePosition.EMPTY);
		explorer.moveBottom();
		when(mazeMock.getPosition(any(Point.class))).thenReturn(
				MazePosition.FINISH);
		explorer.turnRight();
		assertTrue(
				"The explorer path should contain above cordinates at the end ",
				log.getLog().trim().endsWith("(10,10)(11,10)(11,11)"));

	}

	@Test(expected = InvalidMoveException.class)
	public void test_invalid_move_to_top_throws_Exception()
			throws InvalidMoveException {
		when(mazeMock.getStartPoint()).thenReturn(new Point(10, 10));
		explorer.setMaze(mazeMock);
		verify(mazeMock, times(1)).getStartPoint();
		when(mazeMock.getPosition(any(Point.class))).thenReturn(
				MazePosition.INVALID);
		explorer.moveTop();
	}

	@Test(expected = InvalidMoveException.class)
	public void test_invalid_move_to_Bottom_throws_Exception()
			throws InvalidMoveException {
		when(mazeMock.getStartPoint()).thenReturn(new Point(10, 10));
		explorer.setMaze(mazeMock);
		verify(mazeMock, times(1)).getStartPoint();
		when(mazeMock.getPosition(any(Point.class))).thenReturn(
				MazePosition.INVALID);
		explorer.moveBottom();
	}

	@Test(expected = InvalidMoveException.class)
	public void test_invalid_turn_to_left_throws_Exception()
			throws InvalidMoveException {
		when(mazeMock.getStartPoint()).thenReturn(new Point(10, 10));
		explorer.setMaze(mazeMock);
		verify(mazeMock, times(1)).getStartPoint();
		when(mazeMock.getPosition(any(Point.class))).thenReturn(
				MazePosition.INVALID);
		explorer.turnLeft();
	}

	@Test(expected = InvalidMoveException.class)
	public void test_invalid_turn_to_right_throws_Exception()
			throws InvalidMoveException {
		when(mazeMock.getStartPoint()).thenReturn(new Point(10, 10));
		explorer.setMaze(mazeMock);
		verify(mazeMock, times(1)).getStartPoint();
		when(mazeMock.getPosition(any(Point.class))).thenReturn(
				MazePosition.INVALID);
		explorer.turnRight();
	}

}
