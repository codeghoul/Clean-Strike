package me.jysh.cleanstrike.pojos;

public class CleanStrikeGame {
	private Player currentPlayer;
	private iStrike currentStrike;
	private CarromBoard carromBoard;

	{
		carromBoard = new CarromBoard();
	}

	public CleanStrikeGame(Player currentPlayer) {
		super();
		this.currentPlayer = currentPlayer;
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
		this.currentStrike.doStrike(carromBoard, currentPlayer);
	}
}
