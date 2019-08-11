package me.jysh.cleanstrike.pojos.strikes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public interface iStrike {
	static final Logger LOGGER = LogManager.getLogger(iStrike.class.getClass());
	public boolean isStrikePossible(CarromBoard carromBoard);

	public void doStrike(CarromBoard carromBoard, Player currentPlayer);
}
