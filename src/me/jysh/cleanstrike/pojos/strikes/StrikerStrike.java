package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public class StrikerStrike implements iStrike {
	@Override
	public boolean isPossible(CarromBoard carromBoard) {
		return true;
	}

	@Override
	public void doStrike(CarromBoard carromBoard, Player currentPlayer) {
		currentPlayer.decrementPointCount(1);
		currentPlayer.incrementFoulCount(1);
	}
}	
