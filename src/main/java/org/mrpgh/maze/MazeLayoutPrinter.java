package org.mrpgh.maze;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class MazeLayoutPrinter {
	
	public void printMazeLayoutToConsole(int[][] maze) {
		if(maze != null) {
			Arrays.stream(maze).forEach(row -> {
				System.out.print("\n");
				Arrays.stream(row).forEach(block -> {
					System.out.print(MazePosition.getPosition(block).getStringVal());
				});
			});
			System.out.println("");
		
		}
	}
}
