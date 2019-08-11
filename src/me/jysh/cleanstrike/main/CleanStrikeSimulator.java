package me.jysh.cleanstrike.main;

import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;

import me.jysh.cleanstrike.pojos.CleanStrikeGame;
import me.jysh.cleanstrike.pojos.Player;
import me.jysh.cleanstrike.pojos.iStrike;
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
	}

	private void playCleanStrike() {
		while (isPlayable()) {
			iStrike currentStrike = IOUtils.inputStrikeInformation();
			cleanStrike.setCurrentStrike(currentStrike);
			cleanStrike.performStrike();
		}
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
		this.cleanStrike = new CleanStrikeGame(currentPlayer);
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
