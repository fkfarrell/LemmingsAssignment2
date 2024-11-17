package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class DownCaverRole implements LemmingRole {

    private static final String NAME = Messages.DOWN_CAVER_ROL_NAME;
    private static final String HELP = Messages.DOWN_CAVER_ROL_HELP;
    private static final String ICON = Messages.LEMMING_DOWN_CAVER;

    @Override
    public String getIcon(Lemming lemming) {
        if (lemming.isAlive()) {
            return ICON;
        } else
            return " ";
    }

    @Override
    public void play(Lemming lemming) {

    }

    @Override
    public void advance(Lemming lemming) {
        lemming.dig();
    }

    @Override
    public String helpText() {
        return HELP;
    }

    @Override
    public String getShortcut() {
        return "d";
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean receiveInteraction(GameItem other, Lemming lemming) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receiveInteraction'");
    }

    @Override
    public boolean interactWith(Lemming receiver, Lemming lemming) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interactWith'");
    }

    @Override
    public boolean interactWith(Wall wall, Lemming lemming) {
        return true;
    }

    @Override
    public boolean interactWith(ExitDoor door, Lemming lemming) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interactWith'");
    }

    @Override
    public boolean interactWith(MetalWall metalWall, Lemming lemming) {
        return false;
    }

}