package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.constants.ScoreConstants;
import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public class NoStrike implements iStrike {

	@Override
	public boolean isStrikePossible(CarromBoard carromBoard) {
		return true;
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		currentPlayer.decrementPointCount(ScoreConstants.NOSTRIKEPOINTCOUNT.getCount());
		currentPlayer.decrementFoulCount(ScoreConstants.NOSTRIKEFOULCOUNT.getCount());

		currentPlayer.incrementSuccessiveNonPocketCount(1);

		if (!currentPlayer.hasRecentNonPocket()) {
			currentPlayer.setRecentNonPocket(true);
		}

		LOGGER.debug("Decrement Coins By: " + 0 + "Decrement Points By " + ScoreConstants.NOSTRIKEPOINTCOUNT.getCount()
				+ " Increment Fouls By " + ScoreConstants.NOSTRIKEFOULCOUNT.getCount());
	}
}
