package me.jysh.cleanstrike.pojos;

public interface iStrike {
	public boolean isPossible(CarromBoard carromBoard, Player currentPlayer);
	public void doStrike(CarromBoard carromBoard, Player currentPlayer);
}
