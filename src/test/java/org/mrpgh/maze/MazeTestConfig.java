package org.mrpgh.maze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MazeTestConfig {

	public static void main(String[] args) {
		SpringApplication.run(MazeTestConfig.class, args);
	}

	@Bean(name = "withConstructor")
	public RectangularMaze maze() {
		return new RectangularMaze(11, 11);
	}
}
