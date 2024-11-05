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

    public Position getPosition() {
        return this.pos;
    }

    public boolean canMove(Position pos, Direction dir) {
        int moveX = this.pos.getCol() + dir.getX();
        int moveY = this.pos.getRow() + dir.getY();

        // Check if there's a floor beneath the lemming
        if (game.positionToString(pos.getCol(), pos.getRow() + 1).equals("▓")) {
            // If there's a floor, reset fall force and check for walls
            this.forceOfFall = 0;
            if (moveX == 0 || moveX == Game.DIM_X - 1) {
                this.reverseDir();
            }

            // Check if moving in the current direction hits a wall
            if (game.positionToString(moveX, moveY).equals("▓")) {
                this.reverseDir();
                return false;
            }
            return true;
        } else {
            // If there's no floor, set direction to DOWN
            this.dir = Direction.DOWN;
            return true;
        }
    }

    public void walkOrFall() {
        // Calculate the new position based on the current direction
        int moveX = this.pos.getCol() + dir.getX();
        int moveY = this.pos.getRow() + dir.getY();

        // Move if within bounds
        if (moveY < Game.DIM_Y && moveY >= 0 && moveX < Game.DIM_X && moveX >= 0) {
            this.pos = new Position(moveX, moveY);
            forceOfFall++; // Increment fall count if moving down
        } else {
            reverseDir();
        }

        // Check if lemming has exceeded max fall height
        if (forceOfFall > MAX_FALL) {
            this.isAlive = false;
        }
    }

    private void reverseDir() {
        dir = (dir == Direction.RIGHT) ? Direction.LEFT : Direction.RIGHT;
    }

    public void update() {
        // Update lemming’s status (falling, dead, or moving)
        if (isAlive) {
            advance(this);
            if (dir == Direction.DOWN) {
                forceOfFall++;
            } else {
                forceOfFall = 0; // Reset fall force if on the ground
            }
        }

        // Mark lemming as dead if it exceeds max fall height
        if (forceOfFall > MAX_FALL) {
            this.isAlive = false;
        }
    }

    public void advance(Lemming lemming) {
        if (lemming.canMove(lemming.getPosition(), lemming.getDirection())) {
            lemming.walkOrFall();
        }
    }

    @Override
    public String getIcon() {
        return "L";
    }

    @Override
    public String toString() {
        return "Lemming at " + pos;
    }
}
