package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.logic.Direction;

public class LevelStarter {

    // Constants for level configuration
    private static final int WALL_Y = 3; // Fixed Y position for walls
    private static final int DOOR_ROW = 7;
    private static final int DOOR_COL = 9;

    public static void initializeGame(Game game, int nLevel) {
        game.resetCycleNum();  // Reset cycleNum using a method in Game

        // Add exit door via Game method
        game.addExitDoor(new Position(DOOR_COL, DOOR_ROW));  

        WalkerRole walker = new WalkerRole(); // Initialize WalkerRole once

        // Initialize lemming positions based on the level
        switch (nLevel) {
            case 0:
                initializeLevel0(game, walker);
                break;
            case 1:
                initializeLevel1(game, walker);
                break;
            default:
                initializeDefaultLevel(game, walker);
                break;
        }
    }

    private static void initializeLevel0(Game game, WalkerRole walker) {
        Position[] lemmingPositionsLevel0 = {
                new Position(1, 1),
                new Position(2, 1),
                new Position(3, 1)
        };

        for (Position lemmingPos : lemmingPositionsLevel0) {
            addLemmingAndWalls(game, lemmingPos);
        }
    }

    private static void initializeLevel1(Game game, WalkerRole walker) {
        Position[] lemmingPositionsLevel1 = {
                new Position(0, 0),
                new Position(1, 1),
                new Position(3, 1),
                new Position(5, 2),
                new Position(7, 3)
        };

        for (Position lemmingPos : lemmingPositionsLevel1) {
            addLemmingAndWalls(game, lemmingPos);
        }
    }

    private static void initializeDefaultLevel(Game game, WalkerRole walker) {
        Position[] lemmingPositionsDefault = {
                new Position(4, 4),
                new Position(6, 6),
                new Position(8, 8),
                new Position(2, 7),
                new Position(1, 9)
        };

        for (Position lemmingPos : lemmingPositionsDefault) {
            addLemmingAndWalls(game, lemmingPos);
        }
    }

    private static void addLemmingAndWalls(Game game, Position lemmingPos) {
        Lemming lemming = new Lemming(game, lemmingPos, Direction.RIGHT);
        game.addObjectToGame(lemming);  // Use Game's method to add lemming

        // Add walls based on lemming position
        game.addWall(new Position(lemmingPos.getCol(), WALL_Y)); // One wall at fixed height

        // Adding walls in a predefined pattern
        for (int j = 3; j < 8; j++) {
            game.addWall(new Position(j, 5));
        }

        for (int j = 8; j < 10; j++) {
            game.addWall(new Position(j, 8));
        }
    }
}
