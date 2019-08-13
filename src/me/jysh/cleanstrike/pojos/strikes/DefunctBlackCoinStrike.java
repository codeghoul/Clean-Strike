package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.constants.ScoreConstants;
import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public class DefunctBlackCoinStrike implements iStrike {
	private static final DefunctBlackCoinStrike DEFUNCT_BLACK_COIN_STRIKE = new DefunctBlackCoinStrike();

	private DefunctBlackCoinStrike() {
		
	}

	public static DefunctBlackCoinStrike getInstance() {
		return DEFUNCT_BLACK_COIN_STRIKE;
	}

	@Override
	public boolean isStrikePossible(CarromBoard carromBoard) {
		return carromBoard.hasBlackCoins();
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		carromBoard.decrementBlackCoinCount(1);

		currentPlayer.decrementPointCount(ScoreConstants.DEFUNCTBLACKCOINSTRIKEPOINTCOUNT.getCount());
		currentPlayer.incrementFoulCount(ScoreConstants.DEFUNCTBLACKCOINFOULCOUNT.getCount());

		if (!currentPlayer.hasRecentNonPocket()) {
			currentPlayer.setRecentNonPocket(true);
		}
		currentPlayer.incrementSuccessiveNonPocketCount(1);

		LOGGER.debug("Decrement Black Coins By: " + 1 + "Decrement Points By "
				+ ScoreConstants.DEFUNCTBLACKCOINSTRIKEPOINTCOUNT + " Increment Fouls By "
				+ ScoreConstants.DEFUNCTBLACKCOINFOULCOUNT);
	}
}
