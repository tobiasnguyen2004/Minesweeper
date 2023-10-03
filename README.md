# Minesweeper

- Board.java: This class focuses on creating the game board which contains
the proper numerical values/set conditions. In this file we have the standard
setters and getter functions, as well as the three sections that contain algorithms
that are the constructor (2nd), addBombs, and numSurroundingBombs.

    - I will create a algorithm that can determine the position of each item like
so, knowing that the board is 16x16:
        - The x-coordinate will be: (cell value) / 16
        - The y-coordinate will be: (cell value) % 16
        - For example, cell 5 will be in row 0 (5/16 = 0) and column 5 (5%16 = 5)
    - Because in my version of minesweeper, the board is only a 16x16, the
coordinates are between 0 and 15. Also, by default, the number of bombs is
set to 30.

- Cell.java: This class focuses on each individual cell of Minesweeper's grid.
The cell itself only contains some variables that shows the values and state
of the cell, like visibility and whether it is flagged, as well as some setter
and getter functions.

- GameCourt.java This class holds the primary game logic for how the different
buttons, cells, and bombs interact with one another. Most of the functions cover
the main logic of the game, like how to find out how many bombs are next to a
particular cell. They also depend and rely closely on each other, which makes
re-using some functions really easy and some only gets used once.

- Move.java: This class focuses on storing any move the player makes. To do so,
it must know the coordinates of the affected cell and the type of move. We can
define the type of moves like so:
  - 0 = Player reveals a cell
  - 1 = Player flags a cell
  - 2 = Player unflags a cell

- Game.java: The class is the main Game class that specifies the frame and widgets
of the GUI. I modeled the control panel after MushroomOfDoom, so it is mostly
similar to that file, except this one is more complicated and has more features.

- GameTest.java: This file has all the tests for all of my files, including
Cell, Board, GameCourt, and Move.
