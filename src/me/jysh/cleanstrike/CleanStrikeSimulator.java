package me.jysh.cleanstrike;

import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;

import me.jysh.cleanstrike.pojos.CleanStrike;
import me.jysh.cleanstrike.pojos.Player;

public class CleanStrikeSimulator {
	private CleanStrike cleanStrike;
	private Player playerOne;
	private Player playerTwo;
	private static final Logger LOGGER = LogManager.getLogger(CleanStrikeSimulator.class);
	private static final BufferedReader CONSOLEREADER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		new CleanStrikeSimulator().run();
	}

	private void run() {
	}
}
