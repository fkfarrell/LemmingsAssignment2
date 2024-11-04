package tp1.logic;
import tp1.logic.Position;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.lemmingRoles.WalkerRole;

public class Game implements GameModel, GameStatus { // , GameWorld
	//levels are init methods in this class
	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;

	private GameObjectContainer container = new GameObjectContainer();
	private int cycleNum;
	private boolean gameRunning=true;


	public Game(int nLevel) {
		// TODO Auto-generated constructor stub
		this.container = new GameObjectContainer();
		initializeLevel(nLevel);
	}

	 public void addObjectToGame(GameObject obj) {
        container.add(obj);
		//increment counter of lemmings here
    }

	public void initializeLevel(int nLevel) {
        LevelStarter.initializeGame(this, nLevel);
    }

	// GameStatus methods
	@Override
	public int getCycle() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void resetCycleNum() {
        this.cycleNum = 0;
    }


    public void addExitDoor(Position position) {
        ExitDoor exitDoor = new ExitDoor(position);
        container.add(exitDoor);
    }

    public void addLemming(Position position, Direction direction) {
		Lemming lemming = new Lemming(this, position, direction);
		container.add(lemming);  // Add lemming to the container
	}
	

    public void addWall(Position position) {
        Wall wall = new Wall(position);
        container.add(wall);
    }

	@Override
	public int numLemmingsInBoard() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numLemmingsDead() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numLemmingsExit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numLemmingsToWin() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String positionToString(int col, int row) {
		Position pos = new Position(col, row);
		return container.getStringAt(pos);
	}

	@Override
	public boolean playerWins() {
		return numLemmingsExit() >= numLemmingsToWin();
	}


	@Override
	public boolean playerLooses() {
		// TODO Auto-generated method stub
		return false;
	}

	// GameModel methods
	// @Override
	public void update() {
		container.update();
		cycleNum++;
	}

	// @Override
	public void exit() {
		// TODO Auto-generated method stub
		gameRunning = false;

	}

	// @Override
	public void none() {
		// TODO Auto-generated method stub
		update();
	}

	// @Override
	public void reset() {
    	resetCycleNum();
    	initializeLevel(1);
	}

	// @Override
	
	@Override
	public String help() {
   		 System.out.println("Available commands:\n" +
            "[r]eset: start a new game\n" +
            "[h]elp: print this help message\n" +
            "[e]xit: end the execution of the game\n" +
            "[n]one | \"\": skip a cycle");
		return null;
		}


	// this doesnt feel right . . .
	@Override
	public void createLevel(int levelNum) {
		Levels level1 = new Levels();
		Position starterPos = new Position(1, 1);
		Lemming patrick = new Lemming(this, starterPos, Direction.RIGHT);
		container.add(patrick);
	}

	// @Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	// TODO Auto-generated method stub

	// GameWorld methods (callbacks)
	// @Override
	public boolean isInAir(Position pos) {
		// TODO Auto-generated method stub
		return false;
	}

	// @Override
	public void lemmingArrived() {
		// TODO Auto-generated method stub
	}
	// TODO Auto-generated method stub

	// Other methods
	// TODO you should write a toString method to return the string that represents
	// the object status
	// @Override
	// public String toString()
	public boolean gameRunning(){
		return gameRunning;
	}
}
