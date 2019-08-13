package me.jysh.cleanstrike.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.jysh.cleanstrike.pojos.Player;
import me.jysh.cleanstrike.pojos.strikes.StrikeInformation;
import me.jysh.cleanstrike.pojos.strikes.iStrike;
import me.jysh.cleanstrike.pojos.CarromBoard;

public class IOUtils {
	private static final BufferedReader CONSOLEREADER = new BufferedReader(new InputStreamReader(System.in));
	private static final Logger LOGGER = LogManager.getLogger(IOUtils.class.getClass());

	public static String inputPlayerName() {
		String playerName = null;
		try {
			playerName = CONSOLEREADER.readLine();
			if (playerName.isEmpty()) {
				throw new IllegalArgumentException("Player name cannot be empty.");
			}
			LOGGER.info("Player name set to: " + playerName);
		} catch (IOException | IllegalArgumentException e) {
			LOGGER.error(
					"Problem occured while entering player name. Details: " + e.getMessage() + " Please try again.");
			playerName = inputPlayerName();
		}
		return playerName;
	}

	public static Player inputCurrentPlayer(Player playerOne, Player playerTwo) {
		System.out.println("Choose who goes first: ");
		System.out.println("1. " + playerOne.getPlayerName());
		System.out.println("2. " + playerTwo.getPlayerName());
		String choice = null;
		Player currentPlayer = null;
		try {
			choice = CONSOLEREADER.readLine();
			if (!(choice.equals("1") || choice.equals("2"))) {
				throw new IllegalArgumentException("Invalid Choice");
			}
			currentPlayer = choice.equals("1") ? playerOne : playerTwo;
			LOGGER.info("Current Player: " + currentPlayer.getPlayerName());
		} catch (IOException | IllegalArgumentException e) {
			LOGGER.error("A problem occured while choosing who goes first. Details: " + e.getMessage()
					+ " Please try again.");
			currentPlayer = inputCurrentPlayer(playerOne, playerTwo);
		}
		return currentPlayer;
	}

	public static iStrike inputStrikeInformation(CarromBoard carromBoard) {
		Map<StrikeInformation, Supplier<iStrike>> strikeSupplier = StrikeUtils.getStrikeSupplier().entrySet().stream()
				.filter(entry -> entry.getValue().get().isStrikePossible(carromBoard))
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

		System.out.println("Choose type of strike: ");

		strikeSupplier.keySet().stream().sorted()
				.map(key -> key.getStrikeChoice() + ". to " + key.getStrikeDescription()).forEach(System.out::println);

		iStrike strike = null;

		String choice = null;
		try {
			choice = CONSOLEREADER.readLine();
			StrikeInformation strikeInformation = StrikeInformation.getStrikelookup(choice);

			if (strikeInformation == null || !strikeSupplier.containsKey(strikeInformation)) {
				throw new IllegalArgumentException("Invalid Choice");
			}

			strike = strikeSupplier.get(strikeInformation).get();
			LOGGER.info("Current Strike Purpose: " + strikeInformation.getStrikeDescription());
		} catch (IOException | IllegalArgumentException e) {
			LOGGER.error("A problem when choosing who strike. Details: " + e.getMessage());
			strike = inputStrikeInformation(carromBoard);
		}

		return strike;
	}
}
