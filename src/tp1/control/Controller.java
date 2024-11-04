package tp1.control;

import tp1.control.commands.Command;
import tp1.control.commands.CommandGenerator;
import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {

	private Game game;
	private GameView view;

	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}


	/**
	 * Runs the game logic, coordinate Model(game) and View(view)
	 */
	public void run() {
		view.showWelcome();
	
		while (game.gameRunning() && !game.playerWins()) {
			// Draw Phase
			view.showGame();
	
			// User Command
			String[] command = view.getPrompt();
			
			// Check if command is empty before processing
			if (command.length == 0) {
				continue;  // Skip this loop iteration if no command entered
			}
		}	
	}
}	
