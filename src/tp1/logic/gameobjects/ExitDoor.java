package tp1.logic.gameobjects;
import tp1.logic.Position;

public class ExitDoor extends GameObject {
    private Position position;
    private String doorSprite = "🚪";


    public ExitDoor(Position position) {
        super(game, position);
        this.position = position;
        doorSprite = position.toString();
    }

    public Position getPosition() {
        return this.position;
    }

    public String toString() {
        return doorSprite;
    }

    public void update() {
    }


    @Override
    public String getIcon() {
        return doorSprite;         
    }
}
