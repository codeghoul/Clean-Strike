package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public class NormalStrike implements iStrike {
	@Override
	public boolean isPossible(CarromBoard carromBoard) {
		return carromBoard.hasBlackCoins();
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		carromBoard.decrementBlackCoinCount(1);
		currentPlayer.incrementPointCount(1);
	}
}
