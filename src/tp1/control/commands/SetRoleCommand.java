package tp1.control.commands;

import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;
//import tp1.logic.gameobjects.*;
import tp1.logic.lemmingRoles.*;
import tp1.logic.Position;
import tp1.logic.Game;

public class SetRoleCommand extends Command {

    // Forman parte de atributos de estado
    private static final String NAME = Messages.COMMAND_SET_ROLE_NAME;
    private static final String SHORTCUT = Messages.COMMAND_SET_ROLE_SHORTCUT;
    private static final String DETAILS = Messages.COMMAND_SET_ROLE_DETAILS;
    private static final String HELP = Messages.COMMAND_SET_ROLE_HELP;
    private Position pos;
    private LemmingRole role;
    private LemmingRole gameRole;
    private Game game;
    private Position rolePosition;

    public SetRoleCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    public SetRoleCommand(LemmingRole role, Position pos) {
        super(NAME, SHORTCUT, DETAILS, HELP);
        this.role = role;
        this.pos = pos;
    }

    @Override
    public void execute(GameModel game, GameView view) {

        if (game.checkLemmingPosition(rolePosition)) {
            game.setLemmingRole(rolePosition, gameRole);
        } else {
            System.err.println(
                    "[ERROR] Error: SetRoleCommand error (Incorrect position or no object in that position admits that role)");
        }
    }

    public Command parse(String[] commandWords) {
        // parse info taken in and return cmd.

        // LEMMING ROLE
        LemmingRole role = LemmingRoleFactory.parse(commandWords);
        gameRole = role;
        if (role == null) {
            System.err.println("[ERROR] Error: Unknown Role");
        }

        try {
            String rowPos = commandWords[2].toLowerCase();
            if (rowPos.length() != 1 || rowPos.charAt(0) < 'a' || rowPos.charAt(0) > 'j') {
                System.err.println("[ERROR] Error: Row position out of board bounds");
                return null;
            }
            int rowNum = rowPos.charAt(0) - 'a';

            int colNum = Integer.parseInt(commandWords[3]);
            if (colNum < 0 || colNum >= 10) {
                System.err.println("[ERROR] Error: Column position out of board bounds");
                return null;
            }

            // need to check whether that position is valid before returning the command and
            // executing!!
            rolePosition = new Position(colNum - 1, rowNum);

            return this;
        } catch (NumberFormatException e) {
            System.err.println(
                    "[ERROR] Error: SetRoleCommand error (Incorrect position or no object in that position admits that role)");
            return null;
        }
    }

    @Override
    public boolean showBoard() {
        return true;
    }

}
