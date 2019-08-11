package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public class NoStrike implements iStrike{

	@Override
	public boolean isPossible(CarromBoard carromBoard) {
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
