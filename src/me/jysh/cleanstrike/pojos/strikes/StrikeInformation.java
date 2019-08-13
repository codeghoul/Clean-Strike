package me.jysh.cleanstrike.pojos.strikes;

import java.util.HashMap;
import java.util.Map;

public enum StrikeInformation {
	NORMAL_STRIKE("1", "pocket Black Coin."),
	MULTI_STRIKE("2", "pocket Multiple Black Coins."),
	RED_STRIKE("3", "pocket Red Coin."),
	STRIKER_STRIKE("4", "pocket Striker."),
	DEFUNCT_BLACK_COIN_STRIKE("5", "defunct Black Coin."),
	DEFUNCT_RED_COIN_STRIKE("6", "defunct Red Coin."),
	NO_STRIKE("7", "pocket nothing.");
	
	String strikeChoice;
	String strikeDescription;
	private static final Map<String, StrikeInformation> STRIKELOOKUP = new HashMap<>();
	
	StrikeInformation(String strikeChoice, String strikeDescription) {
		this.strikeChoice = strikeChoice;
		this.strikeDescription = strikeDescription;
	}
	
	static {
		for(StrikeInformation strike : StrikeInformation.values()) {
			STRIKELOOKUP.put(strike.getStrikeChoice(), strike);
		}
	}
	
	public String getStrikeChoice() {
		return strikeChoice;
	}

	public String getStrikeDescription() {
		return strikeDescription;
	}

	public static StrikeInformation getStrikelookup(String strikeChoice) {
		return STRIKELOOKUP.get(strikeChoice);
	}

	public void setStrikeChoiceNumber(String strikeChoice) {
		this.strikeChoice = strikeChoice;
	}

	public void setStrikeDescription(String strikeDescription) {
		this.strikeDescription = strikeDescription;
	}
}
