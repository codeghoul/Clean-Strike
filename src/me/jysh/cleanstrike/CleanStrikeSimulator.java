package me.jysh.cleanstrike;

import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;

import me.jysh.cleanstrike.pojos.CleanStrike;
import me.jysh.cleanstrike.pojos.Player;

public class CleanStrikeSimulator {
	private CleanStrike cleanStrike;
	private Player playerOne;
	private Player playerTwo;
	private static final Logger LOGGER = LogManager.getLogger(CleanStrikeSimulator.class.getClass());
	private static final BufferedReader CONSOLEREADER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		new CleanStrikeSimulator().run();
	}

	private void run() {
		initCleanStrike();
	}

	private void initCleanStrike() {
		initPlayers();
		initCurrentPlayer();
	}

	private void initCurrentPlayer() {
		LOGGER.trace("Entering initCurrentPlayer()");
		System.out.println("Choose who goes first: ");
		System.out.println("1. " + playerOne.getPlayerName());
		System.out.println("2. " + playerTwo.getPlayerName());
		String choice = null;
		try {
			choice = CONSOLEREADER.readLine();
			if (!(choice.equals("1") || choice.equals("2"))) {
				throw new IllegalArgumentException("Invalid Choice");
			}
		} catch (IOException | IllegalArgumentException e) {
			LOGGER.error("A problem occured when choosing who goes first. Details: " + e.getMessage());
			initCurrentPlayer();
		}
		cleanStrike = (choice.equals("1")) ? new CleanStrike(playerOne) : new CleanStrike(playerTwo);
		LOGGER.info((choice.equals("1")) ? playerOne.getPlayerName() : playerTwo.getPlayerName() + " goes first!");
		LOGGER.trace("Exiting initCurrentPlayer()");
	}

	private void initPlayers() {
		LOGGER.trace("Entering initPlayers()");
		String playerName = null;
		System.out.println("Enter Player One Name: ");
		try {
			playerName = CONSOLEREADER.readLine();
			playerOne = new Player(playerName);
			LOGGER.info("Player one name set to: " + playerName);
		} catch (IOException e) {
			LOGGER.error("Problem occured when entering player name. Details: " + e.getMessage());
		}
		System.out.println("Enter Player Two Name: ");
		try {
			playerName = CONSOLEREADER.readLine();
			playerTwo = new Player(playerName);
			LOGGER.info("Player two name set to: " + playerName);
		} catch (IOException e) {
			LOGGER.error("Problem occured when entering player name. Details: " + e.getMessage());
		}
		LOGGER.trace("Exiting initPlayers()");
	}
}
