package tp1.logic;

/**
 * Immutable class to encapsulate and manipulate positions in the game board.
 */
public class Position {

    private final int col;
    private final int row;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    // Compare positions by column and row values
    public boolean isEqual(Position other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        return this.col == other.col && this.row == other.row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
    
    // Return a string representation of the Position
    @Override
    public String toString() {
        return "(" + col + ", " + row + ")";
    }
}
