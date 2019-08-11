package me.jysh.cleanstrike.pojos;

public class Player {
	private String playerName;
	private int pointCount;
	private int foulCount;
	private int successiveNonPocketCount;
	
	{
		pointCount = 0;
		foulCount = 0;
		successiveNonPocketCount = 0;
	}
	
	public Player() {
	}
	
	public Player(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getPointCount() {
		return pointCount;
	}

	public int getFoulCount() {
		return foulCount;
	}

	public int getSuccessiveNonPocketCount() {
		return successiveNonPocketCount;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setPointCount(int pointCount) {
		this.pointCount = pointCount;
	}

	public void setFoulCount(int foulCount) {
		this.foulCount = foulCount;
	}

	public void setSuccessiveNonPocketCount(int successiveNonPocketCount) {
		this.successiveNonPocketCount = successiveNonPocketCount;
	}

	public void incrementPointCount(int pointCount) {
		this.pointCount += pointCount;
	}

	public void decrementPointCount(int pointCount) {
		this.pointCount -= pointCount;
	}

	public void incrementFoulCount(int foulCount) {
		this.foulCount += foulCount;
	}

	public void decrementFoulCount(int foulCount) {
		this.foulCount -= foulCount;
	}

	public void incrementSuccessiveNonPocketCount(int successiveNonPocketCount) {
		this.successiveNonPocketCount += successiveNonPocketCount;
	}

	public void decrementSuccessiveNonPocketCount(int successiveNonPocketCount) {
		this.successiveNonPocketCount += successiveNonPocketCount;
	}
}
