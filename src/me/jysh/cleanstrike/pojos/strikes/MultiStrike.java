package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public class MultiStrike implements iStrike {

	@Override
	public boolean isPossible(CarromBoard carromBoard) {
		return carromBoard.getBlackCoinCount() >= 2;
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		carromBoard.decrementBlackCoinCount(2);
		currentPlayer.incrementPointCount(2);
	}
}
