package me.jysh.cleanstrike.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.jysh.cleanstrike.pojos.CleanStrikeGame;
import me.jysh.cleanstrike.pojos.Player;
import me.jysh.cleanstrike.pojos.strikes.iStrike;
import me.jysh.cleanstrike.utils.IOUtils;

public class CleanStrikeSimulator {
	private CleanStrikeGame cleanStrike;
	private Player playerOne;
	private Player playerTwo;
	private static final Logger LOGGER = LogManager.getLogger(CleanStrikeSimulator.class.getClass());

	public static void main(String[] args) {
		new CleanStrikeSimulator().run();
	}

	private void run() {
		initCleanStrike();
		playCleanStrike();
		displayResultsOfCleanStrike();
	}

	private void displayResultsOfCleanStrike() {
		if (hasWinner()) {
			Player winner = (playerOne.getPointCount() > playerTwo.getPointCount()) ? playerOne : playerTwo;
			LOGGER.info("Player " + winner.getPlayerName() + " won the game by: "
					+ Math.abs(playerOne.getPointCount() - playerTwo.getPointCount()) + " Points");
		} else {
			LOGGER.info("Hey, it's a Draw. Everybody is a Winner!");
		}
	}

	private void playCleanStrike() {
		while (isPlayable()) {
			iStrike currentStrike = IOUtils.inputStrikeInformation(cleanStrike.getCarromBoard());
			cleanStrike.setCurrentStrike(currentStrike);
			cleanStrike.performStrike();
			cleanStrike.performFoulOperations();
			switchCurrentPlayer();
			displayGameStatus();
		}
	}

	private void switchCurrentPlayer() {
		LOGGER.trace("Player Before Switching: " + cleanStrike.getCurrentPlayer());

		cleanStrike.setCurrentPlayer(cleanStrike.getCurrentPlayer() == playerOne ? playerTwo : playerOne);

		LOGGER.trace("Player After Switching: " + cleanStrike.getCurrentPlayer());
	}

	private void displayGameStatus() {
		System.out.println();
		LOGGER.info("Game Status: ");
		LOGGER.info(cleanStrike.getCarromBoard());
		LOGGER.info(playerOne);
		LOGGER.info(playerTwo);
		LOGGER.info("Current Player: " + cleanStrike.getCurrentPlayer().getPlayerName());
	}

	private boolean isPlayable() {
		return !hasWinner() && cleanStrike.isPlayable();
	}

	private boolean hasWinner() {
		int playerOnePointCount = playerOne.getPointCount();
		int playerTwoPointCount = playerTwo.getPointCount();

		return (playerOnePointCount >= 5 || playerTwoPointCount >= 5)
				&& (Math.abs(playerOnePointCount) - playerTwoPointCount) >= 3;
	}

	private void initCleanStrike() {
		initPlayers();
		initCurrentPlayer();
	}

	private void initCurrentPlayer() {
		Player currentPlayer = IOUtils.inputCurrentPlayer(playerOne, playerTwo);
		this.cleanStrike = new CleanStrikeGame();
		cleanStrike.setCurrentPlayer(currentPlayer);
	}

	private void initPlayers() {
		String playerName = null;

		System.out.println("Enter Player One Name: ");
		playerName = IOUtils.inputPlayerName();
		this.playerOne = new Player(playerName);

		System.out.println("Enter Player Two Name: ");
		playerName = IOUtils.inputPlayerName();
		this.playerTwo = new Player(playerName);
	}
}
