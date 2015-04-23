package org.mrpgh.maze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MazeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MazeApplication.class,
				args);
		RectangularMaze maze = ctx.getBean(RectangularMaze.class);
		maze.generateMaze();
		MazeLayoutPrinter printer = ctx.getBean(MazeLayoutPrinter.class);
		printer.printMazeLayoutToConsole(maze.getSize());
	}
}
