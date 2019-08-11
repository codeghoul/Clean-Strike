package me.jysh.cleanstrike.pojos;

import com.sun.xml.internal.bind.v2.TODO;

public class CleanStrike {
	private Player currentPlayer;
	private CarromBoard carromBoard;

	{
		carromBoard = new CarromBoard();
	}
	
	public CleanStrike(Player currentPlayer) {
		super();
		this.currentPlayer = currentPlayer;
	}
	
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
	}

	public CarromBoard getCarromBoard() {
		return carromBoard;
	}

	public void setCarromBoard(CarromBoard carromBoard) {
		this.carromBoard = carromBoard;
	}
	
//	public void redStrike() {
//		
//	}
//	
//	public void noStrike() {
//		
//	}
//	
//	private int inputMultiStrikeCount() {
//		return 0;	
//	}
//	
//	public void multiStrike() {
//		int n = inputMultiStrikeCount();
//	}
//	
//	public void strikerStrike() {
//		
//	}
//	
//	private int inputDefunctCoin() {
//		return 0;
//	}
//	
//	public void defunctCoinStrike() {
//		
//	}
}
