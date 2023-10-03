package org.cis1200.minesweeper;

import java.util.Random;

/**
 * This class focuses on creating the game board which contains the proper
 * numerical values/set conditions. In this file we have the standard setters
 * and getter functions, as well as the three sections that contain algorithms
 * that are the constructor (2nd), addBombs, and numSurroundingBombs.
 *
 * I will create a algorithm that can determine the position of each item like
 * so, knowing that the board is 16x16:
 * - The x-coordinate will be: (cell value) / 16
 * - The y-coordinate will be: (cell value) % 16
 * For example, cell 5 will be in row 0 (5/16 = 0) and column 5 (5%16 = 5)
 *
 * Because in my version of minesweeper, the board is only a 16x16, the
 * coordinates are between 0 and 15. Also, by default, the number of bombs is
 * set to 30.
 */

public class Board {
    private int rows = 16;
    private int columns = 16;
    private int totalBombs = 30;
    private Cell[][] currentBoard;

    /**
     * Default constructor. If nothing is specified, create and initialize a random
     * board.
     */
    public Board() {
        currentBoard = new Cell[rows][columns];
        initializeBoard();
    }

    /**
     * Overloaded constructor. Takes in a string representation of a board state
     * (state that contains the numerical values, not the visibility and flag
     * status)
     * and creates a board.
     * 
     * @param stringBoard
     */
    public Board(String stringBoard) {
        if (stringBoard == null || stringBoard.length() != rows * columns) {
            throw new IllegalArgumentException();
        }

        currentBoard = new Cell[rows][columns];
        for (int i = 0; i < 256; i++) {
            currentBoard[i / 16][i % 16] = new Cell(
                    i / 16, i % 16,
                    Integer.parseInt(stringBoard.substring(0, 1))
            );
            stringBoard = stringBoard.substring(1);
        }
    }

    /**
     * Initializes the board by calling the two functions in order (since addNumbers
     * relies on addBombs)
     */
    public void initializeBoard() {
        addBombs();
        addNumbers();
    }

    /**
     * Uses a random number generator to determine placements of bombs in 30
     * unique positions
     */
    public void addBombs() {
        Random r = new Random();

        int tempCountBombs = 0;
        while (tempCountBombs < totalBombs) {
            int index = r.nextInt(rows * columns);

            // Checks to make sure that randomly generated position isn't already taken
            if (currentBoard[index / rows][index % rows] == null) {
                currentBoard[index / rows][index % rows] = new Cell(
                        index / rows,
                        index % rows, 9
                );
                tempCountBombs++;
            }
        }
    }

    /**
     * Add the numbers of the cells after bombs are added. Only provides numerical
     * count for cells that aren't bombs (not 9). 0s are not shown.
     */
    public void addNumbers() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (currentBoard[i][j] == null) {
                    currentBoard[i][j] = new Cell(i, j, numSurroundingBombs(i, j));
                }
            }
        }
    }

    /**
     * Take in any cell on the board, return the number of surrounding bombs (0-8).
     * 
     * @param x the x coordinate of the cell
     * @param y the y coordinate of the cell
     * @return the number of bombs surrounding the cell (0-8)
     * @throws IllegalArgumentException if given coordinate is invalid
     */

    public int numSurroundingBombs(int x, int y) {

        if (x < 0 || y < 0 || x >= rows || y >= columns) {
            throw new IllegalArgumentException();
        }

        int currentBombCount = 0;

        /**
         * Iterate over the 3x3 block (excluding the cell in question) that has the
         * given cell as the center. If the value of that cell is 9, increase the
         * number of surrounding bomb count by one.
         */
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if ((i != x || j != y) && i >= 0 && j >= 0 && i < rows && j < columns) {
                    if (currentBoard[i][j] != null && currentBoard[i][j].getValue() == 9) {
                        currentBombCount++;
                    }

                }
            }
        }

        return currentBombCount;
    }

    /**
     * Getter function returning whether the cell is a bomb.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return boolean representing whether the cell is a bomb
     */
    public boolean isBomb(int x, int y) {
        return (currentBoard[x][y].getValue() == 9);
    }

    /**
     * Getter function returning the numerical value of the cell (0-9)
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return number value of the cell
     */
    public int getNumOfCell(int x, int y) {
        return (currentBoard[x][y].getValue());
    }

    /**
     * Getter function returning whether or not cell is visible (clicked).
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return boolean representing whether or not cell is visible
     */
    public boolean getVisibilityOfCell(int x, int y) {
        return currentBoard[x][y].isVisible();
    }

    /**
     * Setter function that changes the visibility of a cell to given parameter
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param b the boolean value representing new visibility of cell
     */
    public void changeVisibilityOfCell(int x, int y, boolean b) {
        currentBoard[x][y].setVisible(b);
    }

    /**
     * Getter function returning whether the cell is flagged.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return boolean representing whether the cell is flagged
     */
    public boolean getFlaggedOfCell(int x, int y) {
        return currentBoard[x][y].isFlagged();
    }

    /**
     * Setter function that changes the flagged status of a cell to given parameter
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param b the boolean value representing new flagged status of cell
     */
    public void changeFlaggedOfCell(int x, int y, boolean b) {
        currentBoard[x][y].setFlagged(b);
    }

    /**
     * @return String representation of the board (numerical values only)
     */
    public String toString() {
        String stringBoardSolution = "";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                stringBoardSolution += currentBoard[i][j].getValue();
            }
            stringBoardSolution += "\n";
        }

        return stringBoardSolution;
    }
}
