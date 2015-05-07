# Maze

User Story 1:
-------------

1) Maze is created on creation
2) The maze provide  numbers of walls and empty spaces for the users
3) Given a co ordinate maze provide what exists at that point.
	Possible position are
		WALL, EMPTY, START, FINISH, INVALID

User Story 2:
-------------

1) Inject default Rectangular maze when explorer is define, one can provide maze of choice
2) Provide method for movements like
	a) MoveTop
	b) MoveBottom
	c) MoveLeft
	d) MoveRight
	e) Get whats available to Left, Right, Bottom and Top from current position. Possible position are
		WALL, EMPTY, START, FINSIH and EMPTY
	d) Explorer will print output to console on exit

Assumption: 
	1) This just provide for maze creation and method for Explorer to traverse in the maze.
	2) The logic to traverse from START to END is not defined.
	3) MazeApplication load the sprint boot application, it dummy file just for loading. No futher processing
		happens here. Based on further requirement the logic will be rewritten.
	
	
How to run this project:

1) It is spring boot project using maven and java 8.
2) clone the project using git clone https://github.com/mohanrajpant/Maze.git
3) Then import the project as existing maven project in eclipse,Intellij or IDE of your choice
3) Right click on MazeApplication.java, it instantiate all the bean and print the maze onto the console.

4) Run command mvn clean test to run the junit and as well as it generate code coverage report. The report will be available in target/coverage-reports/ folder
