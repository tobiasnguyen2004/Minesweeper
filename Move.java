package org.cis1200.minesweeper;

/**
 * This class focuses on storing any move the player makes. To do so, it must
 * know the coordinates of the affected cell and the type of move.
 * We can define the type of moves like so:
 * - 0 = Player reveals a cell
 * - 1 = Player flags a cell
 * - 2 = Player unflags a cell
 *
 *
 *
 */
public class Move {

    private int xCoor;
    private int yCoor;
    private int moveType;

    /**
     * Default constructor. Sets private fields accordingly
     *
     * @param x    the x coordinate
     * @param y    the y coordinate
     * @param type the type of move recently done (refer to top for legend)
     * @throws IllegalArgumentException if any arguments are invalid
     */
    public Move(int x, int y, int type) {

        if (x < 0 || y < 0 || x > 15 || y > 15 || type < 0 || type > 2) {
            throw new IllegalArgumentException();
        }

        xCoor = x;
        yCoor = y;
        moveType = type;
    }

    /**
     * @return the xCoor
     */
    public int getxCoor() {
        return xCoor;
    }

    /**
     * @return the yCoor
     */
    public int getyCoor() {
        return yCoor;
    }

    /**
     * @return the moveType
     */
    public int getMoveType() {
        return moveType;
    }

    /**
     * @return String representation of the move
     */
    public String toString() {
        return "Move Type: " + moveType + " on (" + xCoor + ", " + yCoor + ")";
    }

}
