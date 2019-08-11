package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public class DefunctCoinStrike implements iStrike {
	@Override
	public boolean isPossible(CarromBoard carromBoard) {
		return carromBoard.hasBlackCoins() || carromBoard.hasRedCoins();
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		carromBoard.decrementBlackCoinCount(1);
		currentPlayer.incrementFoulCount(2);
		if (!currentPlayer.hasRecentNonPocket()) {
			currentPlayer.setRecentNonPocket(true);
		}
		currentPlayer.incrementSuccessiveNonPocketCount(1);
	}
}
