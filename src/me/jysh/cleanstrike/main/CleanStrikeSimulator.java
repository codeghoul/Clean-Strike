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
					+ Math.abs(playerOne.getPointCount() - playerTwo.getPointCount()));
		} else {
			LOGGER.info("It's a draw.");
		}
	}

	private void playCleanStrike() {
		while (isPlayable()) {
			iStrike currentStrike = IOUtils.inputStrikeInformation(cleanStrike.getCarromBoard());
			cleanStrike.setCurrentStrike(currentStrike);
			cleanStrike.performStrike();
			cleanStrike.performFoulOperations();
			displayGameStatus();
			switchCurrentPlayer();
		}
	}

	private void switchCurrentPlayer() {
		LOGGER.info("Player Before Switching: " + cleanStrike.getCurrentPlayer());
		cleanStrike.setCurrentPlayer(cleanStrike.getCurrentPlayer().equals(playerOne) ? playerTwo : playerOne);
		LOGGER.info("Player After Switching: " + cleanStrike.getCurrentPlayer());
	}

	private void displayGameStatus() {
		LOGGER.info(playerOne.getPlayerName() + " Points: " + playerOne.getPointCount() + "\n"
				+ playerTwo.getPlayerName() + "Points: " + playerOne.getPointCount());
	}

	private boolean isPlayable() {
		return !hasWinner() || this.cleanStrike.getCarromBoard().isPlayable();
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
		LOGGER.trace("Entering initCurrentPlayer()");
		Player currentPlayer = IOUtils.inputCurrentPlayer(playerOne, playerTwo);
		this.cleanStrike = new CleanStrikeGame();
		cleanStrike.setCurrentPlayer(currentPlayer);
		LOGGER.info(this.cleanStrike.getCurrentPlayer().getPlayerName() + " goes first!");
		LOGGER.trace("Exiting initCurrentPlayer()");
	}

	private void initPlayers() {
		LOGGER.trace("Entering initPlayers()");
		String playerName = null;

		System.out.println("Enter Player One Name: ");
		playerName = IOUtils.inputPlayerName();
		this.playerOne = new Player(playerName);

		System.out.println("Enter Player Two Name: ");
		playerName = IOUtils.inputPlayerName();
		this.playerTwo = new Player(playerName);

		LOGGER.trace("Exiting initPlayers()");
	}
}
