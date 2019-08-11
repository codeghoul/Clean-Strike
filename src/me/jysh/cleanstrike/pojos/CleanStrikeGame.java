package me.jysh.cleanstrike.pojos;

import me.jysh.cleanstrike.pojos.strikes.iStrike;

public class CleanStrikeGame {
	private Player currentPlayer;
	private iStrike currentStrike;
	private CarromBoard carromBoard;

	{
		carromBoard = new CarromBoard();
	}

	public CleanStrikeGame() {
	}

	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
	}

	public iStrike getCurrentStrike() {
		return currentStrike;
	}

	public void setCurrentStrike(iStrike currentStrike) {
		this.currentStrike = currentStrike;
	}

	public CarromBoard getCarromBoard() {
		return carromBoard;
	}

	public void setCarromBoard(CarromBoard carromBoard) {
		this.carromBoard = carromBoard;
	}

	public void performStrike() {
		System.out.println(currentPlayer.getPlayerName());
		this.currentStrike.doStrike(carromBoard, currentPlayer);
	}

	public void performFoulOperations() {
		if(this.currentPlayer.getFoulCount() == 3) {
			this.currentPlayer.decrementPointCount(1);
			this.currentPlayer.setFoulCount(1);
		}
		
		if(this.currentPlayer.getSuccessiveNonPocketCount() == 3) {
			this.currentPlayer.decrementPointCount(1);
			this.currentPlayer.setSuccessiveNonPocketCount(0);
			this.currentPlayer.setRecentNonPocket(false);
		}
	}
}
