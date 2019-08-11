package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.constants.ScoreConstants;
import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public class DefunctRedCoinStrike implements iStrike {

	@Override
	public boolean isStrikePossible(CarromBoard carromBoard) {
		return carromBoard.hasRedCoins();
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		carromBoard.decrementRedCoinCount(1);

		currentPlayer.decrementPointCount(ScoreConstants.DEFUNCTREDCOINSTRIKEPOINTCOUNT.getCount());
		currentPlayer.incrementFoulCount(ScoreConstants.DEFUNCTREDCOINFOULCOUNT.getCount());

		if (!currentPlayer.hasRecentNonPocket()) {
			currentPlayer.setRecentNonPocket(true);
		}
		currentPlayer.incrementSuccessiveNonPocketCount(1);

		LOGGER.debug(
				"Decrement Red Coin By: " + 2 + "Decrement Points By " + ScoreConstants.DEFUNCTREDCOINSTRIKEPOINTCOUNT
						+ " Increment Fouls By " + ScoreConstants.DEFUNCTREDCOINFOULCOUNT);
	}
}
