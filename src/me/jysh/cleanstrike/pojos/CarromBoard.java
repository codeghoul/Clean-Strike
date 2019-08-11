package me.jysh.cleanstrike.pojos;

public class CarromBoard {
	private int blackCoinCount;
	private int redCoinCount;
	
	{
		blackCoinCount = 9;
		redCoinCount = 1;
	}

	public int getBlackCoinCount() {
		return blackCoinCount;
	}

	public int getRedCoinCount() {
		return redCoinCount;
	}

	public void setBlackCoinCount(int blackCoinCount) {
		this.blackCoinCount = blackCoinCount;
	}

	public void setRedCoinCount(int redCoinCount) {
		this.redCoinCount = redCoinCount;
	}
	
	public void incrementBlackCoinCount (int blackCoinCount) {
		this.blackCoinCount += blackCoinCount;
	}
	
	public void decrementBlackCoinCount(int blackCoinCount) {
		this.blackCoinCount -= blackCoinCount;
	}
	
	public void  incrementRedCoinCount(int redCoinCount) {
		this.redCoinCount += redCoinCount;
	}
	
	public void decrementRedCoinCount(int redCoinCount) {
		this.redCoinCount -= redCoinCount;
	}
	
	public boolean hasBlackCoins() {
		return this.blackCoinCount > 0;
	}
	
	public boolean hasRedCoins() {
		return this.redCoinCount > 0;
	}

	public boolean isPlayable() {
		return blackCoinCount > 0 || redCoinCount > 0;
	}

	public void defunctCoin() {
		inputDefunctedCoin();
	}
	
}
