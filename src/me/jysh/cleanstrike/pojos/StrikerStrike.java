package me.jysh.cleanstrike.pojos;

public class StrikerStrike implements iStrike {
	@Override
	public boolean isPossible(CarromBoard carromBoard, Player currentPlayer) {
		return true;
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		currentPlayer.decrementPointCount(1);
		currentPlayer.incrementFoulCount(1);
	}
}	
