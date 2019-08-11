package me.jysh.cleanstrike.pojos;

public class RedStrike implements iStrike {
	@Override
	public boolean isPossible(CarromBoard carromBoard, Player currentPlayer) {
		return carromBoard.hasRedCoins();
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		carromBoard.decrementRedCoinCount(1);
		currentPlayer.incrementPointCount(3);
	}
}