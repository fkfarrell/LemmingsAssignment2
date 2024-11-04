package tp1;

import java.util.Locale;

import tp1.control.Controller;
import tp1.logic.Game;
import tp1.view.ConsoleColorsView;
import tp1.view.ConsoleView;
import tp1.view.GameView;
import tp1.view.Messages;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Required to avoid issues with tests
		Locale.setDefault(new Locale("es", "ES"));

		try {

			int nLevel = 1;
			if (args.length != 0)
				nLevel = Integer.parseInt(args[0]);

			Game game = new Game(nLevel);
			GameView view = args.length > 1 ? new ConsoleView(game) : new ConsoleColorsView(game);
			Controller controller = new Controller(game, view);

			controller.run();

		} catch (NumberFormatException e) {
			System.out.println(String.format(Messages.LEVEL_NOT_A_NUMBER_ERROR, args[0]));
		}
	}
}
//command -> no params command -> helpcommand, reset command etc. ABSTRACT CLASSES, to avoid repeating the parse method. only bottom levels are not abstract 
//no params has no arguments unlike reset role which takes in a role and coordinates of a lemming
//call excecute on itself which is an overwritten method that each object knows what it should do
//inheritance hierarchy for commands, for game objects, for roles

//exam add new of one in inheritance hierarchy