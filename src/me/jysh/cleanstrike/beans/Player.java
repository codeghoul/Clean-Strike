package me.jysh.cleanstrike.beans;

public class Player {
	private String playerName;
	private int pointCount;
	private int foulCount;
	private int successiveNonPocketCount;

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
}
