package me.jysh.cleanstrike.pojos;

import java.util.function.Supplier;

public class NormalStrike implements iStrike {
	@Override
	public boolean isPossible(CarromBoard carromBoard, Player currentPlayer) {
		return carromBoard.hasBlackCoins();
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		carromBoard.decrementBlackCoinCount(1);
		currentPlayer.incrementPointCount(1);
	}
}
