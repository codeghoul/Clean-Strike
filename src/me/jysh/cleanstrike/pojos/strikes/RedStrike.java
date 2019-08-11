package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public class RedStrike implements iStrike {
	@Override
	public boolean isPossible(CarromBoard carromBoard) {
		return carromBoard.hasRedCoins();
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		carromBoard.decrementRedCoinCount(1);
		currentPlayer.incrementPointCount(3);
	}
}