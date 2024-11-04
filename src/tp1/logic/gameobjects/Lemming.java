package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.WalkerRole;

public class Lemming extends GameObject {

    private WalkerRole role;
    private int forceOfFall = 0;
    private Direction dir;
    private static final int MAX_FALL = 3;

    public Lemming(Game game, Position pos, Direction dir) {
        super(game, pos);
        this.role = new WalkerRole();
        this.dir = dir;
    }

    public Direction getDirection() {
        return this.dir;
    }

    public void walkOrFall() {
        // Calculate the new position based on the current direction
        int moveX = this.pos.getCol() + dir.getX();
        int moveY = this.pos.getRow() + dir.getY();

        // Check if the new position is within the bounds of the board
        if (moveY < Game.DIM_Y && moveY >= 0 && moveX < Game.DIM_X && moveX >= 0) {
            // Move one space in the direction specified
            this.pos = new Position(moveX, moveY);
            forceOfFall++; // Increment fall count if falling
        } else {
            // If the lemming tries to move out of bounds, it should reverse direction
            reverseDir();
        }

        // Check if the lemming has fallen too far
        if (forceOfFall > MAX_FALL) {
            this.isAlive = false; // Mark lemming as dead if it exceeds max fall
        }
    }

    private void reverseDir() {
        if (dir == Direction.RIGHT) {
            dir = Direction.LEFT;
        } else {
            dir = Direction.RIGHT;
        }
    }

    @Override
    public void update() {
        if (isAlive()) {
            role.play(this);
            walkOrFall();
        }
        // Additional update logic as necessary
    }

    @Override
    public String getIcon() {
        return "L"; // Returns the icon representing a lemming
    }

    @Override
    public String toString() {
        return "Lemming at " + pos; // Example string representation
    }
}
