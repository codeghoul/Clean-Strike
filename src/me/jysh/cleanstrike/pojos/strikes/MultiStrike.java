package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.constants.ScoreConstants;
import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public class MultiStrike implements iStrike {

	@Override
	public boolean isStrikePossible(CarromBoard carromBoard) {
		return carromBoard.getBlackCoinCount() >= 2;
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		carromBoard.decrementBlackCoinCount(2);
		
		currentPlayer.incrementPointCount(ScoreConstants.MULTISTRIKEPOINTCOUNT.getCount());
		
		currentPlayer.setSuccessiveNonPocketCount(0);
		currentPlayer.setRecentNonPocket(false);
		
		LOGGER.debug("Decrement Black Coins By: " + 2 + "Increment Points By " + ScoreConstants.MULTISTRIKEPOINTCOUNT.getCount() + " Decrement Fouls By " + 0);
	}
}
