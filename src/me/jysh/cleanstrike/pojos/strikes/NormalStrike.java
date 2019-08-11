package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.constants.ScoreConstants;
import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public class NormalStrike implements iStrike {
	@Override
	public boolean isStrikePossible(CarromBoard carromBoard) {
		return carromBoard.hasBlackCoins();
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		carromBoard.decrementBlackCoinCount(1);

		currentPlayer.setSuccessiveNonPocketCount(0);
		currentPlayer.setRecentNonPocket(false);

		currentPlayer.incrementPointCount(ScoreConstants.NORMALSTRIKEPOINTCOUNT.getCount());

		LOGGER.debug("Decrement Black Coins By: " + 1 + "Increment Points By "
				+ ScoreConstants.NORMALSTRIKEPOINTCOUNT.getCount() + " Decrement Fouls By " + 0);
	}
}
