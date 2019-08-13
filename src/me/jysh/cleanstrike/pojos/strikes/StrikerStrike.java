package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.constants.ScoreConstants;
import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public class StrikerStrike implements iStrike {
	private static final StrikerStrike STRIKER_STRIKE = new StrikerStrike();

	private StrikerStrike() {
		
	}

	public static StrikerStrike getInstance() {
		return STRIKER_STRIKE;
	}

	@Override
	public boolean isStrikePossible(CarromBoard carromBoard) {
		return true;
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		currentPlayer.decrementPointCount(ScoreConstants.STRIKERSTRIKEPOINTCOUNT.getCount());
		currentPlayer.incrementFoulCount(ScoreConstants.STRIKERSTRIKEFOULCOUNT.getCount());

		currentPlayer.incrementSuccessiveNonPocketCount(1);

		if (!currentPlayer.hasRecentNonPocket()) {
			currentPlayer.setRecentNonPocket(true);
		}

		LOGGER.debug("Decrement Points By: " + ScoreConstants.STRIKERSTRIKEPOINTCOUNT.getCount()
				+ " Increment Fouls By: " + ScoreConstants.STRIKERSTRIKEFOULCOUNT.getCount());
	}
}
