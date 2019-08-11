package me.jysh.cleanstrike.pojos.strikes;

import me.jysh.cleanstrike.pojos.CarromBoard;
import me.jysh.cleanstrike.pojos.Player;

public interface iStrike {
	public boolean isPossible(CarromBoard carromBoard);
	public void doStrike(CarromBoard carromBoard, Player currentPlayer);
}
