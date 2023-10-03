package org.cis1200.minesweeper;

/**
 * This class focuses on each individual cell of Minesweeper's grid.
 * The cell itself only contains some variables that shows the values
 * and state of the cell, like visibility and whether it is flagged,
 * as well as some setter and getter functions.
 *
 */
public class Cell {
    private int xCoor;
    private int yCoor;
    private int value; // is 0-8 depending on the number of bombs surrounding,
                       // 9 if bomb
    private boolean visible = false; // true if visible, false if hidden
    private boolean flagged = false; // true if player has flagged, else false

    /**
     * Creates a cell.
     *
     * @param x   the x coordinate value of the cell
     * @param y   the y coordinate value of the cell
     * @param val the numerical value of the cell indicating neighboring bombs (9 if
     *            bomb)
     * @throws IllegalArgumentException if the given parameters are not valid
     *                                  (x,y must be between 0 and 15, val must be
     *                                  between 0 and 9)
     *
     */
    public Cell(int x, int y, int val) {
        if (x < 0 || y < 0 || val < 0 || val > 9 || x > 15 || y > 15) {
            throw new IllegalArgumentException();
        }

        xCoor = x;
        yCoor = y;
        value = val;
    }

    /**
     * @return the xCoor (testing purposes)
     */
    public int getxCoor() {
        return xCoor;
    }

    /**
     * @return the yCoor (testing purposes)
     */
    public int getyCoor() {
        return yCoor;
    }

    /**
     * @return the value of the cell
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the visibility of the cell
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible set the visibility
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the flagged status of the cell
     */
    public boolean isFlagged() {
        return flagged;
    }

    /**
     * @param flagged set the flagged status
     */
    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }
}
