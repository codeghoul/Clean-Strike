package me.jysh.cleanstrike.pojos;

public class MultiStrike implements iStrike {

	@Override
	public boolean isPossible(CarromBoard carromBoard, Player currentPlayer) {
		return carromBoard.getBlackCoinCount() >= 2;
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		carromBoard.decrementBlackCoinCount(2);
		currentPlayer.incrementPointCount(2);
	}
}
