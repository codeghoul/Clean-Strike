package me.jysh.cleanstrike.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.jysh.cleanstrike.pojos.Player;
import me.jysh.cleanstrike.pojos.iStrike;

public class IOUtils {
	private static final BufferedReader CONSOLEREADER = new BufferedReader(new InputStreamReader(System.in));
	private static final Logger LOGGER = LogManager.getLogger(IOUtils.class.getClass());
	
	public static String inputPlayerName() {
		String playerName = null;
		try {
			playerName = CONSOLEREADER.readLine();
			if(playerName.isEmpty()) {
				throw new IllegalArgumentException("Player name cannot be empty.");
			}
			LOGGER.info("Player name set to: " + playerName);
		} catch (IOException | IllegalArgumentException e) {
			LOGGER.error("Problem occured when entering player name. Details: " + e.getMessage());
			playerName = inputPlayerName();
		}
		return playerName;
	}

	public static Player inputCurrentPlayer(Player playerOne, Player playerTwo) {
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
			return inputCurrentPlayer(playerOne, playerTwo);
		}
		return choice.equals("1") ? playerOne : playerTwo;
	}

	public static iStrike inputStrikeInformation() {
		
	}
}
