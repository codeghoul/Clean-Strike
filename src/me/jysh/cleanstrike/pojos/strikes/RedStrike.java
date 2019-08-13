package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.constants.ScoreConstants;
import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public class RedStrike implements iStrike {
	private static final RedStrike RED_STRIKE = new RedStrike();

	private RedStrike() {
		
	}

	public static RedStrike getInstance() {
		return RED_STRIKE;
	}

	@Override
	public boolean isStrikePossible(CarromBoard carromBoard) {
		return carromBoard.hasRedCoins();
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		carromBoard.decrementRedCoinCount(1);

		currentPlayer.incrementPointCount(ScoreConstants.REDSTRIKEPOINTCOUNT.getCount());

		currentPlayer.setSuccessiveNonPocketCount(0);
		currentPlayer.setRecentNonPocket(false);

		LOGGER.debug("Decrement Red Coins By: " + 1 + " Increment Points By: "
				+ ScoreConstants.REDSTRIKEPOINTCOUNT.getCount());
	}
}