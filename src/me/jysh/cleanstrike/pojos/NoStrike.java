package me.jysh.cleanstrike.pojos;

public class NoStrike implements iStrike{

	@Override
	public boolean isPossible(CarromBoard carromBoard, Player currentPlayer) {
		return true;
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		if(!currentPlayer.hasRecentNonPocket()) {
			currentPlayer.setRecentNonPocket(true);
		}
		currentPlayer.incrementSuccessiveNonPocketCount(1);
	}
}
